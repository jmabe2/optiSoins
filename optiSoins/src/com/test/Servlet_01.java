package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Servlet_01
 */
@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger =null;
	public void init () {
		logger=logger.getRootLogger();
		BasicConfigurator.configure();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.setLevel(Level.ERROR);
		logger.debug("logging debug message");
		logger.info("logging info message");
		logger.warn("logging warning message");
		logger.error("logging error message");
		logger.fatal("logging fatal message");
		
		response.setContentType("text/html");
		PrintWriter printwritter =response.getWriter();
		printwritter.println("<html>");
		printwritter.println("<head> Test log4j </head>");
		printwritter.println("<body>");
		printwritter.println("Logger name : "+ logger.getName());
		printwritter.println("</body>");
		printwritter.println("/<html>");

	}

}
