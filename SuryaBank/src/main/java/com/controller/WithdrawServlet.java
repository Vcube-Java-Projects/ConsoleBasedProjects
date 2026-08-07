package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.dao.UserDao;
import com.utility.Utility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		double amount = Double.parseDouble(req.getParameter("amount"));

		try {
			UserDao dao = new UserDao();
			double current = dao.getBalance(username);
			if (amount <= current) {
				dao.updateBalance(username, current - amount);
				dao.logTransaction(username, "withdraw", amount);

				res.sendRedirect("dashboard.jsp?message=WithdrawSuccess");
			} else {
				req.setAttribute("error", "Insufficient balance");
				req.getRequestDispatcher("dashboard.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
