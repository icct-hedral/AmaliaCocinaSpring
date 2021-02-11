package com.empresa;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Configuration;


@Configuration
public class Conexion {
	
	Connection con;
	
	String url="jdbc:mysql://localhost:3306/bd_amaliacocina";
	String user="root";
	String pass="mysql";
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			
		}
		return con;
	}
}
