
// * js 실행 확인
console.log( "header.js open");

// [1] 내정보 요청 후 메뉴 나누기.

const myinfo = async () => {
    //
    const logMenu = document.querySelector('#log-menu');
    let html = ``   // (2) 무엇을
    try{
        // 1. fetch 실행
        const option = { method : "GET" }
        const response = await fetch("/member/info" , option);
        const data = await response.json();
        // 2. [로그인중]로그인 했을떄 정상 fetch
        html += ` <li> <sapn> ${ data.mid } 님 </sapn> </li>
                  <li> <a href="/member/info.jsp"> 내정보 </a></li>
                  <li> <a href="#" onclick="logout()"> 로그아웃 </a></li> `

    }catch{
        // 2. 로그인 안했을떄 비동상 통신 fetch
        html += `<li> <a href="/member/login.jsp"> 로그인 </a></li>
                <li> <a href="/member/signup.jsp"> 회원가입 </a></li>`
    }
    logMenu.innerHTML = html; // (3) 출력
}
myinfo(); // header.jsp 열기/실행될때마다 1번 최초 실행

// [2] 로그아웃
const logout = async() => {
    console.log('로그아웃 테스트1')
    try{
         // 1. fetch 실행
        const option = { method : "GET" }
        const response = await fetch("/member/logout" , option);
        const data = await response.json();
        console.log('로그아웃 테스트2')
        // 2. fetch 통신 결과
        if( data == true ){
            alert('로그아웃 했습니다.');
            // 로그아웃 성공시 메인페이지 이동
            location.href="/index.jsp";
            console.log('로그아웃 테스트3')
        }else{
            alert('비정상적인 접근 입니다.');
        }
        console.log('로그아웃 테스트4')
    }catch{ }
}

// // 1. GET/DELETE 형식
// const method = async() => {

// }

// const method = async () => {
//     try{
//         const option ={
//             method : "POST" ,
//             headers : { "Content-Type" : "application/json"},
//             body : JSON.stringify(obj)
//         }
//         const response = await fetch( "/URL" , option );
//         const data = await response.json();
//     }catch