<%-- 
    Document   : wwTestPage
    Created on : Mar 1, 2023, 12:54:07 AM
    Author     : mical
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.OProfile.getFullName()}Profile</title>
    </head>
    <body>
        <h1>Welcome, ${sessionScope.user.getFullName()}</h1>  
        <p><a href="MainController?action=Find2contracts">HOME PAGE</a></p>
        <c:set var="profileType" value="${requestScope.profileType}"></c:set>
        <c:set var="edit" value="${requestScope.edit}"></c:set>
            <table>
            <c:if test="${edit = "true"}">
                <form action="MainController" method="post">
                    <tr><td>View Image: ${requestScope.viewProfile.getAvatar()}</td></tr>
                    <tr>
                        <td>Full name</td>
                        <td><input type="text" name="txtFullName"value="${requestScope.txtFullName}"/></td>
                        <td>${requestScope.nameError}</td>
                    </tr>
                    <tr><td>Email</td> <td>${requestScope.viewProfile.getEmail()}</td></tr>
                    <c:if test="${(profileType == 'C')}">
                        <tr>
                            <td>CID</td>
                            <td><input type="text" name="txtcid" value="${requestScope.viewProfile.getCCID()}"></td>
                            <td>${requestScope.CIDError}</td>
                        </tr>
                    </c:if>
                    <c:if test="${(profileType == 'O')}">
                        <tr>
                            <td>CID</td>
                            <td><input type="text" name="txtcid" value="${requestScope.viewProfile.getOCID()}"></td>
                            <td>${requestScope.CIDError}</td>
                        </tr>
                    </c:if>
                    <c:if test="${(profileType == 'R')}">
                        <tr>
                            <td>CID</td>
                            <td><input type="text" name="txtcid" value="${requestScope.viewProfile.getRCID()}"></td>
                            <td>${requestScope.CIDError}</td>
                        </tr>
                    </c:if>
                    <c:if test="${(profileType == 'S')}">
                        <tr>
                            <td>CID</td>
                            <td><input type="text" name="txtcid" value="${requestScope.viewProfile.getSCID()}"></td>
                            <td>${requestScope.CIDError}</td>
                        </tr>
                    </c:if>    
                    <tr>
                        <td>Date of birth</td>
                        <td><input type="date" name="txtDate" value="${requestScope.txtDate}"/></td>
                        <td>${requestScope.DoBError}</td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="txtAddress" value="${requestScope.address}"/></td>
                        <td>${requestScope.addressError}</td>
                    </tr>
                    <tr><td><input type="submit" name="action" value="Save Profile"/></td><td></td></tr>
                    <tr><td>${requestScope.noti}</td></tr>
                </form>
            </c:if>

            <c:if test="${edit != "true"}">
                <tr><td>View Image: </td><td>${requestScope.viewProfile.getAvatar()}</td></tr>
                <tr><td>Full name</td><td>${requestScope.viewProfile.getFullName()}</td></tr>
                <tr><td>Email</td><td>${requestScope.viewProfile.getEmail()}</td></tr>
                <c:if test="${profileType=='S'}">
                    <tr><td>Role</td><td>Seller</td></tr>
                    <tr><td>ID</td><td>${requestScope.viewProfile.getSaID()}</td></tr>
                    <tr><td>CID</td><td>${requestScope.viewProfile.getSCID()}</td></tr>
                </c:if>
                <c:if test="${profileType=='O'}">
                    <tr><td>Role</td><td>Owner</td></tr>
                    <tr><td>ID</td><td>${requestScope.viewProfile.getOID()}</td></tr>
                    <tr><td>CID</td><td>${requestScope.viewProfile.getOCID()}</td></tr>
                </c:if>
                <c:if test="${profileType=='C'}">
                    <tr><td>Role</td><td>Customer</td></tr>
                    <tr><td>ID</td><td>${requestScope.viewProfile.getCID()}</td></tr>
                    <tr><td>CID</td><td>${requestScope.viewProfile.getCCID()}</td></tr>
                </c:if>
                <c:if test="${profileType=='R'}">
                    <tr><td>Role</td><td>Resident</td></tr>
                    <tr><td>ID</td><td>${requestScope.viewProfile.getRID()}</td></tr>
                    <tr><td>CID</td><td>${requestScope.viewProfile.getRCID()}</td></tr>
                </c:if>
                <tr><td>Date of birth</td><td>${requestScope.viewProfile.getDateOfBirth()}</td></td></tr>
                <tr><td>Address</td><td>${requestScope.viewProfile.getAddress()}</td></tr>
            </c:if>
        </table>

    </body>
</html>

