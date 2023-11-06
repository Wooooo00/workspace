package edu.kh.project.board.controller;

import java.io.IOException; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.board.model.service.EditBoardService;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor    
@RequestMapping("editBoard")
@SessionAttributes({"loginMember"})

public class EditBoardController {
	
	private final EditBoardService service;
	
	private final BoardService boardService;
	
	@GetMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}/delete")
	public String deleteBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,   
			@SessionAttribute(value="loginMember", required=false) Member loginMember, 
			RedirectAttributes ra
//			@RequestHeader("referer") String referer
			){ 
		
		
		if(loginMember == null) {
			ra.addFlashAttribute("message", "로그인 후 이용해주세요");
			return "redirect:/member/login";
			
		}
		
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("boardCode", boardCode);
		paramMap.put("boardNo", boardNo);
		paramMap.put("memberNo", loginMember.getMemberNo());
		
		int result = service.deleteBoard(paramMap);
		
		String path = null;
		String message = null;
		
		if(result > 0) {
			
			message = "삭제 되었습니다";
			path = "redirect:/board/" + boardCode; 
			
		} else {
			
			message = "삭제 실패";
			
			path = "redirect:/";
			
			// 이전 요청 페이지로 리다이렉트			
	// 		path = "redirect:" + referer;
			
		}
 		
		ra.addFlashAttribute("message", message);
		
		return path;
		
	}
	
	
	@GetMapping("{boardCode:[0-9]+}/insert")
	
	public String insertBoard(
			@PathVariable("boardCode") int boardCode,
			@SessionAttribute(value="loginMember", required=false) Member loginMember) {
			
		if(loginMember == null) {
			return "redirect:/board/" + boardCode;
		} 
		
		return "board/boardWrite";
		
	}
	
	/** 게시글 작성(게시글 작성 + 파일 0~5개 업로드)
	 *  @param boardCode : 게시판 코드
	 *  @param loginMember : 로그인한 회원 정보	 
	 *  @param board : 파라미터가 담긴 커맨드 객체 ModelAttribute 생략된 형태, 게터 필요 
	 *  @param images : 제출된 input type="file" name="images" 파라미터 묶음
	 *  			주의사항 : 제출된 파일이 없어도 input 수만큼 List 요소 존재 
	 *  @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	@PostMapping("{boardCode:[0-9]+}/insert")	
	public String insertBoard(
			@PathVariable("boardCode") int boardCode,
			@SessionAttribute("loginMember") Member loginMember,
			Board board, 
			@RequestParam("images") List<MultipartFile> images,
			RedirectAttributes ra
			) throws IllegalStateException, IOException {
		
			// 로그인한 회원의 번호, 게시판 코드를 
			// 커맨드 객체 board에 세팅
		
			board.setBoardCode(boardCode);
			board.setMemberNo(loginMember.getMemberNo());
			
			// 서비스 호출하고 결과 반환 받기
			
			int boardNo = service.insertBoard(board, images);	
			
			// 게시글 작성 성공 시 
			// 지금 작성한 글의 상세 조회 화면으로 리다이렉트 
			// /board/{boardCode}/{boardNo}
			
			if(boardNo > 0) {
				
				ra.addFlashAttribute("message", "게시글 작성 성공");
				return String.format("redirect:/board/%d/%d", boardCode, boardNo);
			}
			
			// 실패 
			ra.addFlashAttribute("message", "게시글 작성 실패");
			return "redirect:insert";
		
		
	}
	
	
	/** 게시글 수정 화면으로 전환
	 * @return
	 */
	
	@GetMapping("/{boardCode:[0-9]+}/{boardNo:[0-9]+}/update")
	public String updateBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model) {
		
		// 게시글 수정 화면에는 수정하려는 게시글의 상세 내용(제목, 내용, 업로드 했던 이미지)가 작성 되어 있어야 한다
		// -> 게시글 상세 조회
		Map<String, Object> map = new HashMap<>();
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
 		
		Board board = boardService.boardDetail(map);
		
		model.addAttribute("board", board);
		
		
		return "board/boardUpdate";
	}
	
	/**
	 * @param boardCode
	 * @param boardNo
	 * @param board : 커맨드 객체
	 * @param querystring : 쿼리스트링 유지용 파라미터
	 * @param deleteOrder : 삭제된 이미지 순서
	 * @param images : 제출된 file 요소 모음
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	@PostMapping("/{boardCode:[0-9]+}/{boardNo:[0-9]+}/update")
	public String updateBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Board board,
			String querystring,
			String deleteOrder,
			@RequestParam("images") List<MultipartFile> images,
			RedirectAttributes ra
			
			) throws IllegalStateException, IOException {
		
		// 1. 커맨드 객체에 파라미터 세팅
		board.setBoardCode(boardCode);
		board.setBoardNo(boardNo);
		
		// 2. 게시글 수정 서비스 호출
		int result = service.updateBoard(board, images, deleteOrder);
		
		String message = null;
		String path = null;
		
		if(result > 0) {
			message = "게시글 수정 완료";
			path = String.format("redirect:/board/%d/%d%s", boardCode, boardNo, querystring);
			
		} else {
			message = "게시글 수정 실패";
			path = "redirect:update";
			
		}
		
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	
	
	
	
	

	
		
}

