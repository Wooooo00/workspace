const applyBtn = document.getElementById("apply-btn");
applyBtn.addEventListener('')

const inputwidth = document.getElementById("input-width");
const inputFontsize = document.getElementById("input-fontsize");
const inputFontColor = document.getElementById("input-fontcolor");

// input에 따라 #box에 JS로 CSS에 추가

if(inputwidth.ariaValueMax.trim().length > 0){
    box.style.width = inputwidth.value();
}


// Js는 중간에 오류가 나면 밑에 있는 구문들도 해석이 되지 않기 때문에 
// 임의의 값을 대입해줘서 

