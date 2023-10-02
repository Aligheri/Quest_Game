package services;

import entity.GameCounter;
import entity.HealthStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class GameService {
    public String processAnswer(String answer, HealthStatus health, HttpSession session) {
        if ("avoid_radiation".equals(answer)) {
            return "question-asteroids";
        } else if ("investigate_radiation".equals(answer)) {
            health.decreaseHealth(35);
            session.setAttribute("health", health);
            return "question-asteroids";
        } else if ("send_drone".equals(answer)) {
            return "question-asteroids";
        } else if ("fly_through_asteroids".equals(answer)) {
            health.decreaseHealth(100);
            session.setAttribute("health", health);
            return "question-alien";
        } else if ("maneuver_around_asteroids".equals(answer)) {
            return "question-alien";
        } else if ("collect_samples_from_asteroids".equals(answer)) {
            health.decreaseHealth(20);
            session.setAttribute("health", health);
            return "question-alien";
        } else if ("send_peace_signal".equals(answer)) {
            return "question-planet";
        } else if ("engage_in_combat".equals(answer)) {
            health.decreaseHealth(40);
            session.setAttribute("health", health);
            return "question-planet";
        } else if ("evade_and_escape".equals(answer)) {
            return "question-planet";
        } else if ("land_and_explore".equals(answer) || "continue_mission".equals(answer) || "send_drone_for_exploration".equals(answer)) {
            health.decreaseHealth(20);
            session.setAttribute("health", health);
            return "win";
        }

        return "lose";
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

    public boolean checkPlayerHealth(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HealthStatus health = (HealthStatus) session.getAttribute("health");
        return health != null && health.getHealth() > 0;
    }
}
