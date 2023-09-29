package controllers;

import entity.HealthStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet("/RestartServlet")
public class RestartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        HealthStatus health = new HealthStatus(100);
        session.setAttribute("health", health);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/question-radiation.jsp");
        dispatcher.forward(request, response);
    }

}
