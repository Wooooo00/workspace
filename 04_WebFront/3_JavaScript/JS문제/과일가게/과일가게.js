// "check" 클래스를 가지고 있는 것들만 count에 포함해서
// 결과로 출력

const inputApple = document.getElementById("apple");
const inputBanana = document.getElementById("banana");
const inputMelon = document.getElementById("melon");
const countBtn = document.getElementById("count-button");

countBtn.addEventListener("click", () => { 
   
   const checks = document.querySelectorAll("[name = 'check']:checked");   
   // const checks = document.querySelectorAll(".check:checked");   
   
   let sum = 0;
   let str = "";

   for(let c of checks){ // for(let A of B ) B에서 하나씩 꺼내 돌리겠다.
      const price = c.value;
      const amount = c.parentElement.nextElementSibling.value;
      const type = c.parentElement.nextElementSibling.getAttribute('id');

      // console.log(c.value);
      // console.log(c.parentElement.nextElementSibling.value);
      
      switch(type){
      case "apple" : str += "사과 "; break;
      case "banana" : str += "바나나 "; break;
      case "melon" : str += "메론 "; break;
      }

      str += amount +"개 ";

      sum += price * amount;
   }

   // console.log(str);
   // console.log(sum);
   
   const result = document.getElementById("result");
   result.innerText = str + " 총합 " + sum + "원" ;

});




   
   
   




