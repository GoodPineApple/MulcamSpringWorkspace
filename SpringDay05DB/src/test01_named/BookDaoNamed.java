package test01_named;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import test01_named.vo.BookVO;

public class BookDaoNamed {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private BookMapper mapper = new BookMapper();
	
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(BookVO book) {
		String sql = "insert into book(book_num,title,price,publisher,writer) "+
					"values(:bookNum,:title,:price,:publisher,:writer)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(book);
		return jdbcTemplate.update(sql, param);
	}
	
	public int delete(int bookNum){
		String sql = "delete from book where bookNum=:bn";
		Map<String,Integer> paramMap = new HashMap<>();
		paramMap.put("bn", bookNum);
		return jdbcTemplate.update(sql, paramMap);
	}
	
	
	
	public BookVO select(int bookNum){
		String sql = "select * from book where book_num=:bn";
		Map<String,Integer> paramMap = new HashMap<>();
		paramMap.put("bn", bookNum);
		return jdbcTemplate.queryForObject(sql, paramMap, mapper);
	}
	
	public List<BookVO> selectAll(){
		String sql = "select * from book";
		return jdbcTemplate.query(sql, mapper);
	}
	
	public List<BookVO> selectByTitle(String title){
		String sql = "select * from book where title = :title";
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("title", title);
		return jdbcTemplate.query(sql, paramMap, mapper);
	}
	
	//select 실행할 때 칼럼
	class BookMapper implements RowMapper<BookVO>{

		@Override
		public BookVO mapRow(ResultSet rs, int arg1) throws SQLException {
			BookVO book = new BookVO();
//			book.setBookNum(rs.getInt(1));
//			book.setTitle(rs.getString(2));
//			book.setWriter(rs.getString(3));
//			book.setPrice(rs.getInt(4));
//			book.setPublisher(rs.getString(5));
			
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setBookNum(rs.getInt("book_num"));
			book.setTitle(rs.getString("title"));
			book.setWriter(rs.getString("writer"));
			return book;
		}
		
	}
}
