<%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 18.09.2023
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Space Adventure - Victory</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>

<body>
<div class="centered-text">
    <h1>Congratulations! You have achieved victory in your space adventure!</h1>
    <p>You have successfully overcome all the challenges and obstacles during your mission and have reached your space
        journey's goal.</p>
    <form action="RestartServlet" method="post">
        <button class="space-button" type="submit" name="restart" value="restart">Start from the Beginning
        </button>
    </form>
</div>
<footer>
    <%@ include file="footer.jsp" %>
</footer>

<script>
    window.addEventListener('DOMContentLoaded', (event) => {
        const body = document.body;
        const savedTheme = localStorage.getItem('theme');
        if (savedTheme) {
            body.classList.add(savedTheme);
        }
    });
</script>
</body>
</html>
