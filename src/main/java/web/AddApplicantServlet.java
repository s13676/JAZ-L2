package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ConferenceApplication;
import repository.ConferenceApplicationRepository;
import repository.DummyConferenceApplicationRepository;

@WebServlet("/add")
public class AddApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConferenceApplicationRepository repository;
	
	public void init(ServletConfig config) throws ServletException {
		repository = new DummyConferenceApplicationRepository();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ConferenceApplication app = retrieveApplicationFromRequest(req);
		
		session.setAttribute("conf", app);
		
		repository.add(app);
		resp.sendRedirect("success.jsp");
	}
	private ConferenceApplication retrieveApplicationFromRequest (HttpServletRequest req) {
		ConferenceApplication app = new ConferenceApplication();
		app.setName(req.getParameter("name"));
		app.setSurname(req.getParameter("surname"));
		app.setAdvertisement(req.getParameter("info"));
		app.setEmail(req.getParameter("email"));
		app.setEmployment(req.getParameter("employment"));
		
		return app;
	}
}
