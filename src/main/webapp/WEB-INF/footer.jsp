<%@ page import="entity.HealthStatus" %>
<%@ page import="entity.GameCounter" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 18.09.2023
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<footer>
    <table>
        <tr>
            <td>IP Address:</td>
            <td><%= request.getRemoteAddr() %>
            </td>
        </tr>
        <tr>
            <td>Player Name:</td>
            <td><% User user = (User) session.getAttribute("username"); %>
                <% if (user != null) { %>
                <%= user.getUsername() %>
                <% } %>
            </td>
        </tr>
        <tr>
            <td>Number of games played:</td>
            <td><% GameCounter counter = (GameCounter) session.getAttribute("gameCounter"); %>
                <% if (counter != null) { %>
                <%= counter.getNumberOfGames() %>
                <% } %>
            </td>
        </tr>
        <tr>
            <td>Health:</td>
            <td><% HealthStatus health = (HealthStatus) session.getAttribute("health"); %>
                <% if (health != null) { %>
                <%= health.getHealth() %>
                <% } %>
            </td>
        </tr>
    </table>
</footer>
</body>
</html>
