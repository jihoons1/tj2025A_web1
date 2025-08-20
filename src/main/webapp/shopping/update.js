
console.log('수정페이지 upload.');

const update2 = async() => {
    const custno = new URLSearchParams(location.search).get('custno');
    
    const response = await fetch(`/shopping/update?custno=${custno}` );
    const data = await response.json();
    
    document.querySelector('.custno').innerHTML = data.custno;
    document.querySelector('.custname').innerHTML = data.custname;
    document.querySelector('.phone').innerHTML = data.phone;
    document.querySelector('.address').innerHTML = data.address;
    document.querySelector('.joindate').innerHTML = data.joindate;
    document.querySelector('.grade').innerHTML = data.grade;
    document.querySelector('.city').innerHTML = data.city;
}

update2();

const assessmentUpdate = async() => {
    console.log("개별 수정 조회 테스트");
    const custno = new URLSearchParams(location.search).get('custno');
    // 수정할거 가져오기 성명~도시코드
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;
    
    const obj = { "custname" : custname , "phone" : phone , "address" : address , "grade" : grade , "city" : city };

    const option = {
        method : "POT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }

    // fetch 실행
    const response = await fetch("/shopping" , option);
    const data = await response.json();
    // 결과
    if(data == true ) {
        alert('회원정보수정이 완료되었습니다. ');
        location.href=`/shopping/print.jsp?custno=${custno}` 
    }else{
        alert('회원정보수정이 실패하였습니다.');
    }

}

