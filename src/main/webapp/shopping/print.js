console.log ( ' 조회 테스트')

const print = async () => {
    const response = await fetch("/shopping");

    const data = await response.json();
    
    const Tbody = document.querySelector('#Tbody');
    console.log ( ' 조회 테스트3')


let html = ``;
for(let i = 0 ; i < data.length; i++){
    const assessment = data[i];
    html += `<tr> <a href="#"></a>
                <td>
                <a href="/shopping/update.jsp?custno=${assessment.custno}">${assessment.custno}</a>
                </td>
                <td>${assessment.custname}</td>
                <td>${assessment.phone}</td>
                <td>${assessment.address}</td>
                <td>${assessment.joindate}</td>
                <td>${assessment.grade}</td>
                <td>${assessment.city}</td>
            </tr>`;
}
    console.log ( ' 조회 테스트4')
    Tbody.innerHTML = html;

}
print();
console.log ( ' 조회 테스트5')

