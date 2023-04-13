package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddDriver;
import com.bo.AddTransport;
import com.dao.Transport_dao;

/**
 * Servlet implementation class ViewTransportcontroller
 */
@WebServlet("/ViewTransportcontroller")
public class ViewTransportcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTransportcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		out.print("<h2 style=\"color:red; display:inline-block;\">Transport Details</h2>");
		out.print("<link rel=\"stylesheet\" href=\"ViewDriver.css\">");
		List <AddTransport>list=Transport_dao.ViewTransportdetails();
		out.print("<table border='1px solid black'; width='100%'>");
		out.print("<tr> <th> ID </th> <th> CONSIGNOR_NAME </th> <th> CONSIGNOR_MOBILE </th> <th> CONSIGNEE_NAME </th>"
				+ "<th> CONSIGNEE_MOBILE </th> <th> CONSIGNEE_ADDRESS </th><th> DRIVER_ASSIGNED </th> <th> EDIT </th> <th> DELETE </th> </tr>");
		for(AddTransport ad:list)
			
			
			out.print("<tr><td>"+ad.getId()+"</td><td>"+ad.getConsignor_name()+"</td><td>"
					+ad.getConsignor_mobile()+"</td><td>"+ad.getConsignee_name()
					+"</td><td>"+ad.getConsignee_mobile()+"</td><td>"+ad.getConsignee_address()+
					"</td><td>"+ad.getDriver_assigned()+"</td>"
					+"<td><a href='EditServlettr?id="+ad.getId()+"'> <i class='far fa-edit'></i> </a> </td>"
					+ "<td><a href='DeleteServlettr?id="+ad.getId()+"'><i class='fas fa-trash'></i></a></td> </tr>");
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
