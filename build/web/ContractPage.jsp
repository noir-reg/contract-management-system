<%-- 
    Document   : ContractPage
    Created on : Feb 13, 2023, 12:47:53 AM
    Author     : mical
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="abc.contract.ContractDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contract Manage</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.user}"/>
        <c:set var="contractList" value="${requestScope.contractList}"></c:set>
        <form action="MainController" method="post">
            <input type="submit" value="Logout" name="action"/>
        </form>
        <p><a href="Find2ContractsServlet">HOME PAGE</a></p>
        <form action="MainController" method="post">
            <input type="text" name="txtSearchName"/>
            <input type="date" name="txtFromDate"/>
            <input type="date" name="txtToDate"/>
            <select name="txtStatus">
                <option value="-1" selected="selected">All</option>
                <option value="0">Not Signed</option>
                <option value="1">Signed</option>
                <option value="2">Expired</option>
            </select>
            <input type="submit" name="action" value="Search Contract"/>
        </form>
        <p></p>
        <table>
            <c:forEach var="contract" items="${contractList}">
                <tr><td>${contract.toString()}</td></tr>
                <c:set var="RID" value="${contract.getRID()}"></c:set>
                <c:set var="SaID" value="${contract.getSaID()}"></c:set>
                <c:set var="CID" value="${contract.getCID()}"></c:set>
                <c:set var="userType" value="${sessionScope.userType}"></c:set>
                <c:if test="${userType == 'C'}">
                    <c:set var="CID" value="${0}"></c:set>
                </c:if>
                <c:if test="${userType == 'R'}">
                    <c:set var="RID" value="${0}"></c:set>
                </c:if>
                <c:if test="${userType == 'O'}">
                    <c:set var="OID" value="${0}"></c:set>
                </c:if>
                <c:if test="${userType == 'S'}">
                    <c:set var="SaID" value="${0}"></c:set>
                </c:if>
                <!--View Customer-->
                <c:if test="${(CID != 0)}">
                    <tr>
                        <td>Customer: </td>
                        <td>
                            <form action="MainController" method="post">
                                <input type="submit" value="${contract.getCName()}"/>
                                <input type="hidden" value="viewCustomerProfile" name="action"/>
                                <input type="hidden" value="${contract.getCID()}" name="CID"/>
                            </form>
                        </td>
                    </tr>
                </c:if>

                <!--View Owner-->
                <c:if test="${(OID != 0)}">
                    <tr>
                        <td>Owner: </td>
                        <td>
                            <form action="MainController" method="post">
                                <input type="submit" value="${contract.getOName()}"/>
                                <input type="hidden" value="viewOwnerProfile" name="action"/>
                                <input type="hidden" value="${contract.getOID()}" name="OID"/>
                            </form>
                        </td>
                    </tr>
                </c:if>

                <!--View Seller-->
                <c:if test="${SaID != 0}">
                    <tr>
                        <td>Seller:</td>
                        <td>
                            <form action="MainController" method="post">
                                <input type="submit" value="${contract.getSname()}"/>
                                <input type="hidden" value="viewSellerProfile" name="action"/>
                                <input type="hidden" value="${contract.getSaID()}" name="SID"/>
                            </form>
                        </td>
                    </tr>
                </c:if>

                <!--View Resident-->
                <c:if test="${RID != 0}">
                    <tr>
                        <td>Resident:</td>
                        <td>
                            <form action="MainController" method="post">
                                <input type="submit" value="${contract.getRName()}"/>
                                <input type="hidden" value="viewResidentProfile" name="action"/>
                                <input type="hidden" value="${contract.getRID()}" name="RID"/>
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>

    </body>
</html>
