<%-- 
    Document   : BoardManagerIndex
    Created on : Feb 14, 2023, 4:09:56 PM
    Author     : Admin
--%>

<%@page import="abc.contract.ContractDAO"%>
<%@page import="abc.contract.ContractDTO"%>
<%@page import="abc.boardmanager.BoardManagerDTO"%>
<%@page import="abc.admin.AdminDAO"%>
<%@page import="abc.admin.AdminDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Board Manager</title>
    </head>
    <body>  
        <% BoardManagerDTO bm = (BoardManagerDTO) session.getAttribute("boardManager");

            if (bm != null) {%>

        <h1>Welcome, ${sessionScope.boardManager.fullName}</h1>
        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action" />
        </form>
        <form action="MainController" method="POST">
            <table border="1">             
                <caption>Search admin</caption>
                <tr>
                    <td><input placeholder="admin name" name="keyWord" value="${param.keyWord}"/></td>

                    <td><input type="submit" name="action" value="Search Admin"/></td>
                </tr>

            </table>

        </form>
        <% String keyWord = request.getParameter("keyWord");
            
            ArrayList<AdminDTO> adList;

            if (keyWord == null) {
                adList = AdminDAO.getAdminList();
            } else {
                adList = AdminDAO.getAdminList(keyWord);
            }
            if (adList != null && !adList.isEmpty()) {
        %>

        <form action="MainController" method="POST">
            <table border="1">
                <caption>Admin List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (AdminDTO admin : adList) {

                    %>
                    <tr>
                        
                <form action="MainController">
                    <td><%=admin.getAID()%></td>
                        <td><%=admin.getFullName()%></td>
                        <td><%=admin.getStatus()%></td>
                        <td><a href="MainController?action=ViewAdmin&id=<%=admin.getAID()%>">View</a></td>
                </form>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </form>
        <%
        } else { %>
        <h3>The admin list is empty</h3>
        <%
            }
        %>
        <form action="MainController" method="POST">
            <table border="1">
                <caption>Add new admin</caption>
                <thead>
                    <tr>
                        <td>Email</td>
                        <td>Password</td>
                        <td>Name</td>
                        <td>CID</td>
                        <td>Action</td>

                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td><input name="email" required=""/></td>
                        <td><input name="password" required=""/></td>
                        <td><input name="name" required="" /></td>
                        <td><input name="cid" required=""/></td>
                        <td><input type="submit" name="action" value="Add Admin"/></td> 
                    </tr>

                </tbody>
            </table>

        </form>
        ${noti} <!--Cau thong bao add admin thanh cong hay khong-->
        <%
            ArrayList<ContractDTO> coList;
            coList = ContractDAO.getContracts();
            int totalContract=ContractDAO.getContracts().size();
            int totalFee=0;
            if (!coList.isEmpty() && coList != null) {%>
            Total Contract: <%=totalContract%>
            
                   <table border="1">
                <caption>Contract List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Customer</td>                       
                        <td>Owner</td>
                        <td>Seller</td>
                        <td>Resident</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (ContractDTO contract : coList) {
                         totalFee+=contract.getFee();
                    %>
                    <tr>
                        <td><%=contract.getCoID()%></td>
                        <td><%=contract.getCName()%></td>
                        <td><%=contract.getOName()%></td>
                        <td><%=contract.getSname()%></td>
                        <td><%=contract.getRName()%></td>
                        <td><a href="MainController?action=ViewContract&id=<%=contract.getCoID()%>">View</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                Total Fee: <%=totalFee%>
     <%       }else{ %>
             <h3>The contract list is empty</h3>

<%
     }
        %>

        <% } else {%>
        <h1>Access Denied</h1>
        <a href="Index.jsp">Back to login page</a>
        <%}
        %>
    </body>
</html>
