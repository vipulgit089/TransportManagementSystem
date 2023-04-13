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
 * Servlet implementation class AddTransportcontroller
 */
@WebServlet("/AddTransportcontroller")
public class AddTransportcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransportcontroller() {
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
		String consignor_name=request.getParameter("consignor_name");
	    String consignor_mobile=request.getParameter("consignor_mobile");
	    String consignee_name=request.getParameter("consignee_name");
	    String consignee_mobile=request.getParameter("consignee_mobile");
	    String consignee_address=request.getParameter("consignee_address");
	    String driver_assigned=request.getParameter("driver_assigned");
	    
	    AddTransport ob= new AddTransport(consignor_name, consignor_mobile, consignee_name, consignee_mobile, consignee_address, driver_assigned, 0);
		
	    int status=Transport_dao.addtransport(ob);
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
