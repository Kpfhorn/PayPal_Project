package com.mycompany.paypaltest1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public CreateUser() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Write writer = new Write();
		Validation valid = new Validation();
		if (true == valid.isValid(request.getParameter("email"))) {
			writer.write(request.getParameter("userid"), request.getParameter("pswrd"), request.getParameter("email"));
			response.sendRedirect("welcomePageCustomer.jsp");
		} else {
			response.sendRedirect("errorCreateUser.jsp");
		}
	}

}
