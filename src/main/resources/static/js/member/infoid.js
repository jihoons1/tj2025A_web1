console.log('infoid.아이디찾기임');

const infoid = async() => {
    try{
        const mname = document.querySelector('.mname').value;
        const mphone = document.querySelector('.mphone').value;

        const obj = { "mname" : mname  , "mphone" : mphone };
        const op = { method : "POST" ,
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch(`/member/infoid?mname=${mname}&mphone=${mphone}` , op );
        const data = await response.json();

        if(data.msg) { 
            alert('일치하는 정보가 있습니다 id는'+data.msg);
            document.querySelector('.mid').value = data.msg
        }else{
            alert('사용자를 찾지 못했습니다.');
        }
    }catch(error){ console.log(error) }

}


// console.log('infoid.아이디찾기임');

// const infoid = async() => {
//     // 1. html 로 부터 사용자가 이름고 ㅏ연락처를 입력받은 input dom 가져오기

//     // 2. 가져온 dom객체내 입력받은 값 가져오기

//     // 3. 이름 과 연락처를 개체화 + 유효성검사 부가적인

//     // 4. fetch 이용하여 /member/infoid?mname=&mphone=

//     // 5-1 통신한 결과 { msg: null;; }  이면
//     // 5-2 통신한 결과 아니면
//     try{
//         const mname = document.querySelector('.mname').value;
//         const mphone = document.querySelector('.mphone').value;

//         const response = await fetch(`/member/info/id?mname=${mname}&mphone=${mphone}` );
//         const data = await response.json();

//         if(data == true ) { 
//             alert('일치하는 정보가 있습니다 id는'+data);
//             document.querySelector('.mid').innerHTML = data
//         }else{
//             alert('사용자를 찾지 못했습니다.');
//         }
//     }catch(error){ console.log(error) }

// }

// const infopass = async() => {
//     // 1. html로 부터 아이디오 ㅏ연ㄹ가처 입력받을 input 마크업 가져오기
//     const mid = document.querySelector('.mid').value;
//         const mphone = document.querySelector('.mphone').value;
//     // 2. 가져온 input 마크업에서 입력받은 값 가져오기
//     const response = await fetch(`/member/info/id?mname=${mname}&mphone=${mphone}` );
//         const data = await response.json();

//     // 3. fetch 이용하여 controller와 통신 , "/member/info/pass/?mid=&mpone="
//     // 4. 통신결과 메세지 출력하기 , { msg}
// }