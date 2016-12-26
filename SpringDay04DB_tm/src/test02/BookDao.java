package test02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import test02.vo.BookVO;

@Component("bookDao")
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BookDao(){}
	
	public BookDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(BookVO book){
		String sql = "insert into book(title, writer, price, publisher) values(?,?,?,?)";
		return jdbcTemplate.update(sql, book.getTitle(), book.getWriter(), book.getPrice(), book.getPublisher());
	}
}
