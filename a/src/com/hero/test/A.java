package com.hero.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class A
 */

public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	/**
	 * Default constructor.
	 */
	public A() throws Exception {

		System.out.println("********" + "inConstructor" + "");
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");
	}

protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession hsession = request.getSession(true);
		try {

			Connection con = ds.getConnection();

			EmpInfoClass eclass = new EmpInfoClass();

			List dogetList = eclass.getArrayList(con);

			hsession.setAttribute("empList", dogetList);
			
			//request.setAttribute("hero", "balayya");
					
			hsession.setAttribute("hero", "subbu");
			
			System.out.println("(((((((((((((((((" + "session added");

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("usercount  :"
				+ request.getServletContext().getAttribute("count"));
		out.println("currentrcount  :"
				+ request.getServletContext().getAttribute("curentCount"));

		out.println(hsession);

		System.out.println("***********" + request.getSession().getId()
				+ "***************");

		System.out
				.println("***********" + hsession.isNew() + "***************");

		System.out.println("***********" + "A request object reference"
				+ request + "***************");

		System.out.println("***********" + request.getContextPath()
				+ "***************");

		System.out.println("***********" + "before request dispatcher"
				+ "***************");

		request.getRequestDispatcher("viewFile.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
