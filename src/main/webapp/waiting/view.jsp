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
        <h3> 상세 페이지 </h3>
        휴대번호 : <div class="phoneBOX"> </div>
        인원수 :  <div class="countBOX"> </div>
        <button type="button" onclick="waitingDelete()">삭제</button>
        <button type="button" onclick="updateview()">수정</button>
    </div>

    <script src="/waiting/view.js"></script>
</body>
</html>