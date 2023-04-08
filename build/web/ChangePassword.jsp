<%-- 
    Document   : changePassword
    Created on : Feb 10, 2023, 9:01:49 PM
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
        <form action="MainController" method="POST">
            You are:
            <select name="role">               
                <option value="Customer">Customer</option>
                <option value="Owner">Owner</option>
                <option value="Resident">Resident</option>
                <option value="Seller">Seller</option>             
            </select><br> 
            Email <input type="text" name="emailtxt" required value="${param.emailtxt}"/><br> 
            Old Password <input type="password" name="oldPasstxt" required/> <br> 
            New Password <input type="password" name="newPasstxt"/> ${err.passwordErr} <br> 
            Confirm Password <input type="password" name="confirmPasstxt"/> ${err.confirmErr}  <br>  
            <input type="submit" name="action" value="Change password" onclick="confirmComplete()"/> 

            ${requestScope.noti}
            <a href="index.jsp">${requestScope.successfully}</a>
        </form>
        <script>
            function confirmComplete() {

                var answer = confirm("Are you sure ?");
                if (answer === true)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
        </script>
    </body>
</html>
