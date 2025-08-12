console.log('수정 페이지')

const print2 = async () => {
    const num = new URLSearchParams(location.search).get('num');
      console.log('num:', num);
    const response = await fetch(`/waiting/a?num=${num}`);
    const data = await response.json();
    document.querySelector('.phone').value = data.phone;
    document.querySelector('.count').value = data.count;
}
print2();


const waitingup = async () => {
    const num = new URLSearchParams(location.search).get('num');

    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;

    const obj = { "num" : num , "phone" : phone , "count" : count};
    const op = {
        method : "PUT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }

    const response = await fetch("/waiting" , op);
    const data = await response.json();

    if(data == true){
        alert('수정 완료');
        location.href=`/waiting/view.jsp?num=${num}`
    }else{
        alert('수정 실패');
    }
}