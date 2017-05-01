package com.shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class DBUitl {
	private static Vector<Connection> connPool = new Vector<Connection>();
	static{
		try {
			for(int i = 0;i<10;i++){
					Class.forName("com.mysql.jdbc.driver");
					Connection connection = DriverManager.getConnection("jdb:mysql://127.0.0.1:3306/shop", "root", "admin");
					connPool.add(connection);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection connection = connPool.get(0);
		connPool.remove(0);
		return connection;
	}
	
	public void reConnection(Connection connection){
		connPool.add(connection);
	}
	
	
	public <T>List<T> findAll(String sql) throws SQLException{
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet result = prepareStatement.executeQuery();
		return null;
	}
	
}
