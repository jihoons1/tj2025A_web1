<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/infoid.css'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="idd">
        <h3> 아이디 찾기 </h3>
        id <input class="mid" > 
        이름 : <input class="mname"> 
        연락처 : <input class="mphone">
        <button type="button" onclick="infoid()"> 아이디 찾기 </button>
    </div>


    <script src="/js/member/infoid.js"></script>
</body>
</html>