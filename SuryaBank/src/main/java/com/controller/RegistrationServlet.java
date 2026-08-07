package com.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.UserDao;
import com.model.UserModel;
import com.utility.Utility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try{
			UserModel u=new UserModel();
			u.setUsername(username);
			u.setPassword(password);
			UserDao dao = new UserDao();
			boolean status = dao.registerUser(u);
			if (status) {
				res.sendRedirect("login.jsp");
			} else {
				req.setAttribute("error", "Registration failed");
				req.getRequestDispatcher("register.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
