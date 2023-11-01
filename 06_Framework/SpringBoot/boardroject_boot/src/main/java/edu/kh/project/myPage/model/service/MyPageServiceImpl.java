package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
@PropertySource("classpath:/config.properties")
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	private MyPageMapper mapper;
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Value("${my.member.webpath}")
	private String webpath;

	@Value("${my.member.location}")
	private String folderPath;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		// TODO Auto-generated method stub
		
		// 주소 가공
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
			
		} else {
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
			
		}
		
		return mapper.info(updateMember);
	}
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(currentPw, encPw)) {
			// 현재 비밀번호와 조회한 비밀번호가 다른 경우
			return 0;
		
		} else { 
			
			// 같으면 새 비밀번호 변경
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newPw", bcrypt.encode(newPw));
	    map.put("memberNo", memberNo);
	    
	    return mapper.changePw(map);
		}
		
	}
		
	@Override
	public int secession(String memberPw, int memberNo) {
		// TODO Auto-generated method stub
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(memberPw, encPw)) {
			return 0;
		} return mapper.secession(memberNo);
		
	}
		
			// 현재 비밀번호와 조회한 비밀번호가 다른 경우
		
	@Override
			public int profile(MultipartFile profileImg, Member loginMember) throws IllegalStateException, IOException {
				// TODO Auto-generated method stub
		
				// 프로필 이미지 변경 실패 대비(이전 프로필 이미지 경로 저장)
				String backup = loginMember.getProfileImg();
				
				// 변경된 파일명을 저장할 변수 선언
				
				// 파일명을 변경하는 이유는 중복되는 파일명이 생겼을 때 
				// 이전 파일을 덮어씌우다 삭제 되는 것을 방지하기 위함
				
				String rename = null;
				
				// (중요) 업로드된 이미지가 있을 경우를 검사 
				
				// 문자열 데이터 -> 데이터 != null (null을 이용해서 비교)
				
				// 파일 데이터(업로드 안 되어도 MultiopartFile 객체가 생성 된다)
				// -> 업로드 된 파일의 크기를 이용하여 비교
				// -> 파일.getSize() > 0 
				
				if(profileImg.getSize() > 0) {
					// 1) 파일명 변경
					 
					rename = Util.fileRename(profileImg.getOriginalFilename());
					// 2) 바뀐 파일명 + 경로를 loginMember 세팅
					
					loginMember.setProfileImg(webpath + rename);
					
				} else { // 업로드 된 파일이 없다면 -> 기본 이미지로 변경
					
					loginMember.setProfileImg(null);
					
				}	
					
				//	@Value("${my.member.webpath}")
				// 
				
				int result = mapper.profile(loginMember);	
				
				// DB 업데이트 성공 시
				// 메모리에 임시 저장 된 파일을 지정된 경로에 저장
				if(result > 0) {
					if(profileImg.getSize() > 0) {
						
						// 파일.transferTo(파일 경로)
						// 메모리에 저장된 파일을 지정된 경로에 옮김(저장)
						
						profileImg.transferTo(new File(folderPath + rename));
						
						} 
					
					} else { // DB
						
						loginMember.setProfileImg(backup);
	
				}
				
				return result;
			}		
		
	}
