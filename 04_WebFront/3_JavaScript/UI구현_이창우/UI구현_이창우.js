const checkList = {
   "input-id" : false,
   "input-pw" : false,
   "input-pw-check" : false,
 };

const signupForm = document.signupForm;
const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCheck = document.getElementById("input-pw-check");
// const inputEmail = document.getElementById("input-email");
// const inputAddress = document.getElementById("input-address");

const inputList = document.querySelectorAll(".signup-input");


// inputEmail.addEventListener("input", () => {
   
//    const regEx = /^[A-Za-z\d\@\.]{3,50}$/;

// });



// inputAddress.addEventListener("input", () => {
   
//    const regEx = /^[A-Za-z\d\@\.]{3,50}$/;
// });




inputId.addEventListener( "input", e => {
   
   const val = inputId.value.trim();
   const span =   e.target.nextElementSibling;

   inputId.val = val;
  
   if(val.length === 0 ) { // 입력된 값이 없을 경우
      span.innerText = "필수 입력 항목입니다.";
      span.classList.remove("check");
      span.classList.remove("error");
      checkList["input-id"] = false;
      return;
   }

   const regEx = /^[A-Za-z\d\-\_]{6,16}$/;

   if(regEx.test(val)){
      span.innerText = "유효한 아이디 형식입니다";
      span.classList.add("check")
      span.classList.remove("error");
      checkList["input-id"] = true;

   } else { 
      span.innerText = "유효하지 않습니다";
      span.classList.add("error");
      span.classList.remove("check");
      checkList["input-id"] = false;
      
   }

});


inputPw.addEventListener( "input", e => {

   const val = inputPw.value.trim();
   const span = e.target.nextElementSibling;

   e.target.value = val; 

   
   if(val.length === 0) { 
      span.innerText = "영문자, 대,소문자 특수문자 숫자 포함 8 ~ 32 자를 입력해주세요";
      span.classList.remove("check");
      span.classList.remove("error");

      checkList["input-pw"] = false;

      PwCheckFn();
      return;
   }

   // 정규 표현식 
   const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,32}$/;

   if(regEx.test(val)){
      span.innerText = "유효한 비밀번호 형식입니다";
      span.classList.add("check");
      span.classList.remove("error");
   
      
   } else { 
      span.innerText = "유효하지 않습니다";
      span.classList.add("error");
      span.classList.remove("check");
      
      checkList["input-pw"] = false;
   }

   PwCheckFn();

   
});

inputPwCheck.addEventListener('input', e => {

 
   const pwSpan = inputPw.nextElementSibling;
 
   const span = e.target.nextElementSibling;
   
   // contains(클래스명) : 클래스가 존재하면 true , 없으면 false
   if(!pwSpan.classList.contains("check")){
     span.innerText = "유효한 형식의 비밀번호를 먼저 입력해주세요";
     span.classList.add("error");
     span.classList.remove("check");
 
     checkList["input-pw-check"] = false; 
 
     return; 
   }
 
   const val = e.target.value.trim();
   e.target.value = val;
 
   if(val.length === 0){
     span.innerText = "비밀번호를 먼저 입력 해주세요";
     span.classList.remove("check");
     span.classList.remove("error");
     
     checkList["input-pw-check"] = false; 
     return;
   }
 
 
   const pwVal = inputPw.value;
 
   if(val === pwVal){ 
     span.innerText = "비밀번호가 일치합니다";
     span.classList.add("check");
     span.classList.remove("error");
 
     checkList["input-pw-check"] = true; 
 
   } else{
     span.innerText = "비밀번호 불일치";
     span.classList.add("error");
     span.classList.remove("check");
 
     checkList["input-pw-check"] = false; 
   }
 
 });
 
 
 
 function PwCheckFn(){
   const span = inputPwCheck.nextElementSibling;
 
   
   const pwVal = inputPw.value.trim();
   const checkVal = inputPwCheck.value.trim();
 
   if(pwVal.length == 0 || checkVal.length == 0){ // 비밀번호 미입력 시
     span.innerText = "비밀번호를 먼저 입력 해주세요";
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

   signupForm.addEventListener('submit', e => {
      
            for(let key in checkList){

               if( !checkList[key] ){ 
                  
                  let str;

                  switch(key){
                  case "input-id" : str = "아이디를 다시 입력하여 주세요"; break;
                  case "input-id" : str = "비밀번호를 다시 입력해주세요"; break;
                  case "input-pw-check" : str = "비밀번호가 맞지 않습니다"; break;              
                  }
                  
                  e.preventDefault(); 
            
                  document.getElementById(key).focus();
                  return;
               } 
            }

   });

