import controllers.StartServlet;
import entity.GameCounter;
import entity.HealthStatus;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class StartServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher dispatcher;


    @Test
    void testDoPost() throws Exception {
        MockitoAnnotations.initMocks(this);
        StartServlet startServlet = new StartServlet();

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("name")).thenReturn("TestUser");
        when(request.getRequestDispatcher("/WEB-INF/question-radiation.jsp")).thenReturn(dispatcher);

        startServlet.doPost(request, response);

        verify(session, times(1)).setAttribute(eq("username"), any(User.class));
        verify(session, times(1)).setAttribute(eq("health"), any(HealthStatus.class));
        verify(session, times(1)).setAttribute(eq("gameCounter"), any(GameCounter.class));
        verify(dispatcher, times(1)).forward(request, response);
    }
}









