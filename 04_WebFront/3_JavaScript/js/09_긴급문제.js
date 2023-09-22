// const inputwidth = document.getElementById("input-width");
// const inputFontsize = document.getElementById("input-fontsize");
// const inputFontColor = document.getElementById("input-fontcolor");
// const applyBtn = document.getElementById("apply-btn");

// applyBtn.addEventListener("click",function(){

//     console.log(applyBtn);
//     if(inputwidth.value == 0 || inputFontsize.value ==0){
//         alert("숫자를 입력해주세요");
//         return;
//     }


// });

document.getElementById("input-width").addEventListener('click', function(){
    const inputWidth = document.getElementById('input-width');
    this.style.width = inputWidth.value;
});
