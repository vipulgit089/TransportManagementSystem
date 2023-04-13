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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String vech=request.getParameter("vechile");
		String address=request.getParameter("address");
		String lic=request.getParameter("lic");
		
		//System.out.println("vehical"+vechile);
		//System.out.println("Address"+address);
		
		AddDriver ad=new AddDriver(id, name, mobile, address, vech, lic);
		int status=Transport_dao.updateEmployee(ad);
		if (status>0) {
			
		    out.print("<script> alert('data updated')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ViewDrivercontroller");
			rd.include(request, response);
			out.print("Data updated");
			
		}else
		{
			out.print("<script> alert('something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ViewDrivercontroller");
			rd.include(request, response);
		}
	}

}
