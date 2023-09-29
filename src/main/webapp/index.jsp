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
    <title>Quest_Game</title>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>
<body>

<div class="centered-text">
    <button id="theme-toggle" class="space-button" onclick="toggleTheme()">Change theme</button>
    <header>
        <h1>Prologue</h1>
    </header>
    <section>
        <p>You are the captain of a spaceship, traveling into the depths of space.
            Your mission is to explore uncharted planets and gather valuable data for scientific research.
            But space is full of dangers, and your health is crucial.</p>
    </section>
    <section>
        <h2>Meet the crew</h2>
        <p> when you boarded the ship, you were greeted by a girl with a black folder in her hands:
            - Hello, commander! I'm Zinaida - your assistant. Do you see?
            There, in the corner, our navigator, Sergeant Pupka , is drinking coffee, our flight mechanic, Black
            Hole
            Punch, is sleeping under the helm,
            and John Quark, our navigator, is photographing him.</p>
    </section>
    <h2>Introduce yourself</h2>

    <form action="StartServlet" method="post">
        <label for="name">Your name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit" class="space-button">introduce yourself</button>
    </form>
</div>

<script>
    function toggleTheme() {
        const body = document.body;
        if (body.classList.contains('dark-theme')) {
            body.classList.remove('dark-theme');
            body.classList.add('light-theme');

            localStorage.setItem('theme', 'light-theme');
        } else {
            body.classList.remove('light-theme');
            body.classList.add('dark-theme');

            localStorage.setItem('theme', 'dark-theme');
        }
    }
</script>
</body>

</html>
