package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Transport_dao;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		boolean status=false;
		status=Transport_dao.login(email, password);
		if(status) {
			RequestDispatcher rd=request.getRequestDispatcher("loginhome.html");
			rd.forward(request, response);
		}else {
			out.print("<script> alert('Username or password is invalid') </script>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		
	}

}
