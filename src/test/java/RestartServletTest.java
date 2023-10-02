import controllers.RestartServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestartServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("health")).thenReturn(null);
        when(request.getRequestDispatcher("/WEB-INF/question-radiation.jsp")).thenReturn(dispatcher);
    }

    @Test
    void shouldForwardToRestartPageWhenDoPostIsCalled() throws Exception {
        RestartServlet restartServlet = new RestartServlet();

        restartServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }
}
