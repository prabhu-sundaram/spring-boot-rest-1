package com.prabhu.ucp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import oracle.ucp.jdbc.PoolDataSource;

public class UCPConnectionExample {
   public static void main(String args[]) throws SQLException {
      try 
      {
         //Create pool-enabled data source instance.
         
         PoolDataSource  pds = PoolDataSourceFactory.getPoolDataSource();
         
         //set the connection properties on the data source.
         
         pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
         pds.setURL("jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D");
         pds.setUser("MONTAJI_DEV");
         pds.setPassword("MONTAJI_DEV");     
         
         //Override any pool properties.
         
         pds.setInitialPoolSize(5);
         
         //Get a database connection from the datasource.
         
         Connection conn = pds.getConnection();
         
         System.out.println("\nConnection obtained from " +
          "UniversalConnectionPool\n");
         
         //do some work with the connection.
         Statement stmt = conn.createStatement();
         stmt.execute("select * from EMPLOYEE3");
         
         //Close the Connection.
         
         conn.close();
         conn=null;
         
         System.out.println("Connection returned to the " +
          "UniversalConnectionPool\n");
         
      }
      catch(SQLException e)
      {
         System.out.println("BasicConnectionExample - " +
          "main()-SQLException occurred : "
              + e.getMessage());
      }
   }
}