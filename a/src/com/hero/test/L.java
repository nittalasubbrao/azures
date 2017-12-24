package com.hero.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L implements HttpSessionListener {
	
	ServletContext scontxt=null ;
	
	int count=0;
	
	int currentCount = 0 ;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

			count++ ;
 			
			currentCount ++ ;
			
			
			scontxt=arg0.getSession().getServletContext() ;
			
		    scontxt.setAttribute("usercount", count);
		    
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		currentCount -- ;
		
		  scontxt.setAttribute("currentCount", currentCount);
		
	}

}
