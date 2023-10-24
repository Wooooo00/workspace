<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>스텝</title>
</head>
<body>

<table border="1">
      <tr>
         주문자명 <input type="text">
         <th>회원번호</th>
         <th>회원아이디</th>
         <th>회원나이</th>
      </tr>

      <tr th: object="${user}">
         <th th:text="*{userNo}"></th>
         <th th:text="*{userId}"></th>
         <th th:text="*{userName}"></th>
         <th th:text="*{userAge}"></th>

      </tr>
   
</body>
</html>