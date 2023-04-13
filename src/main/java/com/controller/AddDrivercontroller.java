package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddDriver;
import com.dao.Transport_dao;

/**
 * Servlet implementation class AddDrivercontroller
 */
@WebServlet("/AddDrivercontroller")
public class AddDrivercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrivercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String vechile=request.getParameter("vechile");
		String add=request.getParameter("add");
		String lic=request.getParameter("lic");
		
		
		AddDriver ob= new AddDriver(0, name, mobile, add, vechile, lic);
		int status=Transport_dao.AddDriver(ob);
		if(status>0) {
			out.print("<script> alert('Success') </script>");
			RequestDispatcher rd=request.getRequestDispatcher("loginhome.html");
			rd.include(request, response);
			
		}else {
			out.print("<script> alert('Something went wrong') </script>");
			RequestDispatcher rd=request.getRequestDispatcher("loginhome.html");
			rd.include(request, response);
		}
	}

}
