
console.log('update.js open');

// [1] 기존 정보 불러오기
const onInfo = async() => {
    try{
        const op = {method : "GET" }
        const response = await fetch("/member/info" , op );
        const data = await response.json();

        document.querySelector('.mno').innerHTML = data.mno;
        document.querySelector('.mid').innerHTML = data.mid;
    
    }catch(error){console.log(error)}
}
onInfo();

// [2] 사용자 이름 / 휴대번호 변경
const onUpdate = async() => {
    try{
        const mname = document.querySelector('.mname').value;
        const mphone = document.querySelector('.mphone').value;

        const obj = { "mname" : mname , "mphone" : mphone };

        const op = {method : "PUT" ,
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify(obj),            
        }
        const response = await fetch("/member/update" , op );
        const data = await response.json(); 

        if(data == true){
            alert('수정 완료');
            location.href = "/member/info.jsp";
        }else{
            alert('수정 실패');
        }
    }catch(error) {
        console.log(error);        
    }
}
