<%-- 
    Document   : login
    Created on : Feb 9, 2023, 1:48:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.notification}
        <form action="MainController" method="post">
            Email <input type="text" name="emailtxt" value="${param.emailtxt}"/>
            <br/>
            Password <input type="password" name="passwordtxt"/>
            <br/>
             
            <input type="submit" value="Login" name="action"/>
        </form>
            <br/>
            <a href="Registration.jsp">Registration</a>
             <a href="ForgotPassWord.jsp">Forgot password</a>
             
    </body>
</html>
