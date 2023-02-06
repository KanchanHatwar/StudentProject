package com.softronic.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.softronic.helper.Constants;

public class ConnectionProvider {

	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName(Constants.MYSQL_DRIVER);
			connection=DriverManager.getConnection(Constants.MYSQL_URL,Constants.PASSWORD,Constants.USER);
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}
