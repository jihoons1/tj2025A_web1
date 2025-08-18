
console.log('연수구 인구수 ');

let serchdata = [];

const dataAPI = async() => {
    // 공공 데이터
    const serviceKey = "2QlIstnx5A6ovAoZGnfd5mwZhryEx%2FIBlfb2re7EbVMDj6zsz1ZLWZvnjAw7nMIHfzRzBwGi66xhKjxdPOgvWw%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="
    // fetch 실행
    const response = await fetch( URL + serviceKey , {method : "GET"} );
    const data = await response.json();
    console.log(data);
    const sidebar = document.querySelector('#sidebar');
    serchdata = data.data;
    let html = '';
        serchdata.forEach( (value) => {
            html += `<div id="store">
                        <div> 학교명 : ${value.학교명} </div>
                        <div> 전화번호(행정실) : ${value.행정실} </div>
                        <div> 주소 : ${value.주소} </div>
                    </div>`
        });
        sidebar.innerHTML = html;
} // dataAPI end
dataAPI(); // 공공 데이터 가져온거임


// 지도 만들기
const mapAPI = async() => {
    var map = new kakao.maps.Map(document.getElementById('map'), 
    { center : new kakao.maps.LatLng( 37.41038125 , 126.6782658), level : 10  });
// (2)마커 클러스터러( 여러가 마커가 겹칠때 도형으로 마커수를 표현 ) 를 생성합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
    // (3) FETCH 이용한 공공데이터 자료 활용 
    const serviceKey = "2QlIstnx5A6ovAoZGnfd5mwZhryEx%2FIBlfb2re7EbVMDj6zsz1ZLWZvnjAw7nMIHfzRzBwGi66xhKjxdPOgvWw%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="
    const response = await fetch( URL+serviceKey , { method : "GET"} );
    const data = await response.json();
    console.log( data ); //
    // (4) map 반복문을 이용하여 마커를 하나씩 생성하여 return 한 마커를 markers 변수(배열)에 대입한다.
    let markers = data.data.map( ( value ) => { // forEach 리턴없다 vs map 리턴있다
        // (5-1) 마커생성
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng( value.위도, value.경도 ) // 위도(Latitude  ) , 경도 (Longitude) 악어
        });
        // (5-2) 마커 클릭 이벤트 넣기. //kakao.maps.event.addListener( marker , 'click' , () => { })
        kakao.maps.event.addListener( marker , 'click' , ()=> {
            // (*)내가 클릭한 마커의 정보를 사이드바(특정html)로 불러오기
            const sidebar = document.querySelector('#sidebar');
            let html = `<button type="button" onclick="dataAPI()">전체보기 </button>
                        <div id="store"> 
                            <div> 학교명 :  ${ value.학교명 } </div>
                            <div> 전화번호(행정실) : ${ value.행정실 } </div>
                            <div> 주소 : ${ value.주소 } </div>
                        </div>`


            sidebar.innerHTML = html;
        })        
        // (5-3) 마커 리턴
        return marker;
    }); // map end

    // (6) 여러개 마커를 가진 markers 변수를 클러스터에 등록 
    clusterer.addMarkers(markers);

    // (7)마커 클러스터러에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;
        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
        
} // mapAPI end


mapAPI();


 // gpt 참고 검색하기 기능

const serc= async() => {
    const serch = document.querySelector('#serch').value.trim();

    if(!serch){ return alert('위치 검색해주세요'); }
    let html = '';
    let ee = false;

    serchdata.forEach( (value)  => {
        if(value.학교명.includes(serch)){
            ee = true;
            html += `<button type="button" onclick="dataAPI()">전체보기 </button>
                        <div id="store"> 
                            <div> 학교명 :  ${ value.학교명 } </div>
                            <div> 전화번호(행정실) : ${ value.행정실 } </div>
                            <div> 주소 : ${ value.주소 } </div>
                        </div>`
        }
    });
    if(ee) {
        document.querySelector('#sidebar').innerHTML = html;
    }else{
        alert('찾지못함');
    }
}