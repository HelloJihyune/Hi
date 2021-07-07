package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {	// 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// JDBC
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/studydb?useSSL=false",
				"study",
				"study")) {
			log.info(conn);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
