<%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 17.09.2023
  Time: 18:13
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
    <h1>You approach an unknown planet with a mysterious atmosphere. What is your decision?.</h1>
    <form action="AnswerServlet" method="post">
        <button class="space-button" type="submit" name="answer" value="land_and_explore"
                onclick="showAlert('You decided to land and embark on an exploration of the planet.Your health is decreased');">
            Land and embark
            on an exploration of the planet.
        </button>
        <button class="space-button" type="submit" name="answer" value="continue_mission"
                onclick="showAlert('You decided to fly past and continue the mission.');">Fly past and continue the
            mission.
        </button>
        <button class="space-button" type="submit" name="answer" value="send_drone_for_exploration"
                onclick="showAlert('You decided to send a drone for exploration.');">Send a drone for exploration.
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

