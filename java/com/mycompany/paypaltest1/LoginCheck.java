package com.mycompany.paypaltest1;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("userid");
		String pswrd = request.getParameter("pswrd");
		String type = request.getParameter("selectType");

		HttpSession session = request.getSession(true);

		Employee employ = new Employee();
		Customer cust = new Customer();
		try {

			if (user.equals("admin") && pswrd.equals("password") && type.equals("manager")) {

				response.sendRedirect("welcomePageManager.jsp");

			} else if (cust.getUsernameDB(user) == true && cust.getPassword().equals(pswrd)
					&& type.equals("customer")) {

				response.sendRedirect("welcomePageCustomer.jsp");
				session.setAttribute("customer", cust);

			} else if (type.equals("employee")) {
				if (employ.getIDDB(Integer.parseInt(user)) == true && employ.getPassword().equals(pswrd)) {
					response.sendRedirect("welcomePageEmpolyee.jsp");
					session.setAttribute("employee", employ);
				}

			} else {
				response.sendRedirect("errorLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
