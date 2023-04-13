package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddTransport;
import com.dao.Transport_dao;

/**
 * Servlet implementation class EditServlettr
 */
@WebServlet("/EditServlettr")
public class EditServlettr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlettr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		out.print("<link rel=\"stylesheet\" href=\"edittr.css\">");
		out.print( " <img src=\"AvtLogin.png\" class=\"avtar\">");
		int id=Integer.parseInt(request.getParameter("id"));
		
		AddTransport ad=Transport_dao.getTRInfoID(id);
		
out.print("<form  action='updatecontrollertr' method='get'> ");
		
		out.print(" <div class='cs'> <table>");
		out.print(" <h1>Enter Update</h1>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ad.getId()+"'/></td></tr>");  
		out.print("<tr><td><p>Consignor_Name</p><br></td> <td><input type='text' name='Consignor_Name' value='"+ad.getConsignor_name()+"'/></td></tr>");
	   	out.print("<tr><td><p>Consignor_Mobile</p><br></td> <td><input type='text' name='Consignor_Mobile' value='"+ad.getConsignor_mobile()+"'/></td></tr>");
	   	out.print("<tr><td><p>Consignee_Name</p> <br><td><input type='text' name='Consignee_Name' value='"+ad.getConsignee_name()+"'/></td></tr>");
	   	out.print("<tr><td><p>Consignee_Mobile</p><br></td> <td><input type='text' name='Consignee_Mobile' value='"+ad.getConsignor_mobile()+"'/></td></tr>");
	   	out.print("<tr><td><p>Consignee_Address</p><br><br> </td> <td><input type='text' name='Consignee_Address' value='"+ad.getConsignee_address()+"'/></td></tr>");
	   	out.print("<tr><td><p>Driver_Assigned</p><br><br> </td> <td><input type='text' name='Driver_Assigned' value='"+ad.getDriver_assigned()+"'/></td></tr>");
	   	
	    out.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	out.print("</table> </div>");
		
		out.print("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
