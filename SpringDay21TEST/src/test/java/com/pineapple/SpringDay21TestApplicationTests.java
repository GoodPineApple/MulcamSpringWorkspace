package com.pineapple;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pineapple.repository.ArticleMapper;
import com.pineapple.repository.MemberMapper;
import com.pineapple.vo.ArticleVO;
import com.pineapple.vo.MemberVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDay21TestApplicationTests {
	
	 @Autowired
//	 private MemberMapper mapper;
	 private ArticleMapper amapper;
	 
	 @Test
	 public void contextLoads() {
	 }
	    
	 @Test
	 public void testSqlSession() throws Exception{//¿€º∫
		 
//		 MemberVO member = new MemberVO("test", "1234", "test@test", "1234-1234");
//		 
//		 mapper.memberInsert(member);
	        
//		 MemberVO member1 = mapper.memberSelect(3);
//		 
//		 System.out.println("testtesteTTTTTTTTTTTTTTTT:"+member1);
		 
		 ArticleVO article1 = new ArticleVO("testTitle", "test", "testcontent");
		 System.out.println(amapper.articleInsert(article1));
		 
//		 System.out.println("test");
//		 ArticleVO article = amapper.articleSelect(4);
//		 System.out.println(article);
	 }
}
