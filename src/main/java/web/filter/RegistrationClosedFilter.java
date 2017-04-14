package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import repository.ConferenceApplicationRepository;
import repository.DummyConferenceApplicationRepository;

@WebFilter({"/", "/add"})
public class RegistrationClosedFilter implements Filter {
	private ConferenceApplicationRepository repository;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		repository = new DummyConferenceApplicationRepository();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (repository.count() > 5) {
			response.getWriter().println("Rejestracja na konferencje zokonczyla sie.");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

}
