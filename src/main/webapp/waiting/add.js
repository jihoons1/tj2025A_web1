console.log('등록')

const add = async () => {
    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;

    const obj = { phone , count};
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(obj)
    }

    const response = await fetch("/waiting" , option)

    const data = await response.json();

    if(data == true ){
        alert('대기 등록 성공');
        location.href="/waiting/print.jsp";
    }else{
        alert('대기 등록 실패');
    }
}