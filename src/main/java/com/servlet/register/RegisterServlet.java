package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String city=req.getParameter("city");
		String mobile=req.getParameter("mobile");
		String dob=req.getParameter("dob");
		
		/*
		 * System.out.println(name); System.out.println(city);
		 * System.out.println(mobile); System.out.println(dob);
		 */
		
		
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","Nehasaini123");
		    String q1="insert into form(fname,city,mob,dob) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(q1);
			ps.setString(1, name);
			ps.setString(2,city);
			ps.setString(3, mobile);
			ps.setString(4, dob);
			System.out.println("data inserted...");
			ps.executeUpdate();
		}
			
         catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		
		
	}
	

}
	
	