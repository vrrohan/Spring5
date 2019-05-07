package com.ron.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestMySqlDatabase
 */
@WebServlet("/testDB")
public class TestMySqlDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TestMySqlDatabase() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String USERNAME = "root";
		final String PASSWORD = "root";
		final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
		final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

		// load JDBC driver class
		try {
			Class.forName(JDBC_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter writer = response.getWriter();

		// connect to database
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			writer.println("Connecting to database... " + JDBC_URL);
			writer.println("SUCCESS");
		} catch (Exception exception) {
			exception.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
