// 인풋 6 버튼 2개 
const inputBlank = document.getElementById("input-blank");
const createBtn = document.getElementById("create-btn");
const sumBtn = document.getElementById("sum-btn");

const container = document.getElementsByClassName("container")[0];


createBtn.addEventListener("click", () => {

   container.innerHTML = "";

   console.log(inputBlank.value);
   
   for(let i = 0; i<inputBlank.value; i++){
      
      const row = document.createElement("div");
      row.classList.add("row");
      container.append(row);


      const input = document.createElement("input");
      input.classList.add("input-number");
      input.setAttribute("type","number");
      
      row.append(input);

   }
});

   // innerHTML 

sum
sumBtn.addEventListener("click", () => {

      for(let i = 0; i< )




});


  
// 생성 버튼 클릭 -> input-blank에 입력된 값 불러오기 createBtn("click", () => {})
// inputBlank.value만큼 빈칸 생성 




