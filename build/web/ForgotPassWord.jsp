<%-- 
    Document   : ForgotPassWord
    Created on : Mar 1, 2023, 9:07:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
         <form action="MainController" method="POST">            
            Email <input type="text" name="emailtxt" required value="${param.emailtxt}"/><br>               
            <input type="submit" name="action" value="Forgot password"/><br/>
            ${requestScope.notification}<br/>
            <a href="Index.jsp">Back to login page</a>
        </form>
    </body>
</html>
