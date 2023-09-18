// id로 접근하기
function idTest() {
   const div1 = document.getElementById("div1");

   // Java에서 배열 리터럴 표기법 : {}
   // JS에서 배열 리터럴 표기법 : []
   const colorArray = ['red', "black", "Wheat"];

   // 배열명.length -> 배열 길이
   // Math.random() -> 0.0 <= x =< 1.0 난수 생성
   // Math.floor(실수) : 소수점 내림 -> 정수 반환
   const ran = Math.floor(Math.random() * colorArray.length)

   // ran == 0 ~ 배열길이 -1 사이의 난수
   div1.style.backgroundColor = colorArray[ran];
}

// class로 접근하기
function classTest() {
   const arr = document.getElementsByClassName("div2");

   arr[0].style.backgroundColor = "pink";
   arr[0].innerText = "arr[0]입니다";

   arr[1].style.backgroundColor = "black";
   arr[1].innerText = "arr[1]입니다";


   arr[2].style.backgroundColor = "blue";
   arr[2].innerText = "arr[2]입니다";
}

function tagTest() {
   const arr = document.getElementsByTagName("li");
   // 반복문(for문과 비슷)
   for (let i = 0; i < arr.length; i++) {
      arr[i].style.backgroundColor = "rgb(222,20," + arr[i].innerText + ")"
   }
}

function nameTest() {
   // name 속성값이 hobby인 요소 모두 얻어오기
   const hobbyArray = document.getElementsByName("hobby");
   let str = ""; // 비어있는 문자열
   let count = 0; // 체크 개수를 카운트 
   for (let i = 0; i < hobbyArray.length; i++) {
      // checkbox, radio 전용 속성 (.checked) 
      // 요소.checked : 해당 요소가 체크 되어 있으면 true, 아니면 false

      // 요소.checked = true -> 해당 요소를 체크 
      // 요소.checked = false -> 해당 요소를 체크 해제 

      if (hobbyArray[i].checked) { // i번째 요소가 체크 되어 있다면 }
         count++; // 1 증가
         str += hobbyArray[i].value + " "; // value 속성값 누적
      }

   }
   const div = document.getElementById("name-div");
   div.innerHTML = str
      + "<br><br>"
      + "선택된 input 개수 : " + count;
}

function cssTest() {
   // queryselector("선택자") : 1개(여러 요소가 있으면 첫번째)
   // queryselectorAll("선택자") : 모두 얻어온다
   // 1개만 존재하는 요소 #css-div
   document.querySelector("#css-div").style.border = "3px solid red";

   // 여러개 있는 요소 중 첫번째만 선택하기 
   document.querySelector("#css-div > div").style.fontSize = "40px";
   // 모든 요소
   const arr = document.querySelectorAll("#css-div > div");
   arr[0].style.backgroundColor = "tomato";
   arr[1].style.backgroundColor = "yello";
}




function readValue() {

   const bg = document.querySelector("#chatting-bg");
   const input = document.querySelector("#user-input");



   // 입력 요소.value : 값 읽어오기
   // 입력 요소.

   if (input.value.trim().length == 0) {

      alert("채팅 내용을 입력해주세요");
   } else {
      bg.innerHTML += "<p><span>" + input.value + "</span></p>";

      // 요소.bg.scrollHeight : 스크롤 전체 높이
      // 요소.scrollTop : 요소 내부 스크롤의 위치 반환
      // 요소.scrollTop = 높이 : 스크롤 위치를 해당 높이로 이동

      bg.scrollTop = bg.scrollHeight;
      console.log(bg.scrollHeight);


      // input에 작성된 값 지우기
      input.value = ""; // 빈 문자열을 값으로 대입

      // input에 포커스 맞추기 
      input.focus(); // 요소.focus() : 해당 요소에 포커스 맞춤
   }

}



 // 아이디가 user-input인 요소에서 
// 키보드 키가 올라올 때(key-up) 동작(function(){})을 수행해라
document.querySelector("#user-input").addEventListener("keyup", function (e) {
   // e : 이벤트 객체(발생한 이벤트 정보를 가지고 있는 객체)
   // e.key : 입력한 키 반환
   // console.log(e.key);

   if (e.key == "Enter") {
      readValue(); // 채팅창에 출력하는 함수 호출   
   }
});



