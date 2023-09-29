<%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 17.09.2023
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Space Adventure</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>

<body>
<div class="centered-text">

    <h1>You come across a hostile alien spacecraft. What will you do? </h1>
    <form action="AnswerServlet" method="post">
        <button class="space-button" type="submit" name="answer" value="send_peace_signal"
                onclick="showAlert('You decided to send a peace signal and try to establish diplomatic relations with the hostile alien spacecraft.');">
            Send a peace signal and try to establish diplomatic relations.
        </button>
        <button class="space-button" type="submit" name="answer" value="engage_in_combat"
                onclick="showAlert('You decided to activate your weapons and engage in combat with the hostile alien spacecraft.Your health is decreased');">
            Activate your weapons and engage in combat.
        </button>
        <button class="space-button" type="submit" name="answer" value="evade_and_escape"
                onclick="showAlert('You decided to try to evade and escape the confrontation with the hostile alien spacecraft.');setTimeout(function() { closeAlert(); }, 10000);">
            Try to evade and escape the confrontation.
        </button>
    </form>
</div>

<script>
    function showAlert(message) {
        alert(message);
    }

    window.addEventListener('DOMContentLoaded', (event) => {
        const body = document.body;
        const savedTheme = localStorage.getItem('theme');
        if (savedTheme) {
            body.classList.add(savedTheme);
        }
    });
</script>


<footer>
    <%@ include file="footer.jsp" %>
</footer>
</body>
</html>