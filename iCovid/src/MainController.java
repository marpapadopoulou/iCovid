

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String applicationContextPath = request.getContextPath();
		
		if (request.getRequestURI().equals(applicationContextPath + "/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equals(applicationContextPath + "/loginServlet")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equals(applicationContextPath + "/registerServlet")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equals(applicationContextPath + "/takeTest")) {
			
			System.out.println(request.getSession().getAttribute("loguser"));
			if (request.getSession().getAttribute("loguser") == null) {
				request.getRequestDispatcher("/loginServlet").forward(request,response);
				
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/test.jsp");
				dispatcher.forward(request, response);
			}
		
		}else if (request.getRequestURI().equals(applicationContextPath + "/logout")) {
			request.getSession().invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equals(applicationContextPath + "/about")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/about.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
