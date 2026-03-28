package com.nit.servlets;

import java.io.IOException;
import java.util.List;

import com.nit.model.Food;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/requestFood")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String indexStr = request.getParameter("index");

		ServletContext context = getServletContext();
		List<Food> foodList = (List<Food>) context.getAttribute("foodList");

		if (foodList != null && indexStr != null) {
			int index = Integer.parseInt(indexStr);

			if (index >= 0 && index < foodList.size()) {
				Food selectedFood = foodList.remove(index);

				HttpSession session = request.getSession();
				session.setAttribute("selectedFood", selectedFood);
				session.setAttribute("requestSuccess", "Food requested successfully! Please upload image proof.");
			}

			context.setAttribute("foodList", foodList);
		}

		response.sendRedirect("viewFood.jsp");
	}
}