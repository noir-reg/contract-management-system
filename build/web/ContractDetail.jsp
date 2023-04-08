<%-- 
    Document   : ContractDetail
    Created on : Feb 15, 2023, 10:04:40 PM
    Author     : Admin
--%>


<%@page import="abc.admin.AdminDTO"%>
<%@page import="abc.boardmanager.BoardManagerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contract Detail</title>
    </head>
    <% BoardManagerDTO bm = (BoardManagerDTO) session.getAttribute("boardManager");
        AdminDTO ad = (AdminDTO) session.getAttribute("admin");

        if (bm != null || ad != null) {%>
    <body>
        <form action="MainController">
            <table border="1">
                <caption>Contract Detail</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Customer</td>                       
                        <td>Owner</td>
                        <td>Seller</td>
                        <td>Resident</td>
                        <td>Fee</td>                    
                        <td>Total</td>
                        <td>Create Date</td>
                        <td>End Date</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="hidden" name="id" value="${contract.getCoID()}"/>${contract.getCoID()}</td>
                        <td>${contract.getCName()}</td>
                        <td>${contract.getOName()}</td>
                        <td>${contract.getSname()}</td>
                        <td>${contract.getRName()}</td>
                        <td><input name="fee" value="${contract.getFee()}"/></td>                    
                        <td><input name="total" value="${contract.getTotal()}"/></td>
                        <td>${contract.getCreateDate()}</td>
                        <td>${contract.getEndDate()}</td>   
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="action" value="Update Fee"/>
        </form>
        ${noti}
        <% if (bm != null) {%>
        <a href="BoardManagerIndex.jsp">Board Manager Page</a>
        <% } else {%>
        <a href="AdminIndex.jsp">Admin Page</a>   
        <% }%> 
        <%} else {%>
        <h1>Access Denied</h1>
        <a href="Index.jsp">Back to login page</a>
        <%}%>
    </body>
</html>
