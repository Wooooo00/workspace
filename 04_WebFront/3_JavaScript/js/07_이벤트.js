// 인라인 이벤트 모델

function inlineEventModel(btn) {
   console.log(btn);
   console.log(btn.style.backgroundColor); // 클릭한 요소의 배경색 얻어오기

   if (btn.style.backgroundColor != "pink") {
      btn.style.backgroundColor = "pink";
   } else {
      btn.removeAttribute("style");
   }
}

// 고전 이벤트 모델
// 아이디가 test2-1인 요소를 선택하여 변수에 저장해보기

const a = document.getElementById("test2-1");
// 요소.이벤트리스너 = 이벤트 핸들러


a.onclick = function () {
   alert("테스트2-1 클릭")
   // function(){} : 익명 함수(이벤트 핸들러로 많이 사용한다)
}
// 이벤트 제거
// test2-2 클릭 시 test2-1의 클릭 이벤트 제거
const b = document.querySelector("#test2-2")
b.onclick = function () {
   a.onclick = null;
   alert("#test2-1 클릭 이벤트 제거")
}

// 고전 이벤트 모델 단점
// 한 요소의 같은 이벤트 리스너에 여러 이벤트 핸들러를 대입할 수 없다


// #test2-3 클릭 시 버튼의 배경색을 yellow로 변경
// #test2-3 클릭 시 버튼의 글자 크기를 30px로 변경
const c = document.querySelector("#test2-3");
c.onclick = function () {
   c.style.backgroundColor = "yellow";
}
c.onclick = function () { }
c.style.fontSize = "30px";

// ------------------------------------------------------------------------------------------------------------------

// 표준 이벤트 모델
/* [작성법]
   요소.addEventListener("click," function() {});
                           이벤트명 이벤트 핸들러                           
*/

// 아이디가 test3인 요소에 click 했을 때 동작(이벤트)를 추가하겠다.
document.getElementById("test3").addEventListener("click", function () {

   // 클릭된 요소의 너비가 10px 증가

   // 고전/ 표준 이벤트 핸들러 내부에서 this : 이벤트가 발생한 요소
   console.log(this);

   //요소.clientWidth : 요소의 너비(테두리 제외)
   // css/style 속성으로 지정된 너비를 얻어올 때 사용
   console.log(this.clientWidth);

   // 요소.style.width : 요소의 스타일 속성 중 width의 값을 얻어옴
   // -> 요소 자체에 작성된 style 속성의 값을 얻어올 때 사용

   this.style.width = "500px"; // 현재 요소 너비 변경
   this.style.width = this.clientWidth + 50 + 'px';

});

document.getElementById("test3")
   .addEventListener("click", function (e) {

      console.log(e);
      console.log(e.target);
      e.target.style.height = e.target.clientHeight + 100 + 'px';

      // 이벤트 핸들러 매개 변수 e 또는 event 
      // -> 이벤트 객체(이벤트 관련 정보가 담긴 객체)가 전달됨
      // e.target : 이벤트가 발생한 요소
   });


   

document.getElementById("btn4")
   .addEventListener("click", function () {
      const box = document.getElementById("box4");
      const input = document.getElementById("input4");
      box4.style.backgroundColor = input4.value;
   });

const btn4 = document.getElementById("btn4");
const box4 = document.getElementById("box4");
const input4 = document.getElementById("input4");

btn4.addEventListener("click", function () {
});

input4.addEventListener('keyup', function (e) {
   // e : 이벤트 객체
   // e.target : 이벤트가 발생한 요소
   // console.log(e.key);
   console.log(e.key);

   if (e.key == "Enter") {
      box4.style.backgroundColor = e.target.value;
   }
});

// a 태그 기본 이벤트 제거 
document.getElementById("move").addEventListener("click", function (e) {

   // e : 이벤트 객체
   e.preventDefault(); // HTML 요소의 기본 이벤트 막음(제거)
});

/* form 태그 기본 이벤트 제거 */

// 방법1 : e.preventDefault()
// form 태그가 제출 되었을 때 
// document.getElementById("login").addEventListener("submit", function(e){
//   alert("로그인 되었습니다.");
// e.preventDefault();
// });

// 방법2 : 인라인 이벤트 모델 onsubmit 이용
function testFn() {
   const id = document.getElementById("input-id");
   const pw = document.getElementById("input-pw");

   // id,pw를 입력하지 않았을 때
   if (id.value.trim().length == 0 || pw.value().length == 0) {
      return false;
   }
   return true;
}

// 방법3 : 일반 버튼 클릭으로 제출 막기
// login-btn2 버튼이 클릭 되었을 때
const loginBtn2 = document.querySelector("#login-btn2");
loginBtn2.addEventListener("click", function () {

   const id = document.getElementById("input-id");
   const pw = document.getElementById("input-pw");

   if (id.value.trim().length != 0 && pw.value().length != 0) {
      // 문서 내에서 name 속성 값이 loginForm인 form 태그를 제출 시키겠다.
      document.loginForm.submit();
   }
});


const input = document.getElementById("count-input");
const createBtn = document.getElementById("create-btn");
const list = document.getElementById("list");
const calc = document.getElementById("calc");
const calcResult = document.getElementById("calc-result");

createBtn.addEventListener("click", function (){

   if (input.value < 0) {
      // ul#list$*Number("count-input");
      alert("1이상 입력하세요.");
      return;
   }

   list.innerHTML = '';

   for(let i=0; i<input.value; i++){
      list.innerHTML += '<li><input type="number" class="list-input"></li>';
   }
});

calc.addEventListener("click", function(){
   const inputList = document.getElementsByClassName("list-input");
   // list-input에서 읽어온 값을 innerText로 반환
   console.log(inputList);

   let sum = 0;

   for(let i=0; i<inputList.length; i++){
   // inputList[i] : 각각의 input 요소
   // inputList[i].value   
   if(inputList[i].value == "") {
      alert("입력되지 않은 빈칸이 존재합니다");

      // 입력되지 않은 빈칸으로 초점 이동
      inputList[i].focus();
      return;
   }   

   sum += Number(inputList[i].value);
   }
   // #calc-result 요소의 내용으로 합계(sum) 
  
   
});






