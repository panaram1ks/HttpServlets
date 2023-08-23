<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Header. Заголовок</h1>
<div>
    <c:if test="${not empty sessionScope.user}">
        <form action="/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </c:if>
</div>
