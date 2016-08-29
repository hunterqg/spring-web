<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome <c:out value='${pageContext.request.remoteUser}' /> to web App</h1>
        <a href='<c:url value="/" />' >Web</a>
        <a href='<c:url value="/register" />' >Register</a>
        <form action='<c:url value="/logout" />' method="post" ">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Logout" />
         </form>
    </body>
</html>