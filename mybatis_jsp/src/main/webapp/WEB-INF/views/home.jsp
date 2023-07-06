<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HelloJSP</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    
    <h1>HOME JSP</h1>
    <h2>${title}</h2>

    <c:forEach var="item" items="${list}" varStatus="status">
        <p><c:out value="${item.getRegionId()}" /></p>
    </c:forEach>

    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</body>
</html>