const check1 = document.getElementById("check1");

check1.addEventListener("click", () => {
   // 정규 표현식 객체 생성 
   // 1) new RegExp("정규표현식")
   let regEx = new RegExp("\d{3}"); // 연속적으로 작성된 숫자 3개

   // 2) /정규표현식/
   regEx = /\d{3}/; 

   // 패턴 일치 여부 확인
   const str1 = "정규표현식123";
   const str2 = "정규1표23현식";

   // 정규식객체.test(문자열) -> 패턴이 일치하면 true
   console.log(regEx.test(str1));
   console.log(regEx.test(str2));

   // 정규식객체.exec(문자열) -> 일치하는 패턴의 문자열 반환
   //                         -> 없으면 null 

   console.log(regEx.exec(str1));
   console.log(regEx.exec(str2));
});

// 메타 문자 확인하기
const check2 = document.querySelector("#check2");
check2.addEventListener("click", () => {

   // a(일반 문자열) : 문자열 내에 a라는 문자열이 존재하는 검색

   let regEx = /java/; // 문자열 내에 java가 존재하나 검색
   
   console.log(`javascript : ${regEx.test("javascript")}`);

   console.log(`jawascript : ${regEx.test("jawascript")}`);

   // [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자
   regEx = /[a-z][0-9][A-Z]/; 
   // 1번 : 영어소문자 / 2번 : 숫자 / 3번 : 영어대문자
   let str = "a3T"; 
   console.log(`${str} : ${regEx.test(str)}`);

   str = "^@a3T*%@"; 
   console.log(`${str} : ${regEx.test(str)}`);

   str = "b5q"; 
   console.log(`${str} : ${regEx.test(str)}`);

   // ^(캐럿) : 문자열의 시작을 의미
   // $(달러) : 문자열의 끝을 의미

   regEx = /^Hello[0-9]/;
   str = "Hello7 World";
   console.log(`${str} : ${regEx.test(str)}`);

   regEx = /^Hello[0-9]/;
   str = "Hello7 World";
   console.log(`${str} : ${regEx.test(str)}`);

   // \d : 아무 숫자를 의미 
   regEx = /\d\d\d$/; // 문자열 끝에 숫자가 3칸이 있는가
   
   str = "123456"
   console.log(`${str} : ${regEx.test(str)}`);

   // ^, $를 같이 사용하는 경우 
   // 문자열의 시작과 끝이 정해져있어 
   // 포함(X), 문자열의 전체적인 형태를 제한한다. 
   
   regEx = /^[a-z]TEST\d$/;

   str = "aTEST7";
   console.log(`${str} : ${regEx.test(str)}`);
});


// ------------------------------------------------------------




const inputName = document.getElementById("input-name");
const nameResult = document.getElementById("name-result");

inputName.addEventListener("keyup", () => {

   // 1) 2 ~ 15글자 사이로 지정 -> {2,15}
   // 2) 처음부터 끝까지 한글이어야 한다. -> ^한글$
   // 3) 단자음, 단모음은 제외한다. -> [가-힣] 
   // 4) 입력 받은 값이 유효한 형식이면 인풋 태그 아래 초록색 글씨로 "유효한 이름입니다." 
   // 6) 입력 받은 값이 잘못된 형식이면 인풋 태그 아래 "유효하지 않은 이름입니다."
   // 7) 아무런 값도 입력되어 있지 않다면 인풋 태그 아래 "한글 2 ~ 15자 사이 입력하세요."

   const regEx = /^[가-힣]{2,15}$/; 

   // 입력 받은 값
   const value = inputName.value.trim();
   inputName.value = value; //  좌우 공백이 제거된 값을 대입


   if(value.length == 0){
      nameResult.innerText = "한글 2 ~ 15자 사이 입력";
      nameResult.classList.remove("check");
      nameResult.classList.remove("error");
      alert("한글 2 ~ 15자 사이로 입력하세요");
      return;
   }
   console.log("Enter");

   // 정규식을 이용하여 검사
   if(regEx.test(value)){
      nameResult.innerText = "유효한 이름입니다.";
      nameResult.classList.add("check");
      nameResult.classList.remove("error");
      
   } else { 
      nameResult.innerText = "유효하지 않은 이름입니다.";
      nameResult.classList.add("error");
      nameResult.classList.remove("check")
   }

});

   const inputNumber = document.getElementById("input-number");
   const numberResult = document.getElementById("number-result");

   inputNumber.addEventListener("change", () => {
   const regEx = /^01[0,1,6,7,9]-\d{3,4}-\d{4}$/;

   // 공백 제거 
   const value = inputNumber.value.trim();
   inputNumber.value = value; 

   if(value.length == 0){
      numberResult.innerText = "번호를 입력해주세요";
      numberResult.classList.remove("check");
      numberResult.classList.remove("error");
      alert("번호를 입력해주세요");
      return;
   }
   console.log("Enter");
   if(regEx.test(value)){
      numberResult.innerText = "입력 완료";
      numberResult.classList.add("check");
      numberResult.classList.remove("error");
      alert("정상적으로 입력 되었습니다.");
      
   } else {
      inputNumber.value = "";
      numberResult.innerText = "다시 입력해주세요";
      numberResult.classList.add("error");
      numberResult.classList.remove("check")
      alert("다시 입력 하세요.");
      // " ";
   }
   });




