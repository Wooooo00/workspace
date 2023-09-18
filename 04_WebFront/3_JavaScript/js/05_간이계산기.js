const blank1 = document.getElementById("input1");
const blank2 = document.getElementById("input2");
const result = document.getElementById("result");

// document.querySelector() css 선택자


function plus() {
   // 입력 요소.value : 입력 요소에 작성된 값 반환(String)
   console.log(blank1.value); 
   console.log(blank2.value);
   console.log(Number(blank1.value) + Number(blank2.value)); // input -> 문자열

   // 요소.innerText : <시작> 내용 </종료> , 내용에 글자 대입
   result.innerText = Number(blank1.value) + Number(blank2.value);
}
   // Number("1234") == 1234 (숫자로 변환 시켜준다.)
function minus() {
   console.log(blank1.value);
   console.log(blank2.value);
   console.log(Number(blank1.value) - Number(blank2.value));
   result.innerText = Number(blank1.value) - Number(blank2.value);
}

function multi() {
   console.log(blank1.value);
   console.log(blank2.value);
   console.log(Number(blank1.value) * Number(blank2.value));
   result.innerText = Number(blank1.value) * Number(blank2.value);
}

 
function div() {
   console.log(blank1.value);
   console.log(blank2.value);
   console.log(Number(blank1.value) / Number(blank2.value));
   result.innerText = Number(blank1.value) / Number(blank2.value);
}

function mod() {
   console.log(blank1.value);
   console.log(blank2.value);
   console.log(Number(blank1.value) % Number(blank2.value));
   result.innerText = Number(blank1.value) % Number(blank2.value);
}
   
const sumFn = function 함수명(n1, n2){return n1 + n2;}

               function calculator(input1, input2){return Number(blank1.value) Number(blank2.value)}
   




