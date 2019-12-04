<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div id="container">
    <div id="content">
        <%--@elvariable id="aComedian" type=""--%>
        <form:form action="save" modelAttribute="aComedian" enctype="multipart/form-data">
            <form:hidden path="id" value="${aComedian.id}"/>
            <form:hidden path="imageFilename" value="${aComedian.imageFilename}"/>
            <form:hidden path="dateAdded" value="${aComedian.dateAdded}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Descriptions</label></td>
                    <td><form:input path="descriptions"/>
                        <form:errors path="descriptions" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Price</label></td>
                    <td>
                        <form:select path="price" items="${price}" itemLabel="name" itemValue="id">
                        </form:select>
                    </td>
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
    </div>
</div>
</body>
</html>
