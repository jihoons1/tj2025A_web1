
console.log("개별 조회");

const shopping = async() => { console.log( '개별 조회 테스트이빈당.' ) 

    const url = new URLSearchParams( location.search );

    const custno = url.get('custno');

    const response = await fetch(`/shopping/a/update=${custno}`);
    const data =await response.json();

    document.querySelector('.custno').innerHTML = data.custno;
    document.querySelector('.custname').innerHTML = data.custname;
    document.querySelector('.phone').innerHTML = data.phone;
    document.querySelector('.address').innerHTML = data.address;
    document.querySelector('.joindate').innerHTML = data.joindate;
    document.querySelector('.grade').innerHTML = data.grade;
    document.querySelector('.city').innerHTML = data.city;
};
shopping();


const assessmentUpdate2 = () => {
    const custno = new URLSearchParams(location.search).get('custno');
    location.href=`/shopping/update.jsp?custno=${custno}`
}