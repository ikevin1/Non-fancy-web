<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comedian List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cart.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Comedians</h2>

        <button class="add-button" onclick="window.location.href='showAddComedianForm';return false;">
            Add Comedian
        </button>

    </div>
</div>

<form:form method="GET" action="search">
    Search comedians <input type="search" name="searchTerm">
    <input type="submit" value="Search" class="add-button">
</form:form>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Price</th>
                <th>Picture</th>
                <th>Description</th>
                <th>Date Added</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempComedian" items="${comedians}">
                <c:url var="updateLink" value="/comedian/showUpdateComedianForm">
                    <c:param name="comedianId" value="${tempComedian.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/comedian/delete">
                    <c:param name="comedianId" value="${tempComedian.id}"/>
                </c:url>

                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/img/${tempComedian.imagePath}"
                             alt="${tempComedian.name}">
                    </td>
                    <td>${tempComedian.name.name}</td>
                    <td>${tempComedian.price}</td>
                    <td>${tempComedian.description}</td>
                    <td>${tempComedian.picture}</td>
                    <td>${tempComedian.formattedDate}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
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
