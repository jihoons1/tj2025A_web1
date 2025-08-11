console.log('등록 테스트')

const add = async () => {
    const bcontent = document.querySelector('.bcontent').value;
    const bwriter = document.querySelector('.bwriter').value;

    const obj = { 'bcontent' : bcontent , 'bwriter' : bwriter };
    // 입력 객체 데이터화
    const op = {
        method : "POST" , // http method(보내는방법)
        headers : { "Content-Type" : "application/json"}, // http header(부가정보/설정)
        body : JSON.stringify( obj)                 // http body(보내는내용물)
    }

    // 4. fetch 실행 
    const response = await fetch("/board" , op)
    // 5. 응답자료 타입 변환
    const data = await response.json();
     // 결과  true/ false 
    if( data == true) {
        alert('등록 성공');
        location.href="/board/list.jsp"; // 성공이면 페이지 전환
    }else{ alert('등록 실패') }
    
}