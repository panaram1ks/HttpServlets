<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
    <span>content. Русский</span>
    <p>Size: ${requestScope.flights.size()}</p>
    <p>Id 1th way : ${requestScope.flights.get(0).id}</p>
    <%--    necessary collection allow access by index!!!   --%>
    <p>Id 2th way: ${requestScope.flights[1].id}</p>
    <p>Map: ${sessionScope.flightsMap[1]}</p>
    <p>JSESSION id: ${cookie["JSESSIONID"].value}, unique identifier</p>
    <p>Header: ${header["Cookie"]}</p>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>
    <p>Empty list: ${not empty flights}</p>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
