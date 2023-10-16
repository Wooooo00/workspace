<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSP import 구문(EL 쓰면 필요 없음) --%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>EL 결과 페이지</title>
</head>
<body>

   <h1>EL을 이용해서 파라미터 출력하기</h1>
   <h4>${param.inputDate}</h4>   

   <hr>

   <h1>EL을 이용해서 세팅된 속성(Attribute)값 출력하기</h1>
   <ul>
      <li>[작성법] : \${ key }</li>
      <li>기본 자료형 : ${ score }</li>
      <li>String(객체) : ${ address }</li>
      <li>
      
         List(객체) : ${ strList }
         <ul>
         <li><%= ((List)request.getAttribute("strList")).get(0) %></li>
         
         <li>${strList[0]}</li>
         <li>${strList[1]}</li>
         <li>${strList[2]}</li>
         <li>${strList[3]}</li>
         </ul>
      </li>

      <li>
         DTO(객체) : ${ b1 }</li>
         <ul>
            <li>title : </li>
            <li>title : ${b1.getTitle()}</li>

            <%-- ${key.필드명} : getter 자동으로 호출하여 값을 얻어온다--%>
            <li>title : ${b1.title}</li>
            <li>writer : ${b1.writer}</li>
            <li>price : ${b1.price}</li>
         </ul>
   </ul>

   <hr><hr><hr>

   <h1>empty 연산자</h1>
   <pre>
      - \${empty 객체 또는 배열 또는 리스트}

      - null 또는 빈칸 또는 비어있으면 true 
      아니면 false 반환

      - EL은 null을 빈칸으로 표현
      - null == " " (빈칸) == 비어있는 경우(출력할 게 없어서 빈칸)
   </pre>

   <ul>
      <li> test1 = null; ${empty test1}</li>
      <li> test2 = ""; ${empty test2}</li>
      <li> test3 = null; ${empty test3}</li>
      <li> test4 = new ArrayList<String>(); -> ${empty test4}</li>
      <li>test5 = new ArrayList<String>(); + add() -> ${empty test5}</li>
   </ul>
</body>


</html>