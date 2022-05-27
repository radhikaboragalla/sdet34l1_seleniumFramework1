package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest {
	public static void main(String[] args) throws SQLException
	{
		Connection connection=null;
		//create
		Driver driver=new Driver();
		//Register
		DriverManager.registerDriver(driver);
		//establish
	   connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34","root","root");
      //create stmt
		 Statement statement=connection.createStatement();
		 //execute query
		ResultSet result=statement.executeQuery("Select * from sdet34l1;");
		
	}
	

}
