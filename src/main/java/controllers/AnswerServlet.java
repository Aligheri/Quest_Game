package controllers;

import entity.HealthStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.GameService;

import java.io.IOException;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    private final GameService gameService;

    public AnswerServlet() {
        this.gameService = new GameService();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String answer = request.getParameter("answer");

        HealthStatus health = (HealthStatus) session.getAttribute("health");

        if (health == null) {
            health = new HealthStatus(100);
            session.setAttribute("health", health);
        }

        String nextPage = gameService.processAnswer(answer, health, session);


        if (gameService.checkPlayerHealth(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/" + nextPage + ".jsp");
            dispatcher.forward(request, response);
            if ("win".equals(nextPage)) {
                gameService.incrementNumberOfGames(request);
            }
        } else {
            gameService.incrementNumberOfGames(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lose.jsp");
            dispatcher.forward(request, response);
        }

    }
}

