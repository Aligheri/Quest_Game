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
    <title>Space Emergency</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>

<body>
<div class="centered-text">
    <h1>You encounter an asteroid field. What action will you take?</h1>
    <form action="AnswerServlet" method="post">
        <button class="space-button" type="submit" name="answer" value="fly_through_asteroids"
                onclick="showAlert('You decided to attempt to fly through the asteroid field.Your ship have crashed.');">
            Attempt to fly through the asteroids.
        </button>
        <button class="space-button" type="submit" name="answer" value="maneuver_around_asteroids"
                onclick="showAlert('You decided to try to maneuver around the asteroid field.');">Try to maneuver around
            the asteroids.
        </button>
        <button class="space-button" type="submit" name="answer" value="collect_samples_from_asteroids"
                onclick="showAlert('You decided to attempt to collect samples from the asteroids.');">Attempt to collect
            samples from the asteroids.
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
