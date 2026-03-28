package com.nit.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.nit.model.Food;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addFood")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String restaurantUser = session != null ? (String) session.getAttribute("username") : "Restaurant User";

		String foodName = request.getParameter("foodName");
		String quantity = request.getParameter("quantity");
		String expiresStr = request.getParameter("expires");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		int expiresInHours = 0;
		if (expiresStr != null && !expiresStr.trim().isEmpty()) {
			expiresInHours = Integer.parseInt(expiresStr);
		}

		Food food = new Food();
		food.setRestaurantUser(restaurantUser);
		food.setFoodName(foodName);
		food.setQuantity(quantity);
		food.setExpiresInHours(expiresInHours);
		food.setPhone(phone);
		food.setAddress(address);

		ServletContext context = getServletContext();

		List<Food> foodList = (List<Food>) context.getAttribute("foodList");
		if (foodList == null) {
			foodList = new ArrayList<>();
		}

		foodList.add(food);
		context.setAttribute("foodList", foodList);

		String msg = URLEncoder.encode("Food added successfully!", StandardCharsets.UTF_8);
		response.sendRedirect("addFood.html?msg=" + msg);
	}
}