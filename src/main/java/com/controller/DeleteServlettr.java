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
 * Servlet implementation class DeleteServlettr
 */
@WebServlet("/DeleteServlettr")
public class DeleteServlettr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlettr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int status=Transport_dao.deleteTransport(id);
		
		if (status>0) {
			out.print("<script> alert('data deleted')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ViewTransportcontroller");
			rd.include(request, response);
			
		}else
		{
			out.print("<script> alert('something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ViewTransportcontroller");
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
