package com.nit.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String role = request.getParameter("role");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("role", role);

		if ("rest".equals(role)) {
			response.sendRedirect("addFood.html");
		} else if ("ngo".equals(role)) {
			response.sendRedirect("viewFood.jsp");
		} else {
			response.sendRedirect("login.html");
		}
	}
}