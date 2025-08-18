
console.log('signup.js open');

// [1] 회원가입 처리
const signup = async() => {
    // 만약에 유효성검사 체크리스트에 false 가 존재하면 회원가입 진행 불가능
    // js배열내 요소찾기 함수 : 1. .indexOf() 2. .includes()
    if( signPass.includes(false) ){
        alert('올바른 정보 입력후 가능합니다');
        return;
    }
    const idInput = document.querySelector('.idInput');
    const pwdInput = document.querySelector('.pwdInput');
    const nameInput = document.querySelector('.nameInput');
    const phoneInput = document.querySelector('.phoneInput');

    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;

    const obj = {"mid" : mid , "mpwd" : mpwd , "mname" : mname , "mphone" : mphone }

    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(obj),
    }
    const response = await fetch("/member/signup" , option);
    const data = await response.json();

    if(data > 0) {
        alert('회원가입 성공');
        location.href="/member/login.jsp";
    }else{
        alert('회원가입 실패');
    }

}

// [2] 아이디중복검사

// <마크업> 이벤트 : onClick( 해당 마크업을 클릭했을때 ) , onkeyup( 해당 마크업에 키를 때었을때 )

// **유효성검사 체크리스트**
const signPass = [ false , false ] ; // 초기값은 실패 , 0인덱스:아이디체크 , 1인덱스 : 연락처체크

// [2] 아이디중복검사 : 입력할떄마다 발동
const idcheck = async() => {
    // 1.
    const mid = document.querySelector('.idInput').value;
    const idCheck = document.querySelector('.idCheck');
    // 2. 유효성 검사 길이검사
    if(mid.length < 6){ // 만약에 아이디가 6글자 미만이면
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다."
        signPass[0]= false; // 유효성 검사 상태 변경
        return; // 함수 강제 종료 함으로써 아래 코드는 실행안됨.
    }
    // 2. 유호성검사2 중복검사 , /member/check?type=검사할속성명&data=${검사할데이터}
    try{
    // 3. fetch 실행
    const option = { method : "GET" }
    const response = await fetch(`/member/check?type=mid&data=${mid}` , option);
    const data = await response.json();
    // 4. fetch == true ){
    if(data == true){
        idCheck.innerHTML = "사용중인 아이디 입니다."
        signPass[0] = false; // 유효성 검사 상태 변경
        }else{
            idCheck.innerHTML = "사용가능한 아이디 입니다."
            signPass[0] = true; // 유효성 검사 상태 변경
        }
    }catch(error){ console.log(error) }

    }

// [3] 연락처중복검사 : 입력할때마다 발동

const phonecheck = async() => {
    const mphone = document.querySelector('.phoneInput').value; // 1. 입력받은 연락처 가져오기
    const phoneCheck = document.querySelector('.phoneCheck'); // 2. 결과 메세지를 출력핳 dom 객체 가져오기
    if( mphone.length != 13){ // 3. 만약에 입력받은 연락처가 13글자가 아니면
        phoneCheck.innerHTML = "-(하이든) 포함한 13글자 연락처 입력해주세요." // 메세지 출력
        signPass[1] = false;
        return; // 함수 종료
    }
    try{ // 4. fetch 실행 
    const op = { method : "GET"}
    const response = await fetch(`/member/check?type=mphone&data=${mphone}` , op )
    const data = await response.json();
    if( data == true ) { // 5. fetch 실행 결과 
        phoneCheck.innerHTML = ` 사용중인 연락처 입니다.`;
        signPass[1] = false;
    }else{
        phoneCheck.innerHTML = ` 사용가능한 연락처 입니다.`;
        signPass[1] = true; // 상태 변경
    }
    }catch(error){ console.log(error)}

}

// 혼자 작성한것 작동 됨 휴대번호 10~11자리 

// const phonecheck = async() => {
//     // 1.
//     const mphone = document.querySelector('.phoneInput').value;
//     const phoneCheck = document.querySelector('.phoneCheck');

//     if(mphone.length < 10 || mphone.length > 11){
//         phoneCheck.innerHTML = '휴대번호는 11자리 입니다.'
//         signPass[1] = false;
//         return;
//     }
//     try{
//     const op = { method : "GET"}
//     const response = await fetch(`/member/check?type=mphone&data=${mphone}` , op )
//     const data = await response.json();

//     if(data == true){
//         phoneCheck.innerHTML = "사용불가능한 번호입니다."
//         signPass[1] = false;
//     }else{
//         phoneCheck.innerHTML = "사용가능한 번호입니다."
//         signPass[1] = true;
//     }
//     }catch(error){ console.log(error)}
// }