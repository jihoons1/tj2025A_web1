
console.log( 'pwdupdate.js open');

// [1] 패스워드 수정
const onPwdUpdate = async()=>{
    try{
    const oldpwd = document.querySelector('.oldpwd').value;
    const newpwd = document.querySelector('.newpwd').value;

    const obj = { "oldpwd" : oldpwd ,  "newpwd" : newpwd };
    console.log(obj);
    const op = { 
        method : "PUT" ,
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(obj),
    }
    console.log(op);
    const response = await fetch("/member/update/password" , op);
    const data = await response.json();
    console.log(data);

    if(data == true){
        alert('비밀번호 변경 완료');
        location.href = "/member/info.jsp";
    }else{
        alert('비밀번호 변경 실패');
    }
    }catch(error){ console.log(error);

     }
}