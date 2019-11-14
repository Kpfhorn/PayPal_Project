package com.mycompany.paypaltest1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddEmployee() {
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
		if (true == valid.isValid(request.getParameter("emailEmployee"))
				&& true == valid.isValidSSN(request.getParameter("ssn"))
				&& true == valid.isValidPhone(request.getParameter("phoneNumber"))
				&& true == valid.isValidBday(request.getParameter("bday"))
				&& true == valid.isValidLicNum(request.getParameter("lincenseNumber"))) {
			
			writer.account(request.getParameter("nameEmployee"), request.getParameter("addressEmployee"),
					request.getParameter("bday"), request.getParameter("emailEmployee"),
					request.getParameter("phoneNumber"), request.getParameter("ssn"),
					request.getParameter("lincenseNumber"));
			
			response.sendRedirect("successAddEmployee.jsp");
			
		} else {
			response.sendRedirect("failAddEmployee.jsp");
		}
	}

}
