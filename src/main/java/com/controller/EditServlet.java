package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddDriver;
import com.dao.Transport_dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		out.print("<link rel=\"stylesheet\" href=\"edit.css\">");
		out.print( " <img src=\"AvtLogin.png\" class=\"avtar\">");
		int id=Integer.parseInt(request.getParameter("id"));
		
		AddDriver ad =Transport_dao.getInfoID(id);
		
		out.print("<form  action='updatecontroller' method='get'> ");
		
		out.print(" <div class='cs'> <table>");
		out.print(" <h1>Enter Update</h1>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ad.getId()+"'/></td></tr>");  
		out.print("<tr><td><p>Name</p><br></td> <td><input type='text' name='name' value='"+ad.getName()+"'/></td></tr>");
	   	out.print("<tr><td><p>Mobile</p><br></td> <td><input type='text' name='mobile' value='"+ad.getMobile()+"'/></td></tr>");
	   	out.print("<tr><td><p>Vechile</p> <br><td><input type='text' name='vechile' value='"+ad.getVechile()+"'/></td></tr>");
	   	out.print("<tr><td><p>Address</p><br></td> <td><input type='text' name='address' value='"+ad.getAddress()+"'/></td></tr>");
	   	out.print("<tr><td><p>License</p><br><br> </td> <td><input type='text' name='lic' value='"+ad.getLic()+"'/></td></tr>");
	   	
	    out.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	out.print("</table> </div>");
		
		out.print("</form>");
		}

}
