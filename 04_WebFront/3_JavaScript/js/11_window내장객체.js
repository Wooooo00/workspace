// [window.]setTimeout(함수, 지연시간(ms))

const test1 = document.querySelector("#test1");

test1.addEventListener("click", () => {
   //window.setTimeout
   // setTimeout()은 비동기로 동작
   // -비동기-
   // 현재 코드를 수행할 때 다음 코드가 기다리지 않고 동시 수행

   console.log("0초");

   setTimeout( () => {
      console.log("1초");
   }, 1000);

   
   setTimeout( () => {
      console.log("2초");
   }, 2000);

   setTimeout( ()=>{
      console.log("3초 후에 실행된 log");
   }, 3000); // 3000(ms) = 3s

   console.log("setTimeout()종료 후에 실행될까?");
});

// [window.]setInterval(함수,지연시간)
const target2 = document.getElementById("target2");
const test2 = document.querySelector("#test2");

// test2 클릭하면 target2의 내용을 1씩 증가
test2.addEventListener("click", () => {

   setInterval(() => {
      ++target2.innerText;
   }, 1000);

   //추가 클릭으로 무분별한 인터벌 생성을 막는 방법

   // 1)버튼 비활성화 -> 
   test2.disabled = true;
   // 2) 
});

const stopwatch = document.getElementById("stopwatch");
const startbtn = document.getElementById("start");
const stopbtn = document.getElementById("stop");

let stopwatchInterval; // star 버튼 클릭하면 생성되는 setInterval을 저장할 변수

// start 
startbtn.addEventListener("click", () => {

   clearInterval(stopwatchInterval);
   let count = 0; // 클릭 후 지난 시간을 세기 위한 변수
   // count == 1 == 0.01s
   // count == 100 == 1s
   // count == 1000 == 10s
   stopwatchInterval = setInterval( ()=>{
      count++; 
 
      let min = Math.floor(count / 100 / 60);
      let sec = Math.floor(count / 100 % 60);
      let ms  = count % 100;

      if(min < 10) min = "0" + min;
      if(sec < 10) min = "0" + sec;
      if(ms < 10) min = "0" + ms;
      stopwatch.innerText = min + ":" + sec + ":" + ms;
      
   }, 10 );

});

// stop
stopbtn.addEventListener("click", () => {
   clearInterval(stopwatchInterval);
});

// window.open()

const open1 = document.querySelector("#open1");
const open2 = document.querySelector("#open2");
const open3 = document.querySelector("#open3");

// 새 탭으로 열기 
open1.addEventListener("click", () => {
   window.open("https://www.kh-academy.co.kr")

});

// 팝업창
open2.addEventListener("click", () => {
   window.open("https://www.kh-academy.co.kr", "_blank",
    "popup");

});

// 팝업창 옵션 적용
open3.addEventListener("click", () => {
   window.open("https://www.kh-academy.co.kr", "_blank",
   
   "width=400,height=600,top=100,left=100");

   // 주의사항
   // top, left는 여러 모니터를 사용하는 환경에선
   // 주 모니터에서만 적용된다.
});

const open4 = document.querySelector("#open4");
open4.addEventListener("click", () => {

   window.open("popup.html", "_blank", "width=700, height=700")
});










