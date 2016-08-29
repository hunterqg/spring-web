<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <form action='<c:url value="/upload" />' method="post" enctype="multipart/form-data">
            <label>upload File:</label>
            <input type="file" name="uploadFile">
            <input type="submit" value="上传" />
        </form>
        <br/>
        <c:out value="${msg}" />
    </body>
</html>