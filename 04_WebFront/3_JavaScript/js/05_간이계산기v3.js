const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const result = document.getElementById("result");

// 연산자 버튼 클릭 시 동작
// 매개 변수 btn (btn == 클릭된 버튼 자체(this))
function calc(btn) {
   console.log(btn);
   console.log(btn.innerText);

   // 클릭한 버튼에 작성된 연산자를 얻어와 op 변수에 저장
   const op = btn.innerText; 

   v1 = Number(input1.value);
   v2 = Number(input2.value);
}

// switch문을 이용하여 op 매개 변수 값에 따라 결과 도출
let res;

switch(op) {

case '+' : res = v1 + v2; break;
case '-' : res = v1 - v2; break;
case '*' : res = v1 * v2; break;
case '/' : res = v1 / v2; break;
case '%' : res = v1 % v2; break;

   result.innerText = res;
}



