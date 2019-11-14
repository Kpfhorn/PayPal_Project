package com.mycompany.paypaltest1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSettingChangeServlet")
public class UserSettingChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public UserSettingChangeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pswrdCheck=request.getParameter("pswrdCheck");
		
		Customer cust=(Customer)request.getSession(false).getAttribute("customer");
		
		if (request.getParameter("pswrdChange").equals(pswrdCheck)&&request.getParameter("oldPswrd").equals(cust.getPassword())) {
			cust.replacePswd(pswrdCheck);
			response.sendRedirect("userSettingsSuccessPassword.jsp");
		} else {
			response.sendRedirect("userSettingsFailPassword.jsp");
		}
	}
}
