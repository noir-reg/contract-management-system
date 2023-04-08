<%-- 
    Document   : SellerIndex
    Created on : Feb 23, 2023, 10:06:19 AM
    Author     : mical
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, ${sessionScope.user.getFullName()}</h1>
        <!--Dung de view & edit profile -->
        <form action="MainController" method="post">
            <input type="submit" value="View Profile" name="action"/>
        </form>

        <!--Dung de logout-->
        <form action="MainController" method="post">
            <input type="submit" value="Logout" name="action"/>
        </form>

        <!--Dung de view all contracts-->
        <!--Nut nay dung o tren header-->
        <form action="MainController" method="post">
            <input type="submit" name="action" value="View Contract"/>
        </form>

        <table>
            <c:set var="contractStats" value="${requestScope.contractStats}"></c:set>
            <!--ContractStats = 1 : Co nhieu hon 2 contracts-->
            <!--ContractStats = 0 : Co 1 hoac 2 contracts-->
            <!--ContractStats = -1 : Khong co contracts-->
            <c:if test="${contractStats == 1}">
                <form action="MainController" method="post">
                    <input type="submit" value="View All Contract">
                    <input type="hidden" name="action" value="View Contract">
                </form>
                <c:forEach var="contract" items="${requestScope.contractList}">
                </c:forEach>
            </c:if>
            <c:if test="${contractStats == 1}">

                <!--View 2 contracts-->
                <c:forEach var="a" items="${requestScope.contractList}">
                    <tr><td>${a.toString()}</td></tr>
                </c:forEach>
            </c:if>

            <c:if test="${contractStats  == -1}" >
                <p>Khong co contract</p>
            </c:if>

            <!-- Dung de view 1 contracts-->
            <c:if test="${contractStats == 0}">
                <form action="MainController" method="post">
                    <input type="submit" value="View Contract">
                    <input type="hidden" name="action" value="View Contract">
                </form>
                <c:forEach var="contract" varStatus="counter" items="${requestScope.contractList}">
                    <tr><td>Contract's ID: ${contract.getCoID()}</td> <td>${contract.toString()}</td></tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
