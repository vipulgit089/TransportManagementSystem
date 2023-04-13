package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Signup;
import com.dao.Transport_dao;

/**
 * Servlet implementation class ForgotPasswordcontroller
 */
@WebServlet("/ForgotPasswordcontroller")
public class ForgotPasswordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Signup ad= new Signup(password, email, password);
		int status=Transport_dao.forgotpass(ad);
		if (status>0) {
			out.print("<script> alert('Password Changed')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}else
		{
			out.print("<script> alert('something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
