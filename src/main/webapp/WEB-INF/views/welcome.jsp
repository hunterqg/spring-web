<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome to web App</h1>
        <a href='<c:url value="/" />' >Web</a>
        <a href='<c:url value="/register" />' >Register</a>
    </body>
</html>