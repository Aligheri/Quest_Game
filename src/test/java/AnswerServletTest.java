import controllers.AnswerServlet;
import entity.GameCounter;
import entity.HealthStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AnswerServletTest {

    @InjectMocks
    private AnswerServlet answerServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(request.getSession(true)).thenReturn(session);
    }

    @Test
    void testDoPostAvoidRadiation() throws Exception {
        when(request.getParameter("answer")).thenReturn("avoid_radiation");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("health")).thenReturn(new HealthStatus(100));
        when(request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp")).thenReturn(dispatcher);

        AnswerServlet answerServlet = new AnswerServlet();
        answerServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPostInvestigateRadiation() throws Exception {
        when(request.getParameter("answer")).thenReturn("investigate_radiation");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("health")).thenReturn(new HealthStatus(100));
        when(request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp")).thenReturn(dispatcher);

        AnswerServlet answerServlet = new AnswerServlet();
        answerServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPostSendDrone() throws Exception {
        when(request.getParameter("answer")).thenReturn("send_drone");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("health")).thenReturn(new HealthStatus(100));
        when(request.getRequestDispatcher("/WEB-INF/question-asteroids.jsp")).thenReturn(dispatcher);

        AnswerServlet answerServlet = new AnswerServlet();
        answerServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPostLandAndExplore() throws Exception {
        when(request.getParameter("answer")).thenReturn("land_and_explore");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("health")).thenReturn(new HealthStatus(100));
        when(request.getRequestDispatcher("/WEB-INF/win.jsp")).thenReturn(dispatcher);

        AnswerServlet answerServlet = new AnswerServlet();
        answerServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testIncrementNumberOfGames() {

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        GameCounter gameCounter = new GameCounter();

        when(session.getAttribute("gameCounter")).thenReturn(gameCounter);


        answerServlet.incrementNumberOfGames(request);


        assertEquals(1, gameCounter.getNumberOfGames());
    }

    @Test
    public void testCheckPlayerHealthAndRedirect() throws Exception {
        answerServlet = new AnswerServlet();

        when(request.getSession()).thenReturn(session);


        HealthStatus lowHealth = mock(HealthStatus.class);
        when(lowHealth.getHealth()).thenReturn(0);
        when(session.getAttribute("health")).thenReturn(lowHealth);

        when(request.getRequestDispatcher("/WEB-INF/lose.jsp")).thenReturn(dispatcher);

        answerServlet.checkPlayerHealthAndRedirect(request, response);

        verify(session, times(1)).getAttribute("health");
        verify(dispatcher, times(1)).forward(request, response);
    }
}












