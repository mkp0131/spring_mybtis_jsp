<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HelloJSP</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    
    <h1>HOME JSP 입니다.@@</h1>
    <h2><%="안녕 JSP"%></h2>

    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</body>
</html>