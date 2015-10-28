package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectMSSqlServer {

	public static class ConnectMSSQLServer
	{
	   public void dbConnect(String db_connect_string,
	            String db_userid,
	            String db_password)
	   {
	      try {
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         //Connection conn = DriverManager.getConnection(db_connect_string,db_userid, db_password);
	         Connection conn = DriverManager.getConnection(db_connect_string);
	         System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String queryString = "select * from sysobjects where type='u'";
	         ResultSet rs = statement.executeQuery(queryString);
	         while (rs.next()) {
	            System.out.println(rs.getString(1));
	            System.out.println("Done!!");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	   public static void main(String[] args)
	   {
	      ConnectMSSQLServer connServer = new ConnectMSSQLServer();
	     // connServer.dbConnect("jdbc:sqlserver://<hostname>", "<user>","<password>");
	      connServer.dbConnect("jdbc:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage;integratedSecurity=true", "<user>","<password>");
	   }
	}
}
