package com.mycompany.paypaltest1;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeteleEmployee")
public class DeteleEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeteleEmployee() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Delete delete = new Delete();

		if (delete.delete(request.getParameter("nameEmployee"), request.getParameter("employeeId")) == true) {
			response.sendRedirect("deleteSuccess.jsp");
		} else {
			response.sendRedirect("deleteFail.jsp");
		}
	}

}
