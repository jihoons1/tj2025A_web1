document.querySelector('.joindate').value = new Date().toISOString().slice(0,10); // GPT 참고.. 


const add = async () => {
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const joindate = document.querySelector('.joindate').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;

    
    const obj = {"custname" : custname , "phone" : phone , "address" : address ,"joindate" : joindate , "grade" : grade , "city" : city}

    const op = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }

    const response = await fetch("/shopping" , op )

    const data = await response.json();

    if(data == true ){
        alert('회원 성공');
        location.href="/assessment/print.jsp";
    }else{
        alert('회원 등록 실패');
    }
}