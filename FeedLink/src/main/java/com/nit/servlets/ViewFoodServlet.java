package com.nit.servlets;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/viewFood")
public class ViewFoodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        try {
            Connection con = DBUtil.getCon();
            String role = (String) session.getAttribute("role");
            String user = (String) session.getAttribute("user");

            PreparedStatement ps;

            if ("rest".equals(role)) {
                ps = con.prepareStatement(
                        "SELECT * FROM FOOD_DETAILS WHERE REST_NAME=?"
                );
                ps.setString(1, user);
            } else {
                ps = con.prepareStatement(
                        "SELECT * FROM FOOD_DETAILS WHERE STATUS='AVAILABLE'"
                );
            }

            ResultSet rs = ps.executeQuery();

            req.setAttribute("data", rs);
            RequestDispatcher rd = req.getRequestDispatcher("viewFood.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error while viewing food");
        }
    }
}
