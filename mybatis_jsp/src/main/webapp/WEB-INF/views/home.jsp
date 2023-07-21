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

    <img src="/assets/images/spring_logo.png" alt="">

<%--    <c:forEach var="item" items="${list}" varStatus="status">--%>
<%--        <p><c:out value="${item.getRegionId()}" /></p>--%>
<%--    </c:forEach>--%>

    <form action="/login" method="post" onsubmit="onSubmit(event)">
        <input name="emplyrId" id="emplyrId" />
        <input name="password" id="password" />
        <input name="publicKey" id="publicKey" value="${publicKey}" />
        <button type="submit" >간다📌</button>
    </form>

    <%@ include file="/WEB-INF/views/include/header.jsp" %>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jsencrypt/2.3.1/jsencrypt.min.js" integrity="sha512-zDvrqenA0eFJZCxBsryzUZcvihvNlEXbteMv62yRxdhR4s7K1aaz+LjsRyfk6M+YJLyAJEuuquIAI8I8GgLC8A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
        function onSubmit(e) {
            e.preventDefault();

            var emplyrId = document.getElementById('emplyrId').value;
            var password = document.getElementById('password').value;

            const publicKey = "${publicKey}";
            const crypt = new JSEncrypt();
            crypt.setPublicKey(publicKey);
            const encryptedVal = crypt.encrypt(password);

            document.getElementById('password').value = encryptedVal;

            e.target.submit();


        }

    </script>
</body>
</html>