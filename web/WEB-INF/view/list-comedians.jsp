<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Comedian List</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/cart.css">
</head>
<body>
<%@include file="/WEB-INF/view/includes/header.jsp"%>

<div id="container">

    <div id="content">
        <!--  <h2>Comedians</h2> -->

         <!-- add comedian button -->
        <button class="add-button"
                onclick="window.location.href='${contextPath}/comedian/user/showAddComedianForm';return false;">Add Comedian
        </button>

        <!-- search form -->

<form:form method="GET" action="search">
    Search comedians <input type="search" name="searchTerm">
    <input type="submit" value="Search" class="add-button">
</form:form>

        <!-- comedian list table -->
        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Picture</th>
                <th>Date Added</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempComedian" items="${comedians}">
                <!-- construct an "update" link with comedian id -->
                <!-- c:url is same as JSP's response.encodeURL() -->
                <c:url var="updateLink" value="/comedian/showUpdateComedianForm">
                    <c:param name="comedianId" value="${tempComedian.id}"/>
                </c:url>

                <!-- construct a "delete" link with comedian id -->
                <c:url var="deleteLink" value="/comedian/delete">
                    <c:param name="comedianId" value="${tempComedian.id}"/>
                </c:url>

                <tr>
                    <td>
                        <img src="${contextPath}/resources/img/${tempComedian.imagePath}"
                             alt="${tempComedian.name}">
                    </td>
                    <td>${tempComedian.name}</td>
                    <td>${tempComedian.price}</td>
                    <td>${tempComedian.description}</td>
                    <td>${tempComedian.picture}</td>

                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
                        <!-- display the delete link -->
                        <a href="${deleteLink}"
                           onclick="if(!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
