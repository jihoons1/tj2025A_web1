<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    <jsp:include page="/shopping/main.jsp"></jsp:include>

        <div> <h3> 홈쇼핑 회원 등록 </h3> </div>
    <div>
        <div>회원번호(자동발생)</div>  <input type="text" class="custno" placeholder=""> 
        <div>회원성명</div>    <input type="text" class="custname"> 
        <div>연락처</div>     <input type="number" class="phone">
        <div>주소</div>    <input type="text" class="address">
        <div>가입일자</div>    <input disabled="" class="joindate">
        <div>고객등급[A:VIP,B:일반,C:직원]</div>    <input type="text" class="grade"> 
        <div>도서코드</div>    <input type="text" class="city"> </br>
        <button class="addbutton" onclick="add()">등록</button>
        <button class="printbut" onclick="print()">조회</button>
    </div>

    <div>
        <p>Yes, you must insert a valid CUSTNO value matching an existing member. Otherwise, the insert will fail due to foreign key constraints.</p>
    </div>

    <script src="/shopping/add.js"></script>
</body>
</html>
