<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<sf:form method="POST" action="register" commandName="user">
    First Name: <sf:input path="firstName"/><br/>
    Last Name: <sf:input path="lastName"/><br/>
    Email: <sf:input path="email"/><br/>
    UserName: <sf:input path="userName"/><br/>
    Password: <sf:password path="password"/><br/>
    <input type="submit" value="Register" />
</sf:form>