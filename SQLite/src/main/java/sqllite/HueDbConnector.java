package sqllite;

import java.sql.*;

import org.omg.PortableServer.RequestProcessingPolicyValue;
import org.sqlite.*;


public class HueDbConnector {
		public static void main(String args[]) {
		    Connection connection = null;  
		     ResultSet resultSet = null;  
		     Statement statement = null;  

		     try 
		     {  
		         Class.forName("org.sqlite.JDBC");  
		         connection = DriverManager.getConnection("jdbc:sqlite:D:\\Alexey_Rudakov\\SharedFolder\\desktop.db"); 
		         DatabaseMetaData md = connection.getMetaData();
		         ResultSet rs = md.getTables(null, null, null, 
		                 new String[] {"TABLE"});
		         ResultSet rs2 = md.getSchemas();
		                 
		        statement = connection.createStatement();  
		        resultSet = statement  
		                .executeQuery("SELECT * FROM oozie_workflow;");  
		        while (rs.next()) 
		         {  
		            System.out.println(
		                    "   "+rs.getString("TABLE_CAT") 
		                   + ", "+rs.getString("TABLE_SCHEM")
		                   + ", "+rs.getString("TABLE_NAME")
		                   + ", "+rs.getString("TABLE_TYPE")
		                   + ", "+rs.getString("REMARKS"));  
		         } 
		        System.out.println("KUKU");
		        for (int i=0; i< resultSet.getMetaData().getColumnCount(); i++)
		        	System.out.println(resultSet.getMetaData().getColumnLabel(i+1));
		        while (resultSet.next()) 
		         {  
		        	
		            System.out.println(resultSet.getString(1));
		            System.out.println(resultSet.getString(2));
		            System.out.println(resultSet.getString(3));
		            System.out.println(resultSet.getString(4));
		            System.out.println(resultSet.getString(5));
		            System.out.println(resultSet.getString(6));
		            System.out.println(resultSet.getString(7));
		            System.out.println(resultSet.getString(8));
		            System.out.println(resultSet.getString(9));
		     
		            System.out.println("=====================");
		             
		         }
		        
		     } 
		     catch (Exception e) 
		     {  
		         e.printStackTrace();  
		     }
		     finally 
		     {  
		         try 
		         {  
		             resultSet.close();  
		             statement.close();  
		             connection.close();  
		         } 
		         catch (Exception e) 
		         {  
		             e.printStackTrace();  
		         }  
		     }  
		 }  
		}

