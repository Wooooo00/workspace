package edu.kh.project.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

/*  @Mapper 어노테이션
 * 	- 해당 인터페이스의 메서드명과
 * 		mapper.xml에 작성된 태그 아이디가
 * 		같은 것끼리 연결해주는 어노테이션
 * 	
 *  - sqlSessionTemplate bean을 의존성 주입 받는 코드를 별도로 작성하지 않는다.
 *    (작성 안 해도 Spring이 알아서 불러와서 사용함)
 *    
 *    namespace.id 형식으로 mapper를 찾는 구문을 별도 작성 X
 *    (메서드 이름이 곧 id)
 *    
 *  - select, insert, update 메서드 구분 필요 X
 *  	(mapper의 태그를 보고 구분) 
 *  
 *    *** 주의 사항 *** 
 *    해당 인터페이스와 연결할 mapper.xml 파일의 
 *    namespace 속성 값을 현재 인터페이스의 패키지명.인터페이스명으로 작성해야 된다.
 *    이렇게 해야 연결 가능	 
 */

@Mapper
public interface MemberMapper {
	Member login(Member inputMember);
}
