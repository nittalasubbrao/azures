package com.hero.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpInfoClass {

   public  List<EmployeeBean> ls;
   
   public String s = "select employee_id,first_name,salary from hr.employees";

	public  List<EmployeeBean> getArrayList(Connection con) throws Exception {
		
		ls= new ArrayList<EmployeeBean>();

	
	Statement pstmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs =pstmt.executeQuery(s);
		
		  while (rs.next()){
			  
			  EmployeeBean eb = new EmployeeBean();
			  eb.setEmpid(rs.getInt(1));
			  eb.setEname(rs.getString(2));
			  eb.setEsal(rs.getInt(3));
			
			  ls.add(eb);
			  
			  
		  }
		
		
		return ls ;
		
		
		
	}

	

}
