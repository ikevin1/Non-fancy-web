<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add New Comedian</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cart.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-comedian-cart.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>New Comedian</h2>
    </div>
</div>
<%@include file="/WEB-INF/view/includes/header.jsp"%>
<div id="container">
    <div id="content">
        <%--@elvariable id="aComedian" type=""--%>
        <form:form action="${contextPath}/comedian/save" modelAttribute="aComedian" enctype="multipart/form-data">
            <form:hidden path="id" value="${aComedian.id}"/>
<%--            <form:hidden path="comedianImage" value="${comedian.imageFilename}"/>--%>
<%--            <form:hidden path="dateAdded" value="${aComedian.dateAdded}"/>--%>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><form:input path="description"/>
                        <form:errors path="description" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Price</label></td>

                    <td><input type="number" name="price" min="1" max="500" >
                    </td>
                        <form:errors path="price" cssClass="error"/>

                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td><input type="file" name="comedianImage"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>

            <%@include file="/WEB-INF/view/includes/footer.jsp"%>
    </div>
</div>
</body>

<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Kevin.</p>
    </div>
</footer>
</html>
