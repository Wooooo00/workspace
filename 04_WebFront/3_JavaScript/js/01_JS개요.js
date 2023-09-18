// 
/* js 파일을 script 태그 내부라고 생각하면 된다 */
function externalFn(){
   alert("외부 파일에 작성된 externalFn() 함수 호출되었습니다.")
} 

// JS 맛보기 
const body = document.querySelector("body"); // body 태그

function lightMode(){
   body.style.backgroundColor = "white";
   body.style.Color = "black";
}

function darkMode(){
   body.style.backgroundColor = "dark";
   body.style.Color = "white";
}
