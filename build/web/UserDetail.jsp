<%-- 
    Document   : UserDetail
    Created on : Feb 22, 2023, 11:04:04 PM
    Author     : Admin
--%>

<%@page import="abc.seller.SellerDTO"%>
<%@page import="abc.resident.ResidentDTO"%>
<%@page import="abc.owner.OwnerDTO"%>
<%@page import="abc.customer.CustomerDTO"%>
<%@page import="abc.admin.AdminDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% AdminDTO ad = (AdminDTO) session.getAttribute("admin");

            if (ad != null) {%> 
        <form action="MainController" method="POST">
            <table border="1">
                <caption>User Detail</caption>

                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Role</td>
                        <td>Email</td>
                        <td>CID</td>
                        <td>PassWord</td>
                        <td>Date of birth</td>
                        <td>Name</td>
                        <td>Phone</td>                        
                        <td>Address</td>
                        <td>Avatar</td>
                        <td>Status</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CustomerDTO cus = (CustomerDTO) request.getAttribute("customerDetail");
                        OwnerDTO own = (OwnerDTO) request.getAttribute("ownerDetail");
                        ResidentDTO res = (ResidentDTO) request.getAttribute("residentDetail");
                        SellerDTO sel = (SellerDTO) request.getAttribute("sellerDetail");

                        if (cus != null) {%>
                    <tr>
                        <td> <input type="hidden" name="id" value="${customerDetail.CID}"/>${customerDetail.CID}</td>
                        <td> <input type="hidden" name="role" value="${role}"/>${role}</td>
                        <td> <input name="email" value="${customerDetail.email}"/></td>
                        <td> <input name="cid" value="${customerDetail.CCID}"/></td>
                        <td> <input name="password" value="${customerDetail.password}"/></td>
                        <td> <input type="date" name="date" value="${customerDetail.dateOfBirth}"/></td>
                        <td> <input name="name" value="${customerDetail.fullName}"/></td>
                        <td> <input name="phone" value="${customerDetail.phoneNumber}"/></td>                         
                        <td> <input name="address" value="${customerDetail.address}"/></td>
                        <td> <input name="avatar" value="${customerDetail.avatar}"/><img src="${customerDetail.avatar}"/></td>
                        <td>     <select name="status">
                                <option value="1">1</option>
                                <option value="0">0</option>

                            </select>   ${customerDetail.status} </td>
                    </tr>
                    <%      }
                    %>                   
                    <%
                         if (own != null) {%>
                    <tr>
                        <td> <input type="hidden" name="id" value="${ownerDetail.OID}"/>${ownerDetail.OID}</td>
                        <td> <input type="hidden" name="role" value="${role}"/>${role}</td>
                        <td> <input name="email" value="${ownerDetail.email}"/></td>
                        <td> <input name="cid" value="${ownerDetail.OCID}"/></td>
                        <td> <input name="password" value="${ownerDetail.password}"/></td>
                        <td> <input type="date" name="date" value="${ownerDetail.dateOfBirth}"/></td>
                        <td> <input name="name" value="${ownerDetail.fullName}"/></td>
                        <td> <input name="phone" value="${ownerDetail.phoneNumber}"/></td>                         
                        <td> <input name="address" value="${ownerDetail.address}"/></td>
                        <td> <input name="avatar" value="${ownerDetail.avatar}"/><img src="${ownerDetail.avatar}"/></td>
                        <td>     <select name="status">
                                <option value="1">1</option>
                                <option value="0">0</option>

                            </select>   ${ownerDetail.status} </td>
                    </tr>
                    <%      }
                    %>
                    <%
                        if (res != null) {%>
                    <tr>
                        <td> <input type="hidden" name="id" value="${residentDetail.RID}"/>${residentDetail.RID}</td>
                        <td> <input type="hidden" name="role" value="${role}"/>${role}</td>
                        <td> <input name="email" value="${residentDetail.email}"/></td>
                        <td> <input name="cid" value="${residentDetail.RCID}"/></td>
                        <td> <input name="password" value="${residentDetail.password}"/></td>
                        <td> <input type="date" name="date" value="${residentDetail.dateOfBirth}"/></td>
                        <td> <input name="name" value="${residentDetail.fullName}"/></td>
                        <td> <input name="phone" value="${residentDetail.phoneNumber}"/></td>                         
                        <td> <input name="address" value="${residentDetail.address}"/></td>
                        <td> <input name="avatar" value="${residentDetail.avatar}"/><img src="${residentDetail.avatar}"/></td>
                        <td>     <select name="status">
                                <option value="1">1</option>
                                <option value="0">0</option>

                            </select>   ${residentDetail.status} </td>
                    </tr>
                    <%      }
                    %>
                    <%
                        if (sel != null) {%>
                    <tr>
                        <td> <input type="hidden" name="id" value="${sellerDetail.getSaID()}"/>${sellerDetail.getSaID()}</td>
                        <td> <input type="hidden" name="role" value="${role}"/>${role}</td>
                        <td> <input name="email" value="${sellerDetail.getEmail()}"/></td>
                        <td> <input name="cid" value="${sellerDetail.getSCID()}"/></td>
                        <td> <input name="password" value="${sellerDetail.getPassword()}"/></td>
                        <td> <input type="date" name="date" value="${sellerDetail.getDateOfBirth()}"/></td>
                        <td> <input name="name" value="${sellerDetail.getFullName()}"/></td>
                        <td> <input name="phone" value="${sellerDetail.getPhoneNumber()}"/></td>                         
                        <td> <input name="address" value="${sellerDetail.getAddress()}"/></td>
                        <td> <input name="avatar" value="${sellerDetail.getAvatar()}"/><img src="${sellerDetail.getAvatar()}"/></td>
                        <td>     <select name="status">
                                <option value="1">1</option>
                                <option value="0">0</option>

                            </select>   ${sellerDetail.getStatus()} </td>
                    </tr>
                    <%      }
                    %>
                </tbody>
            </table>                                                                             
            <input type="submit" name="action" value="Update User"/>
        </form>

        <a href="AdminIndex.jsp">Admin Page</a>
        ${noti}
        <%} else {%>
        <h1>Access Denied</h1>
        <a href="Index.jsp">Back to login page</a>
        <%}%>
    </body>
</html>
