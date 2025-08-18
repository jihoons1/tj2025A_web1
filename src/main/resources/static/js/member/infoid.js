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
        const response = await fetch("/member/info/id" , op );
        const data = await response.json();

        if(data == true ) { 
            alert('일치하는 정보가 있습니다 id는'+data);
            document.querySelector('.mid').innerHTML = data
        }else{
            alert('사용자를 찾지 못했습니다.');
        }
    }catch(error){ console.log(error) }

}