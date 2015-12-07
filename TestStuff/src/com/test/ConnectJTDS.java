package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.ConnectMSSqlServer.ConnectMSSQLServer;

public class ConnectJTDS {

	public static class ConnectMSSQLServer
	{
	   public void dbConnect(String db_connect_string,
	            String db_userid,
	            String db_password)
	   {
	      try {
	         Class.forName("net.sourceforge.jtds.jdbc.Driver");
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
	      //connServer.dbConnect("jdbc:sqlserver://<hostname>", "<user>","<password>");
	      //connServer.dbConnect("jdbc:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage;integratedSecurity=true", "<user>","<password>");
	      //connServer.dbConnect("jdbc:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage", "\\ANLDGMT/rahul.kulkarni","3R!dhika))001");
	      //connServer.dbConnect("jdbc:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage", "\\ANLDGMT/rahul.kulkarni","4R!dhika))001");
	      //connServer.dbConnect("jdbc:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage;authenticationScheme=JavaKerberos;", "\\ANLDGMT/rahul.kulkarni","R!dhika))001");
	      //connServer.dbConnect("jdbc:jtds:sqlserver://hsk-sql-w03c-p\\instance3;databaseName=IntegrationStage;integratedSecurity=true;authenticationScheme=JavaKerberos", "<user>","<password>");
	      connServer.dbConnect("jdbc:jtds:sqlserver://hsk-sql-w03c-p/instance3;databaseName=IntegrationStage;integratedSecurity=true", "<user>","<password>");
	   }
	}

}
