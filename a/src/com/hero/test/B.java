package com.hero.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class B
 */
@WebServlet("/B")
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().getServletContext().getAttribute("currentCount");
		request.getSession().getServletContext().getAttribute("userccount");
		
	PrintWriter out =  response.getWriter();
		
	response.setContentType("text/html");

		System.out.println(" in B servlet");
		
		System.out.println("***********"+"B request object reference"+ request+"***************");
		
		

		HttpSession hss = request.getSession();

		List ls = (List) hss.getAttribute("emp");

		System.out.println(hss);

		System.out.println(request.getSession(true).isNew());

		int count= 0 ;
		
		for (Object a : ls) {

			EmployeeBean eb = (EmployeeBean)a ;
			
		    out.println(eb.getEmpid());
			
		    count++;
		}
		
		Object c =request.getAttribute("param") ;
		
	     out.println("currentCount  :"+ request.getSession().getServletContext().getAttribute("currentCount"));
	     out.println("userCount  :"+ request.getSession().getServletContext().getAttribute("userccount"));
		

      out.println(c)		;
      
      System.out.println("??????????????"+request.getSession(false));		

	
		
		   out.println("*****"+count+"*******");
	}

	/**
	 * }
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
