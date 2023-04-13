package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddTransport;
import com.dao.Transport_dao;

/**
 * Servlet implementation class updatecontrollertr
 */
@WebServlet("/updatecontrollertr")
public class updatecontrollertr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontrollertr() {
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
		String Consignor_Name=request.getParameter("Consignor_Name");
		String Consignor_Mobile=request.getParameter("Consignor_Mobile");
		String Consignee_Name=request.getParameter("Consignee_Name");
		String Consignee_Mobile=request.getParameter("Consignee_Mobile");
		String Consignee_Address=request.getParameter("Consignee_Address");
		String Driver_Assigned=request.getParameter("Driver_Assigned");
		
		AddTransport ad= new AddTransport(Consignor_Name, Consignor_Mobile, Consignee_Name, Consignee_Mobile, Consignee_Address, Driver_Assigned, id);
		int status=Transport_dao.updateTR(ad);
		if (status>0) {
			out.print("<script> alert('data updated')</script>");
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
