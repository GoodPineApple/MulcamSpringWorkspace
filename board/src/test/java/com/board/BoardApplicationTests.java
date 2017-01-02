package com.board;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration
@WebAppConfiguration
public class BoardApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void contextLoads() {
	}
	
	
	public void testConnection() throws SQLException{
		System.out.println("ds:"+ds);
		Connection con = ds.getConnection();
		System.out.println("con:"+con);
		con.close();
	}

}
