<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3>수정 페이지</h3>
        휴대번호 : <input class="phone" type="text"> </br>
        인원수 : <input class="count" type="text" placeholder="숫자입력">
        <button type="button" onclick="waitingup()"> 수정 </button>
    </div>

    <script src="/waiting/update.js"></script>
</body>
</html>