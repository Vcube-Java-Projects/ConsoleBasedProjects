package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dao.UserDao;
import com.model.TransactionModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transactionHistory")
public class TransactionHistoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		try {
			UserDao dao = new UserDao();
			List<TransactionModel> transactions = dao.getTransactions(username);
			
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("TransactionHistory.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error loading transactions.");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}
}
