package com.educacionIt.javase.KillaCoffee.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.javase.KillaCoffee.service.UserAuthenticationService;
import com.educacionIt.javase.KillaCoffee.service.UserAuthenticationServiceImpl;
import com.educacionIt.javase.KillaCoffee.web.dto.AuthUsers;

/**
 * Servlet implementation class Login
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private final UserAuthenticationService userAuthenticationService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	userAuthenticationService = new UserAuthenticationServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	
	boolean isAuthenticated = userAuthenticationService.authenticateUser(userName, password);
	
	if(isAuthenticated) {
		AuthUsers authUsers = new AuthUsers(userName);
		request.getSession().setAttribute("auth-user", authUsers);
		response.sendRedirect("home");
	}else {
		request.setAttribute("error", "nombre de usuario o contraseña incorrecto");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	}

}
