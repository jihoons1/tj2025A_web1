console.log('조회 페이지')

const print = async () => {
    const response = await fetch("/waiting");

    const data = await response.json();

    const Tbody = document.querySelector('.Tbody')

    let html = ``;
    for(let i = 0 ; i< data.length; i++){
        const waiting = data[i];
        html += `<tr>
                    <td>${waiting.num} </td>
                    <td> <a href="/waiting/view.jsp?num=${waiting.num}"> ${waiting.phone} </a> </td>
                    <td>${waiting.count} </td> <td>${waiting.wdata} </td>
        </tr>`
    }

    Tbody.innerHTML = html;
}

print();