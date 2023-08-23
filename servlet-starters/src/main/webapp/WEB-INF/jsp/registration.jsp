<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post" enctype="multipart/form-data">
    <lable for="name">Name:
        <input type="text" name="name" id="name">
    </lable>
    <br>
    <lable for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday">
    </lable>
    <br>
    <lable for="name">Email:
        <input type="text" name="email" id="email">
    </lable>
    <br>
    <lable for="password">Password:
        <input type="password" name="password" id="password">
    </lable>
    <br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select><br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}">${gender}<br>
    </c:forEach>
    <lable for="image">IMG:
        <input type="file" name="image" id="image" required>
    </lable>
    <button type="submit">send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>

</form>
</body>
</html>
