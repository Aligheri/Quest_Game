<%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 17.09.2023
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <title>Cosmic radiation</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>
<body>


<div class="centered-text">
    <h1>Your ship enters an area of cosmic radiation. What will you do?</h1>
    <form action="AnswerServlet" method="post">
        <button class="space-button" type="submit" name="answer" value="avoid_radiation"
                onclick="showAlert('You decided to rise above and avoid the cosmic radiation. Your health decreased due to radiation exposure.');">
            Rise above and avoid the radiation.
        </button>
        <button class="space-button" type="submit" name="answer" value="investigate_radiation"
                onclick="showAlert('You decided to continue the mission despite the cosmic radiation.');">Try to
            investigate and study the radiation.
        </button>
        <button class="space-button" type="submit" name="answer" value="send_drone"
                onclick="showAlert('You sent a drone to investigate the cosmic radiation.')">Send a drone for
            investigation.
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




