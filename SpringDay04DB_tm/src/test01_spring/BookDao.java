package test01_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import test01_spring.vo.BookVO;

// 애노테이션 방식
@Component("dao")
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BookDao(){}
	
	public BookDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(BookVO book){
		String sql = "insert into book(title,writer,publisher,price)"+
					" values(?,?,?,?)";
		return jdbcTemplate.update
					(sql,book.getTitle(), book.getWriter(), 
							book.getPublisher(), book.getPrice());
		
	}
}
