<%-- 
    Document   : UserChangePassword
    Created on : Mar 1, 2023, 10:25:11 PM
    Author     : mical
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Old Password <input type="password" name="oldPasstxt"/> <br> 
            New Password <input type="password" name="newPasstxt"/> ${err.passwordErr} <br> 
            Confirm Password <input type="password" name="confirmPasstxt"/> ${err.confirmErr}  <br>  
            <input type="submit" value="Change password"/> 
            <input type="hidden" name="txtPassword" value="${sessionScope.user.getPassword()}"/>
            <input type="hidden" name="action" value="userChangePass"/>
            ${sessionScope.user.getPassword()}
            ${requestScope.noti}
        </form>
        <form action="MainController" method="POST">
            <input type="submit" value="HOME"/>
            <input type="hidden" name="action" value="Find2contracts"/>
        </form>
    </body>
</html>
