/*package com.java.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.java.exception.DatabaseException;


public class ConnectionUtil {
	
	
	private   BasicDataSource ds;
	
	public static Connection getConnection() throws DatabaseException {
		Connection connection=null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to connect to your database!"+ e.getMessage());
		}
		
		return connection;
	}
}
*/