<%@ page import="com.dmdev.application.service.TicketService" %>
<%@ page import="com.dmdev.application.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Купленные билеты:</h1>
<ul>
    <%--    Scriplet example    --%>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
</ul>
</body>
</html>

<%! public void jspInit(){
    System.out.println("Hello world 999 !");
}
%>

