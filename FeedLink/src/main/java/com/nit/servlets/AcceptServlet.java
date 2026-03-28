package com.nit.servlets;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/accept")
public class AcceptServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        try {
            Connection con = DBUtil.getCon();
            int id = Integer.parseInt(req.getParameter("id"));

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE FOOD_DETAILS SET STATUS='ACCEPTED' WHERE ID=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            res.sendRedirect(req.getContextPath() + "/viewFood");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error while accepting request");
        }
    }
}
