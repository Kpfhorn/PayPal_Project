package com.mycompany.paypaltest1;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WorkClockInOutServlet")
public class WorkClockInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkClockInOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employ=(Employee)request.getSession(false).getAttribute("employee");
		if(employ.isValidClockIn()==true) {
			employ.clockIn();
			response.sendRedirect("clockInSuccess.jsp");
		}else {
			response.sendRedirect("clockInFail.jsp");
		}
		
		
	}

}
