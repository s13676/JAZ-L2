package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
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
import web.filter.ApplicationDataInSessionFilter;
import web.filter.RegistrationClosedFilter;

@RunWith(MockitoJUnitRunner.class)
public class TestFilter extends Mockito {
	@Spy
	ConferenceApplicationRepository repository = mock(ConferenceApplicationRepository.class);
	
	@InjectMocks
	ApplicationDataInSessionFilter dataInSessionFilter;
	
	@InjectMocks
	RegistrationClosedFilter registrationClosedFilter;
	
	@Test
	public void filter_should_accept_form_if_already_send() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		ConferenceApplication app = mock(ConferenceApplication.class);
		PrintWriter writer = mock(PrintWriter.class);
		FilterChain chain = mock(FilterChain.class);
		
		when(req.getSession()).thenReturn(session);
		when(resp.getWriter()).thenReturn(writer);
		when(req.getSession().getAttribute("conf")).thenReturn(app);
		
		dataInSessionFilter.doFilter(req, resp, chain);
		verify(writer).print("Twoje zgloszenie zostalo juz przeslane.");	
	}
	
	@Test
	public void filter_should_deny_form_if_there_is_already_five_applies() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		PrintWriter writer = mock(PrintWriter.class);
		FilterChain chain = mock(FilterChain.class);
		
		when(repository.count()).thenReturn(6);
		when(resp.getWriter()).thenReturn(writer);
		when(req.getSession()).thenReturn(session);
		
		registrationClosedFilter.doFilter(req, resp, chain);
		verify(writer).println("Rejestracja na konferencje zokonczyla sie.");
	}
}
