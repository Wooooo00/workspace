// script 태그 또는 js 파일에


// 전역 변수
var str = "html 랜더링 시 바로 실행";
console.log(str); 

var num1 = 100; // 전역 변수
num2 = 200; 

console.log("num1(전): " + num1)
console.log("num2(전): " + num1)

function testFn(){
   var num3 = 300; // function 레벨
   num4 = 400; // 전역 변수
   console.log("num3(함) : " + num3);
   console.log("num4(함) : " + num4);

   if(1==1){ 
      var num5 = 500;
      num6 = 600; 
   }

   console.log("num5(if) : " + num5);
   console.log("num6(전) : " + num6);

   
}

testFn(); // 함수는 호출해야 수행된다. 

// num3 is not defined 
// 함수 밖에 있기 때문에 인식 되지 않는다.
// console.log("num3(함) : " + num3);


// 자바 스크립트는 중간에 오류가 발생하면 다음 코드가 해석 되지 않는다 
console.log("함수 밖 num4(전) : " + num4);
console.log("if->함수 밖 num6(전) : " + num6);

var num7;
var num7; // var는 변수명 중복 가능
// -----------------------------------------

let let1 = 100; // 전역 변수
 // 변수명 중복 허용 X 

let1 = 10;
const con1 = 200; 
// con1 = 20; // Assignment 
           // (상수형 변수에는 새로운 값을 할당할 수 없다)

function testFn2(){
   let let1 = 1000;
   let let3 = 321;
   const con3 = 3000;

   if(1==1){
      let let4 = 4444;
      const const4 = 4567;
   }
}

function typeTest(){
   // typeof 변수 : 변수의 자료형을 반환해준다.
   const box = document.getElementById("box");

   box.innerHTML = ""; // box 내부에 작성된 내용을 모두 삭제

   // undefined 확인 
   let undef; // 선언 후 값을 대입하지 X (자료형이 정의되지 않았다)

   box.innerHTML += "under : " + typeof undef;

   br();
   
   // string 확인
   // "", '' 모두 string(문자열) 의미 
   const name = "홍길동"; // string
   const gender = 'M'; // string
   const phone = '01012345678';

   print(name);
   print(gender);
   print(phone);
   
   const age = 33;
   const height = 180.2;
   
   print(age);
   print(height);

   // boolean
   const tt = true;
   const ff = false;

   print(tt);
   print(ff);

   // object 
   const arr = [10, 30, 50, 40]; // object
   print(arr);

   // 중요!!
   // JS 객체 {K:V, K:V} ***** 
   const user = {
      id : "user01",
      pw : "pass01",
      age : 14
   };

   print(user);

   console.log(user); 

   // 객체에 존재하는 값 얻어오는 방법(1)
   print(user.id);
   print(user.pw);
   print(user.age);

   // 객체에 존재하는 값 얻어오는 방법(2)
   // 변수명 ["key"]
   print(user["id"]);
   print(user["pw"]);
   print(user["age"]);

   // function

   // 요즘 함수 선언,정의하는 트렌드
   
   // function(){} : 익명 함수(함수명 없음)
   const sumFn = function 함수명(n1, n2){return n1 + n2;}

   // 함수 호출
   console.log(sumFn(10,40));
   
   print(sumFn);

   // sumFn : 함수 자체(함수 코드)
   // sumFn() : 함수 호출(함수 실행)

   print(br);
}


   
   // 줄바꿈 추가 함수
function br(){
   const box = document.getElementById("box");
   box.innerHTML += "<br>";
}
   // 함수 매개변수 선언 let, const 작성하지 않는다
   // box에 출력하기 
function print(temp){
   const box = document.getElementById("box");
   box.innerHTML += temp + " : " + typeof temp;
   br();
}

// if문 {} 밖으로 나와서 사용 불가
// console.log(let4);
// 함수 밖으로 나오면 사용 불가
// console.log(let3);
// console.log(con3);






