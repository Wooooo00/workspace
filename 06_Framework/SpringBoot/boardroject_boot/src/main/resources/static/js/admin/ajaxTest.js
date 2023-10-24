const inputMemberNo = document.getElementById("inputMemberNo"); 
const selectMemberNo = document.getElementById("selectMemberNo"); 
const result1 = document.getElementById("result1"); 

// 조회 버튼 클릭 시
selectMemberNo.addEventListener("click", () => {

   
   // fetch() API를 이용한 GET 방식 요청 // 
   // GET : 조회(SELECT) 
   // querystring(쿼리스트링) : 주소에 담겨진 파라미터를 지칭하는 문자열
   // ?로 시작 ?key=value&?key=value(띄어쓰기가 없어야 됨) 
   // 
   
   // 요청에 대한 응답이 돌아 왔을 때 수행
   fetch("/ajax/selectMemberNo?memberNo=" + inputMemberNo.value)
   .then((response) => { // response : 응답이 담겨져있는 객체(promise)
      console.log; // promise 객체를 확인 할 수 있다
      return response.text(); // promise에 담긴 응답 결과를 text 형태로 파싱 후, 반환
   
   })
   
   .then( (email) => { 
      console.log("email : " + email);
      // 응답 결과(email)이 존재하는 경우
      // 있으면 : 이메일 문자열
      // 없으면 : 빈칸 

      if(email == ''){
         result1.innerText = "일치하는 회원이 없습니다";

      } else{
         result1.innerText = email;
      }
   })

   // 비동기 통신 중 예외 발생 시 수행
   .catch((e) => {
      console.log;
   })


   });

   const inputEmail = document.getElementById("inputEmail");
   const btn2 = document.getElementById("btn2");
   const result2 = document.getElementById("result2");

   btn2.addEventListener("click", () => {


      fetch("/ajax/selectEmail?inputEmail="+ inputEmail.value)
      // 응답이 왔을 때 수행, 응답 결과를 text로 파싱 // 매개변수 1개면 소괄호 생략 가능
      .then( response => response.text() ) 
      
      
      
      // 첫 번째 then의 반환된 결과를 이용해 기능 수행

      .then( (tel) => {
         if(tel == ' '){
            result2.innerText = '이메일이 일치하는 회원이 존재하지 않습니다';
         }  else{
            result2.innerText = tel;
         }
      } )

      .catch( e => console.log(e) ); // 예외 발생 시 수행

   });

   // 회원 정보가 일치하는 회원 정보 모두 조회
   
const memberNo2 = document.getElementById("inputMemberNo2");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

   btn3.addEventListener('click', () => {

      fetch("/ajax/selectMember?no="+memberNo2.value)
      
      // 응답 데이터가 JSON인 경우 JS 객체로 파싱
      .then( resp => resp.json() ) // JS 객체 반환 또는 예외 발생

      .then( (member) => { 
         result3.innerHTML = ""; // #result3 내용 삭제

         const ul = document.createElement("ul");

         for(let key in member) {
         //   console.log(`${key} : ${member[key]}`);
            const li = document.createElement("li");
            li.innerText = `${key} : ${member[key]}`;
            ul.append(li);
         }

         result3.append(ul);
      

      } )

      .catch( e => {
         result3.innerHTML = '';
         const h4 = document.createElement("h4");
         h4.innerText = "일치하는 회원이 존재하지 않습니다.";

         result3.append(h4);
      });
});


// 문자열을 입력 받아 일부라도 일치하는 모든 이메일 조회

const input4 = document.getElementById("input4");
const btn4 = document.getElementById("btn4");
const result4 = document.getElementById("result4");

   btn4.addEventListener("click", () => {
      fetch("/ajax/selectEmailList?keyword=" + input4.value)
      .then( resp => resp.json()) // List 객체 -> JSON Array -> JS 객체 배열 변환
      .then( emailList => {
         //console.log(emailList);

         result4.innerHTML = "";

         if(emailList.length == 0) {

            const tr = document.createElement("tr")
            const th = document.createElement("th")
            th.innerText = "조회 결과가 없습니다";

            tr.append(th);

            result4.append(tr);
         }  else { // 조회 결과가 있을 때

            // JS의 향상된 for문 for .. of
            for(let email of emailList) {

               const tr = document.createElement("tr")
               const td = document.createElement("td")
               td.innerText = email;

               // td 클릭 시 해당 이메일 회원 정보 상세 조회 페이지로 이동

               td.addEventListener("click", e => {
                  location.href="/admin/selectMember?inputEmail=" + e.target.innerText;

               });

               tr.append(td);

               result4.append(tr);

            }
         }
      } )
      .catch( e => console.log(e));
   });







