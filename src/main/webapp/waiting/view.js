console.log('view');

const print2 = async () => {
    const url = new URLSearchParams(location.search);

    const num = url.get('num');

    const response = await fetch(`/waiting/a?num=${num}`);
    const data = await response.json();

    const phoneBOX = document.querySelector('.phoneBOX');
    const countBOX = document.querySelector('.countBOX');

    const phone = data.phone;
    const count = data.count;

    phoneBOX.innerHTML = phone;
    countBOX.innerHTML = count;
}
print2();


// 삭제
console.log('삭제')

const waitingDelete = async () => {
    
    const num = new URLSearchParams(location.search).get('num');

    let c = confirm('삭제?');
    if( c= true){
        const op = { method : "DELETE"}
        const response = await fetch( `/waiting?num=${num}` , op);
        const data =await response.json();

        if(data == true){
            alert('삭제 성공');
            location.href="/waiting/print.jsp";
        }else{
            alert('삭제 실패');
        }
    }
}

    const updateview = () => {

        const num = new URLSearchParams(location.search).get('num');

        location.href=`/waiting/update.jsp?num=${num}`;
    }