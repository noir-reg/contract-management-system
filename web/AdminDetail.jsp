<%-- 
    Document   : AdminDetail
    Created on : Feb 15, 2023, 3:35:38 PM
    Author     : Admin
--%>

<%@page import="abc.boardmanager.BoardManagerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Detail</title>
    </head>
    <body>
        <% BoardManagerDTO bm = (BoardManagerDTO) session.getAttribute("boardManager");

            if (bm != null) {%> 
        <form action="MainController" method="POST">
            <table border="1">
                <caption>Admin Detail</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Email</td>
                        <td>CID</td>
                        <td>PassWord</td>
                        <td>Name</td>
                        <td>Phone</td>                        
                        <td>Address</td>
                        <td>Status</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <input type="hidden" name="id" value="${admin.AID}"/>${admin.AID}</td>
                        <td> <input name="email" value="${admin.email}"/></td>
                        <td> <input name="cid" value="${admin.ACID}"/></td>
                        <td> <input name="password" value="${admin.password}"/></td>
                        <td> <input name="name" value="${admin.fullName}"/></td>
                        <td> <input name="phone" value="${admin.phoneNumber}"/></td>                         
                        <td> <input name="address" value="${admin.address}"/></td>
                        <td>     <select name="status">
                                <option value="1">1</option>
                                <option value="0">0</option>

                            </select>   ${admin.status} </td>
                    </tr>

                </tbody>
            </table>                                                                             
            <input type="submit" name="action" value="Update Admin"/>
        </form>

        <a href="BoardManagerIndex.jsp">Board Manager Page</a>
        ${noti}
        <%} else {%>
        <h1>Access Denied</h1>
        <a href="Index.jsp">Back to login page</a>
        <%}%>

    </body>
</html>
