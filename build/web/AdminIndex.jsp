<%-- 
    Document   : AdminIndex
    Created on : Feb 22, 2023, 4:56:09 PM
    Author     : Admin
--%>

<%@page import="abc.report.ReportDAO"%>
<%@page import="abc.report.ReportDTO"%>
<%@page import="abc.seller.SellerDAO"%>
<%@page import="abc.resident.ResidentDAO"%>
<%@page import="abc.owner.OwnerDAO"%>
<%@page import="abc.customer.CustomerDAO"%>
<%@page import="abc.admin.AdminDTO"%>
<%@page import="abc.customer.CustomerDTO"%>
<%@page import="abc.seller.SellerDTO"%>
<%@page import="abc.resident.ResidentDTO"%>
<%@page import="abc.owner.OwnerDTO"%>
<%@page import="abc.owner.OwnerDTO"%>
<%@page import="abc.contract.ContractDAO"%>
<%@page import="abc.contract.ContractDTO"%>
<%@page import="abc.boardmanager.BoardManagerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>  
        <% AdminDTO ad = (AdminDTO) session.getAttribute("admin");

            if (ad != null) {%>

        <h1>Welcome, ${sessionScope.admin.fullName}</h1>
        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action" />
        </form>
        <form action="MainController" method="POST">
            <table border="1">             
                <caption>Search User</caption>
                <tr>
                    <td><input placeholder="user name" name="keyWord" value="${param.keyWord}"/></td>
                    <td> 
                        <select name="role">
                            <option value="Customer">Customer</option>
                            <option value="Owner">Owner</option>
                            <option value="Resident">Resident</option>
                            <option value="Seller">Seller</option>
                        </select>
                        ${param.role}
                    </td>
                    <td><input type="submit" name="action" value="Search User"/></td>
                </tr>

            </table>

        </form>
        <% String keyWord = request.getParameter("keyWord");
            String role = request.getParameter("role");
            ArrayList<CustomerDTO> cusList = CustomerDAO.getCustomerList();
            ArrayList<OwnerDTO> ownList = OwnerDAO.getOwnerList();
            ArrayList<ResidentDTO> resList = ResidentDAO.getResidentList();
            ArrayList<SellerDTO> selList = SellerDAO.getSellerList();
            int totalUser=CustomerDAO.getCustomerList().size()+OwnerDAO.getOwnerList().size()+ResidentDAO.getResidentList().size()+SellerDAO.getSellerList().size();
            if (keyWord == null) {
                cusList = CustomerDAO.getCustomerList();
                ownList = OwnerDAO.getOwnerList();
                resList = ResidentDAO.getResidentList();
                selList = SellerDAO.getSellerList();
            } else {
                switch (role) {
                    case "Customer":
                        cusList = CustomerDAO.getCustomerList(keyWord);
                        break;
                    case "Owner":
                        ownList = OwnerDAO.getOwnerList(keyWord);
                        break;
                    case "Resident":
                        resList = ResidentDAO.getResidentList(keyWord);
                        break;
                    case "Seller":
                        selList = SellerDAO.getSellerList(keyWord);
                        break;

                }
            }
            if (cusList != null && !cusList.isEmpty()) {
        %>
        Total User: <%=totalUser%>
        <form action="MainController" method="POST">
            <table border="1">
                <caption>Customer List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (CustomerDTO cus : cusList) {

                    %>
                    <tr>

                <form action="MainController">
                    <td><%=cus.getCID()%></td>
                    <td><%=cus.getFullName()%></td>
                    <td><%=cus.getStatus()%></td>
                    <td><a href="MainController?action=ViewUser&id=<%=cus.getCID()%>&role=customer">View</a></td>
                </form>

                </tr>
                <%}%>
                </tbody>
            </table>

        </form>
        <%
        } else { %>
        <h3>The customer list is empty</h3>
        <%
            }
        %>

        <%  if (ownList != null && !ownList.isEmpty()) {
        %>

        <form action="MainController" method="POST">
            <table border="1">
                <caption>Owner List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (OwnerDTO own : ownList) {

                    %>
                    <tr>

                <form action="MainController">
                    <td><%=own.getOID()%></td>
                    <td><%=own.getFullName()%></td>
                    <td><%=own.getStatus()%></td>
                    <td><a href="MainController?action=ViewUser&id=<%=own.getOID()%>&role=owner">View</a></td>
                </form>

                </tr>
                <%}%>
                </tbody>
            </table>

        </form>
        <%
        } else { %>
        <h3>The owner list is empty</h3>
        <%
            }

        %>
        <%  if (resList != null && !resList.isEmpty()) {
        %>

        <form action="MainController" method="POST">
            <table border="1">
                <caption>Resident List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (ResidentDTO res : resList) {

                    %>
                    <tr>

                <form action="MainController">
                    <td><%=res.getRID()%></td>
                    <td><%=res.getFullName()%></td>
                    <td><%=res.getStatus()%></td>
                    <td><a href="MainController?action=ViewUser&id=<%=res.getRID()%>&role=resident">View</a></td>
                </form>

                </tr>
                <%}%>
                </tbody>
            </table>

        </form>
        <%
        } else { %>
        <h3>The resident list is empty</h3>
        <%
            }

        %>
        <%  if (selList != null && !selList.isEmpty()) {
        %>

        <form action="MainController" method="POST">
            <table border="1">
                <caption>Seller List</caption>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Detail</td>
                    </tr>
                </thead>

                <tbody>
                    <%for (SellerDTO sel : selList) {

                    %>
                    <tr>

                <form action="MainController">
                    <td><%=sel.getSaID()%></td>
                    <td><%=sel.getFullName()%></td>
                    <td><%=sel.getStatus()%></td>
                    <td><a href="MainController?action=ViewUser&id=<%=sel.getSaID()%>&role=seller">View</a></td>
                </form>

                </tr>
                <%}%>
                </tbody>
            </table>

        </form>
        <%
        } else { %>
        <h3>The seller list is empty</h3>
        <%
            }

        %>
        <h4>Add new user</h4>
        <form action="MainController" method="post">
            Role <select name="role">
                <option value="customer">Customer</option>
                <option value="owner">Owner</option>
                <option value="resident">Resident</option>
                <option value="seller">Seller</option>
            </select> <br/>
            Email <input type="text" name="txtEmail" value="${param.txtEmail}"/> ${ERROR.emailErr} <br>
            Password <input name="txtPassword" value=""/> ${ERROR.passwordErr}<br>
            ID <input type="text" name="txtID" value="${param.txtID}"/>  ${ERROR.idErr}<br>
            Phone <input type="text" name="txtPhone" value="${param.txtPhone}"/>  ${ERROR.phoneErr}<br>
            Full Name <input type="text" name="txtName" value="${param.txtName}" required=""/>  <br>
            Date of birth <input type="date" name="txtDob" value="${param.txtDob}"required=""/> <br>
            Address <input type="text" name="txtAddress" value="${param.txtAddress}" required=""/><br>
            Avatar <input type="text" name="txtAvatar" value="${param.txtAvatar}"/><br>
            <input type="submit" value="Add New Account" name="action" /> 
            <input type="reset" value="Reset"/>
            ${ERROR.existed}           
        </form>       
        ${notification} <!--Cau thong bao add user thanh cong hay khong-->

        <%  ArrayList<ContractDTO> coList;
            coList = ContractDAO.getContracts();
            int totalContract=ContractDAO.getContracts().size();
            int totalFee =0;
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
        <%       } else { %>
        <h3>The contract list is empty</h3>
        <%
            }
        %>

        <%  ArrayList<ReportDTO> rpList;
            rpList = ReportDAO.getReports();
            if (!rpList.isEmpty() && rpList != null) {%>
        <table border="1">
            <caption>Report List</caption>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Content</td>                       
                    <td>Create Date</td>
                </tr>
            </thead>
            <tbody>
                <%for (ReportDTO rp : rpList) {
                %>
                <tr>
                    <td><%=rp.getRpID()%></td>
                    <td><%=rp.getContent()%></td>
                    <td><%=rp.getCreateDate()%></td>                                    
                </tr>
                <%}%>
            </tbody>
        </table>
        <%       } else { %>
        <h3>The report list is empty</h3>
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
