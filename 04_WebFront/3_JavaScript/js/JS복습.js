
const createBtn = document.querySelector("#create-btn");
const fontColor = document.querySelector("#font-color");
const bingoBoard = document.querySelector("#bingo-board");



// 생성 버튼 클릭 시 

createBtn.addEventListener("click", e => {
   // 생성 버튼의 이전 형제 요소 값 얻어오기
   const bingoLength = e.target.previousElementSibling.value;
   // bingoLength * bingoLength 실행한 수만큼 중복 되지 않는 난수 생성

   // JAVA 컬렉션 중 Set(중복X)과 같은 객체 존재
   const set = new Set();

   // set.size : set에 저장된 요소의 수
   // set.add("값") : set에 값 추가
   while(set.size < bingoLength * bingoLength){
      // 난수 생성 
      const r = Math.floor( Math.random() *  bingoLength * bingoLength + 1 ); 
      set.add(r);
   }

   // set을 array(배열)로 변경
   // Array.from(set) : set을 배열로 변경하여 반환해준다
   const arr = Array.from(set);
   
   //---------------------------------------------------------

   // 빙고판 생성
   let row;
   let col;

   bingoBoard.innerHTML = " "; 
   
   for(let i=0; i<arr.length; i++){
      if(i % bingoLength == 0){
      // 행을 만들어준다 (div.bingo-row)
      row = document.createElement("div");
      row.classList.add("bingo-row");

      // 만들어진 행을 #bingo-board에 추가
      bingoBoard.append(row);
      }

         // 열 만들기 (div.bingo-col)
      col = document.createElement("div");
      col.classList.add("bingo-col");
      col.innerText = arr[i]; // 

      // 생성된 열(col)이 클릭 되었을 때,
      // .check가 없으면 추가, 있으면 제거하는 코드
      // 
      //
      col.addEventListener("click", e => {
   
         // 이벤트가 발생한 요소가 check 클래스를 포함하는지 확인
      if(e.target.classList.contains("check")){
         e.target.classList.remove("check");
      } else{
         e.target.classList.add("check");
      }

      // 빙고 여부 검사 
      checkBingo();

      });


      // 행에 열을 마지막 자식으로 추가
      row.append(col);
   }
});
   
// 생성한 난수를 빈칸에 넣

// 빙고 여부 검사
function checkBingo(){

   let board = []; // 비어있는 배열을 생성하는 코드
   // 참고 JS의 배열은 자바의 리스트와 유사하다. 

   // 현재 빙고의 모든 행들을 얻어와 배열로 저장.
   const rows = document.querySelectorAll(".bingo-row");

   for(let i=0; i<rows.length; i++){
      // rows[i].children : 각 행의 모든 열(자식 요소)을 배열로 반환
      // 배열.push(값/객체) : 배열 마지막 요소로 추가(JAVA : list.add(E))
      board.push(rows[i].children);
   }
   // 모든 행, 열이 담긴 2차원 배열 생성

   // 모든 col(열)에 있는 bingo 클래스 제거

   for(let i=0; i<board.length; i++){
      for(let k=0; k<board[i].length; k++){
         board[i][k].classList.remove("bingo");
      }
   }
   // 1.행 빙고 검사
   rowCheck(board);
   // 2.열 빙고 검사
   colCheck(board);
   // 3. 대각선 빙고 검사
   diaCheck(board);
}


//행 빙고 검사
function rowCheck(board) {
   // board : 빙고판을 나타내는 2차원 배열
   // board[i] : i번째 행
   // board[i][k] : i번째 행에 k번째 열 
   // 한 행씩 접근해서 모든 열에 check 클래스가 있는지 검사
   for(let i = 0; i<board.length; i++){
      let count = 0; // 현재 행의 check 개수 count
      // 모든 열 접근용 for문
      for(let k = 0; k<board[i].length; k++){
         if(board[i][k].classList.contains("check")){
            count++;
         }
      }
   

   // 해당 행의 모든 열이 체크 되어 있다.
   if(board[i].length == count){
      for(let k=0; k<board[i].length; k++){
         board[i][k].classList.add("bingo");
      }
   }
   }
}

function colCheck(board){
   // board : 빙고판을 나타내는 2차원 배열
   // k == 열의 인덱스 
   // i == 행의 인덱스 
   // board[i][k] : i번째 행에 k번째 열 

   const bingoLength = board.length;
   for(let k=0; k<board.length; k++){ 

      let count = 0; // check 개수 카운트
         for(let i=0; i<board.length; i++){
            if(board[i][k].classList.contains("check")){
            count++
         }
      }
      if(bingoLength == count){
        for(let i=0; i<board.length; i++){
         board[i][k].classList.add("bingo");
      }
   }
 }
}

function diaCheck(board){
   // ex) (1,1) (2,2) (3,3) 
   let count1 = 0; // 왼쪽 위 -> 오른쪽 아래 대각선 카운트
   let count2 = 0; // 오른쪽 위 -> 왼쪽 아래 대각선 카운트

   const bingoLength = board.length;

   for(let i=0; i<bingoLength; i++){
      if(board[i][i].classList.contains("check")){
         count1++
      }
      
      if(board[i][bingoLength-i].classList.contains("check")){
         count2++
      }
   }
      
    if(bingoLength == count1){
       for(let i=0; i<bingoLength; i++){
          board[i][i].classList.add("bingo");
         }
      }
      
      if(bingoLength == count2){
         for(let i=0; i<bingoLength; i++){
            board[i][bingoLength-i].classList.add("bingo");
         }
      }
   }
      
// 색상 입력 시 빙고판 글자색 변경 

fontColor.addEventListener("keyup", (e) => {
   // 입력한 text에 style.fontcolor
   if(e.key == "Enter"){
      bingoBoard.style.fontColor = e.target.value;
   }
});


fontColor.addEventListener("keyup", (e) => {
   if(e.key == "Enter"){
      bingoBoard.style.backgroundColor = e.target.value;
   }
});

// fontColor.addEventListener("keyup", (e) => {
//    // 입력한 text에 style.fontcolor
//    if(e.key == "Enter"){
//       bingoBoard.style.fontColor = e.target.value;
//    }
// });

