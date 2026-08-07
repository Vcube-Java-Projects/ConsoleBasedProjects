package com.controller;

import java.io.IOException;

import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		double amount = Double.parseDouble(req.getParameter("amount"));

		try {
			UserDao dao = new UserDao();
			double currentBalance = dao.getBalance(username);
			dao.updateBalance(username, currentBalance + amount);
			dao.logTransaction(username, "deposit", amount); // or "withdraw"

//			res.sendRedirect("dashboard.jsp");
			res.sendRedirect("dashboard.jsp?message=DepositSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Deposit failed");
			req.getRequestDispatcher("dashboard.jsp").forward(req, res);
		}
	}
}
