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
 * Servlet implementation class Signupcontroller
 */
@WebServlet("/Signupcontroller")
public class Signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		
		
		Signup obj= new Signup(name, email, password);
		
		
		int status=Transport_dao.signup(obj);
		if(status>0) {
			out.print("<script> alert('You have Signup')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}else {
			out.print("<script> alert('Something went wrong') </script>");
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
	}

}
