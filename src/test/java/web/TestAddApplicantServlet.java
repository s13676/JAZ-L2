package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import domain.ConferenceApplication;
import repository.ConferenceApplicationRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestAddApplicantServlet extends Mockito {
	@Spy
	ConferenceApplicationRepository repository = mock(ConferenceApplicationRepository.class);
	
	@InjectMocks
	AddApplicantServlet servlet;
	
	@Test
	public void servlet_should_write_info_about_applicant_session() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(req.getSession()).thenReturn(session);
		servlet.doGet(req, resp);
		verify(session).setAttribute(eq("conf"), Mockito.any(ConferenceApplication.class));
	}
	
	@Test
	public void servlet_should_add_form_data_into_repository() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(req.getSession()).thenReturn(session);
		servlet.doGet(req, resp);
		verify(resp).sendRedirect("success.jsp");
	}
	
	@Test
	public void servlet_should_properly_redirect_user() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(req.getSession()).thenReturn(session);
		servlet.doGet(req, resp);
		verify(resp).sendRedirect("success.jsp");
	}
}
