package com.pu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{  		
		String rno=request.getParameter("rollno");  
		int rn=Integer.valueOf(rno);  
		          
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=latin1","root","root");  
		              
		PreparedStatement st=con.prepareStatement("update mark set name=?,section=?,s1=?,s2=?,s3=?,s4=?,s5=?,s6=?,l1=?,l2=?  where rollno=?");  
				
		st.setString(1, request.getParameter("name"));
		st.setString(2, request.getParameter("section"));
		st.setInt(3, Integer.valueOf(request.getParameter("sub1")));
		st.setInt(4, Integer.valueOf(request.getParameter("sub2")));
		st.setInt(5, Integer.valueOf(request.getParameter("sub3")));
		st.setInt(6, Integer.valueOf(request.getParameter("sub4")));
		st.setInt(7, Integer.valueOf(request.getParameter("sub5")));
		st.setInt(8, Integer.valueOf(request.getParameter("sub6")));
		st.setInt(9, Integer.valueOf(request.getParameter("lab1")));
		st.setInt(10, Integer.valueOf(request.getParameter("lab2")));
		st.setInt(11, Integer.valueOf(request.getParameter("rollno")));
		st.executeUpdate();
		  
		
        out.println("<html><body><b>Successfully Updated"
                        + "</b></body></html>");
        st.close();
		con.close();
	}catch(Exception e){ System.out.println(e);}
	
        
		finally{out.close();}  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}