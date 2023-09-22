// 유효성 검사 여부를 체크하는 객체 생성

// JS 객체 : {K : V, K : V , ....}

// JS 객체 다루는 방법
// checkList.["key"]; (GET)
// checkList["Key"]; (set)

const checkList = {
   "input-id" : false,
   "input-pw" : false,
   "input-pw-check" : false,
   "input-name" : false
};

const signupForm = document.signupForm;
const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwcheck = document.getElementById("input-pw-check");
const inputName = document.getElementById("input-name");

const inputList = document.querySelectorAll(".signup-input");

// ---------------------------------------------------------------

// 아이디 유효성 검사
inputId.addEventListener( "input", e => {
   
   const val = inputId.value.trim();
   const span =   e.target.nextElementSibling.nextElementSibling;
  
   if(val.length === 0 ) { // 입력된 값이 없을 경우
      span.innerText = "영어, 숫자, - , _ 6 ~ 16글자 사이";
      span.classList.remove("check");
      span.classList.remove("error");
      checkList["input-id"] = false;
      return;
   }

   // 정규표현식 객체 생성
   const regEx = /^[A-Za-z\d\-\_]{6,16}$/;

   if(regEx.test(val)){
      span.innerText = "유효한 아이디 형식입니다";
      span.classList.add("check");
      span.classList.remove("error");
      checkList["input-id"] = true;
   
   } else { 
      span.innerText = "유효하지 않습니다";
      span.classList.add("error");
      span.classList.remove("check");
      checkList["input-id"] = false;
   }

});

// -------------------------------------------------------------------------

// 비밀번호 유효성 검사 

inputPw.addEventListener( "input", e => {

   const val = e.target.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   e.target.value = val; // 

   // if(val.length == 0 || checkVal == 0)
   if(val.length == 0) { // 입력된 값이 없을 경우
      span.innerText = "영어,숫자,!@#$%^&* 8 ~ 20 글자 사이";
      span.classList.remove("check");
      span.classList.remove("error");

      // 유효성 검사 여부 저장 객체에서
      // "input-id"의 값을 false 변경(유효하지 않음를 뜻한다)
      checkList["input-pw"] = false;
      return;
   }

   // 정규 표현식 
   const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,20}$/;

   //  ^ (?=.*[A-Za-z]) (?=.*\d) (?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&] {8,20} $
   // 

   if(regEx.test(val)){
      span.innerText = "유효한 비밀번호 형식입니다";
      span.classList.add("check");
      span.classList.remove("error");
      checkList["input-pw"] = true;
      
   } else { 
      span.innerText = "유효하지 않습니다";
      span.classList.add("error");
      span.classList.remove("check");
      checkList["input-pw"] = false;
   }

   checkPwFn();
});


// 비밀번호 확인 
inputPwcheck.addEventListener("input", e => {
   const span = e.target.nextElementSibling.nextElementSibling;

   // 비밀번호에 입력된 값이 유효한 경우
   // #input-pw의 다음, 다음의 형제 요소(span)에 check 클래스가
   // 존재할 때 

   const pwSpan = inputPw.nextElementSibling.nextElementSibling.nextElementSibling;

   // contains(클래스명) : 클래스가 존재하면 true 
   if(!pwSpan.classList.contains("check")){
      span.innerText = "유효한 형식의 비밀번호를 먼저 입력하세요"
      span.classList.add("error");
      span.classList.remove("check");
      return; // 유효성 검사를 진행하지 않겠다

   }
   const val = e.target.value.trim();
   e.target.value = val;

   if(val.length === 0) {
      span.innerText = "비밀번호를 먼저 입력하세요";
      span.classList.remove("check");
      span.classList.remove("error");
      return;
   }

   const pwVal = inputPw.value;
   if(val === pwVal) {
      span.innerText = "비밀번호가 일치합니다";
      span.classList.add("check");
      span.classList.remove("error");
   } else {
      span.innerText = "비밀번호가 일치하지 않습니다";
      span.classList.add("error");
      span.classList.remove("check");

   }

   
});


// 
function checkPwFn(){
   const span = inputPwcheck.nextElementSibling.nextElementSibling;

   // 비밀번호, 비밀번호 확인값 얻어와 변수에 저장한다
   const pwVal = inputPw.value.trim();
   const checkVal = inputPwcheck.value.trim();

   if(pwVal.length == 0 ){ // 비밀번호 미입력 했을 때
      span.innerText = "비밀번호를 입력해주세요";
      span.classList.remove("check");
      span.classList.remove("error");
      
      checkList["input-pw-check"] = false;
      return;
   }

   if(pwVal === checkVal){
      span.innerText = "비밀번호 일치";
      span.classList.add("check");
      span.classList.remove("error");
      checkList["input-pw-check"] = true;
   } else{
      span.innerText = "비밀번호 불일치";
      span.classList.add("error");
      span.classList.remove("check");
      checkList["input-pw-check"] = false;

   }
}

// 이름 유효성 검사 

inputName.addEventListener( "input", e => {
   
   const val = inputName.value.trim();
   const span =   e.target.nextElementSibling.nextElementSibling;
  
   if(val.length === 0 ) { // 입력된 값이 없을 경우
      span.innerText = "한글 2 ~ 15";
      span.classList.remove("check");
      span.classList.remove("error");
      checkList["input-name"] = false;
      return;
   }

   // 정규표현식 객체 생성
   const regEx = /^[가-힣]{2,15}$/;

   if(regEx.test(val)){
      span.innerText = "유효한 이름 형식입니다.";
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-name"] = true;
   
   } else { 
      span.innerText = "유효하지 않은 이름입니다.";
      span.classList.add("error");
      span.classList.remove("check");

      checkList["input-name"] = false;
   }

});

//  form 태그 제출 했을 때
signupForm.addEventListener("submit", e => {
   alert("test");
   /* 객체 전용 향상된 for 문 : for(let key in 객체명)
   -> 객체가 가지고 있는 key 값을 순서대로 하나씩 key에 대입 
   */ 
  for(let key in checkList){
   console.log(key);

   if( !checkList[key]){ // 유효하지 않은 입력이 있을 경우
      
      let str;
      switch(key){
      case "input-id" : str = "아이디가"; break;
      case "input-id" : str = "비밀번호가"; break;
      case "input-pw-check" : str = "비밀번호 확인이"; break;
      case "input-name" : str = "이름이"; break;
      }
      alert(str + "유효하지 않습니다");
      e.preventDefault(); // form 제출 막기

      document.getElementById(key).focus();
      return;
   }

  } // for in 끝
  
//   e.preventDefault();

// 성별 선택 여부 검사
  if(document.querySelector("[name = 'gender']:checked") == null){
   alert("성별을 선택해주세요");
   e.preventDefault();
   document.querySelector("[name='gender']").focus();
  }
});




// inputPw.addEventListener("change", e => {


// });