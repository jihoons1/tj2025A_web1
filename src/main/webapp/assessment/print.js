console.log ( ' 조회 테스트')

const print = async () => {
    const response = await fetch("/shopping");

    const data = await response.json();
    
    const Tbody = document.querySelector('#Tbody');
    console.log ( ' 조회 테스트3')

const gradeMap = { "A": "VIP", "B": "일반", "C": "직원" };

let html = ``;
for(let i = 0 ; i < data.length; i++){
    const assessment = data[i];
    html += `<tr>
                <td>${assessment.custno}</td>
                <td>${assessment.custname}</td>
                <td>${assessment.phone}</td>
                <td>${assessment.address}</td>
                <td>${assessment.joindate}</td>
                <td>${gradeMap[assessment.grade] || "알 수 없음"}</td>
                <td>${assessment.city}</td>
            </tr>`;
}
    console.log ( ' 조회 테스트4')
    Tbody.innerHTML = html;

}
print();
console.log ( ' 조회 테스트5')