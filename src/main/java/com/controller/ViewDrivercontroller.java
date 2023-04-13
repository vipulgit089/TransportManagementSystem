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
import com.dao.Transport_dao;

/**
 * Servlet implementation class ViewDrivercontroller
 */
@WebServlet("/ViewDrivercontroller")
public class ViewDrivercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDrivercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		out.print("<h2 style=\"color:red; display:inline-block;\">Driver Details</h2>");
		out.print("<link rel=\"stylesheet\" href=\"ViewDriver.css\">");
		List <AddDriver>list=Transport_dao.ViewDriverdetails();
		
		
		
		out.print("<table border='1px solid black'; width='100%'>");
		
		out.print("<tr> <th> ID </th> <th> NAME </th> <th> MOBILE </th> <th> VECHILE </th>"
				+ "<th> ADDRESS </th> <th> LICENSE </th> <th> EDIT </th> <th> DELETE </th> </tr>");
		
		for(AddDriver ad:list)
			out.print("<tr><td>"+ad.getId()+"</td> <td>"+ad.getName()+"</td> <td>"+ad.getMobile()+"</td> "
					+ "<td>"+ad.getVechile()+"</td><td>"+ad.getAddress()+"</td> <td>"+ad.getLic()+"</td>"
							+ "<td><a href='EditServlet?id="+ad.getId()+"'> <i class='far fa-edit'></i> </a> </td>"
							+ "<td><a href='DeleteServlet?id="+ad.getId()+"'><i class='fas fa-trash'></i></a></td> </tr>");
		
		out.print("</table>");
		
	}

}
