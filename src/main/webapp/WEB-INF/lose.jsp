<%--
  Created by IntelliJ IDEA.
  User: ivanev
  Date: 17.09.2023
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>You Lost</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>
<body>
<div class="centered-text">
    <h1>Oops! You've encountered a setback in your space journey.</h1>
    <p>Space adventures can be challenging, but don't give up. Would you like to give it another try?</p>

    <form action="RestartServlet" method="post">
        <button class="space-button" type="submit" name="restart" value="yes">Yes, I'll Try Again</button>
    </form>
</div>

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

