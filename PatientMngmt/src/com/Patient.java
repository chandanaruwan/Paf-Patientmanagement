package com;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class Patient {

	public Connection connect() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitalmanagement","root", "");
			// For testing
			System.out.println("Successfully connected---1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// inserting an items .........................

	public String insertItem(String pName, String pAddress, String pAge, String pNIC,String pWeakness) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}
			// create a prepared statement
			String query = "insert into patient" + "(`pID`,`pName`,`pAddress`,`pAge`,`pNIC`,`pWeakness`)"
					+ " values (?, ?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, pName);
			preparedStmt.setString(3, pAddress);
			preparedStmt.setInt(4, Integer.parseInt(pAge));
			preparedStmt.setString(5, pNIC);
			preparedStmt.setString(6, pWeakness);


			// execute the statement
			preparedStmt.execute();
//		 System.out.print("successfuly inserted");
			con.close();
			
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Inserted successfully";
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

	// read the items from database and display----------------------

	public String readItems()
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{
	return "Error while connecting to the database for reading.";
	}
	// Prepare the html table to be displayed
	output = "<table border='1'><tr><th>Name</th>"
			+ "<th>Address</th><th>Age</th>"
			+"<th>NIC</th>"
			+"<th>Weakness</th>"
			+ "<th>Update</th><th>Remove</th></tr>";
	String query = "select * from patient";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String pID = Integer.toString(rs.getInt("pID"));
	String pName = rs.getString("pName");
	String pAddress = rs.getString("pAddress");
	String pAge = Integer.toString(rs.getInt("pAge"));
	String pNIC = rs.getString("pNIC");
	String pWeakness = rs.getString("pWeakness");
	
	
	// Add into the html table
	output += "<tr><td><input id='hidItemIDUpdate'"
			+ "name='hidItemIDUpdate' type='hidden'"
			+ "value='" + pID + "'>" + pName + "</td>";
	output += "<td>" + pAddress + "</td>";
	output += "<td>" + pAge + "</td>";
	output += "<td>" + pNIC + "</td>";
	output += "<td>" + pWeakness + "</td>";
	// buttons
	output += "<td><input name='btnUpdate' type='button'"
			+ "value='Update'"
			+ "class='btnUpdate btn btn-secondary'></td>"
			+ "<td><input name='btnRemove' type='button'"
			+ "value='Remove'"
			+ "class='btnRemove btn btn-danger' data-pid='"
	+ pID + "'>" + "</td></tr>";
	}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the items.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	
	
	
	
	// update items ---------------------------------------------

	public String updateItem(String pID, String pName, String pAddress, String pAge, String pNIC,String pWeakness) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE patient SET pName=?,pAddress=?,pAge=?,pNIC=?,pWeakness=?WHERE pID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, pName);
			preparedStmt.setString(2, pAddress);
			preparedStmt.setInt(3, Integer.parseInt(pAge));
			preparedStmt.setString(4, pNIC);
			preparedStmt.setString(5, pWeakness);
 			preparedStmt.setInt(6, Integer.parseInt(pID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Updated successfully";
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

	// delete items--------------------------------------

	public String deleteItem(String pID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from patient where pID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(pID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Deleted successfully";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

}
