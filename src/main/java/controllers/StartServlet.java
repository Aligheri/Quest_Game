package controllers;

import entity.GameCounter;
import entity.HealthStatus;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/StartServlet")

public class StartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String username = request.getParameter("name");

        User user = new User(username);
        session.setAttribute("username", user);

        HealthStatus health = new HealthStatus(100);
        session.setAttribute("health", health);

        GameCounter gameCounter = new GameCounter();
        session.setAttribute("gameCounter", gameCounter);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/question-radiation.jsp");
        dispatcher.forward(request, response);
    }
}
