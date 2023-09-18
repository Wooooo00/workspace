const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const result = document.getElementById("result");

// 연산자 버튼 클릭 시 동작
// 매개 변수 btn (btn == 클릭된 버튼 자체(this))
function calc(btn) {

   // 클릭한 버튼에 작성된 연산자를 얻어와 op 변수에 저장
   const op = btn.innerText; 

   v1 = Number(input1.value); // 입력 숫자 1
   v2 = Number(input2.value); // 입력 숫자 2

   
   // 1. eval("코드 형식의 문자열")
   // -> 매개 변수의 문자열을 JS 코드로 변환해서 해석하는 함수
   // -> 속도 + 보안의 문제로 잘 사용하지 않는다

   // result.innerText = eval(v1 + op + v2); 

   // 2. new Function("return 코드 형식의 문자열")();
   // -> 새 함수를 만들어서 바로 실행
   // -> 실행 되는 함수의 내용은 첫 번째 ()에 작성된 코드 형식의 문자열

   result.innerText
   = new Function(" return " + v1 + op + v2)();
}
   
   
   


