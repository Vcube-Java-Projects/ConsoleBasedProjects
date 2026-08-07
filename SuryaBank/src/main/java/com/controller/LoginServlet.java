package com.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.UserDao;
import com.utility.Utility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try {
			UserDao dao = new UserDao();
			if (dao.validateUser(username, password)) {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				res.sendRedirect("dashboard.jsp");
			} else {
				req.setAttribute("error", "Invalid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
