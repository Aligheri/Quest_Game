package controllers;

import entity.GameCounter;
import entity.HealthStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String answer = request.getParameter("answer");

        HealthStatus health = (HealthStatus) session.getAttribute("health");
        if (health == null) {
            health = new HealthStatus(100);
            session.setAttribute("health", health);
        }

        RequestDispatcher dispatcher = null;

        if ("avoid_radiation".equals(answer)) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp");
        } else if ("investigate_radiation".equals(answer)) {
            health.decreaseHealth(35);
            session.setAttribute("health", health);
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp");
        } else if ("send_drone".equals(answer)) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp");
        } else if ("fly_through_asteroids".equals(answer)) {
            health.decreaseHealth(100);
            session.setAttribute("health", health);
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-alien.jsp");
        } else if ("maneuver_around_asteroids".equals(answer)) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-alien.jsp");
        } else if ("collect_samples_from_asteroids".equals(answer)) {
            health.decreaseHealth(20);
            session.setAttribute("health", health);
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-alien.jsp");
        } else if ("send_peace_signal".equals(answer)) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-planet.jsp");
        } else if ("engage_in_combat".equals(answer)) {
            health.decreaseHealth(40);
            session.setAttribute("health", health);
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-planet.jsp");
        } else if ("evade_and_escape".equals(answer)) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/question-planet.jsp");
        } else if ("land_and_explore".equals(answer)) {
            health.decreaseHealth(20);
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/win.jsp");
            incrementNumberOfGames(request);
        } else if ("continue_mission".equals(answer)) {
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/win.jsp");
            incrementNumberOfGames(request);
        } else if ("send_drone_for_exploration".equals(answer)) {
            checkPlayerHealthAndRedirect(request, response);
            dispatcher = request.getRequestDispatcher("/WEB-INF/win.jsp");
            incrementNumberOfGames(request);
        }

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    public void incrementNumberOfGames(HttpServletRequest request) {
        HttpSession session = request.getSession();
        GameCounter gameCounter = (GameCounter) session.getAttribute("gameCounter");
        if (gameCounter == null) {
            gameCounter = new GameCounter();
        }
        gameCounter.incrementNumberOfGames();
        session.setAttribute("gameCounter", gameCounter);
    }


    public void checkPlayerHealthAndRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HealthStatus health = (HealthStatus) session.getAttribute("health");

        if (health == null || health.getHealth() <= 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lose.jsp");
            incrementNumberOfGames(request);
            dispatcher.forward(request, response);
        }
    }
}
