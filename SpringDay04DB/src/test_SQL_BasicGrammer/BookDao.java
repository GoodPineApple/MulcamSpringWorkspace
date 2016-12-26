package test_SQL_BasicGrammer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import test_SQL_BasicGrammer.vo.BookVO;


@Component("dao")
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private BookMapper mapper = new BookMapper();
	
	public BookDao(){}
	
	public BookDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(BookVO book){
		String sql = 
			"insert into book(title,writer,publisher,price)"+
			"values(?,?,?,?)";
		return jdbcTemplate.update(sql,
				book.getTitle(), 
				book.getWriter(),
				book.getPublisher(),
				book.getPrice()
				);
	}
	
	public int update(BookVO book){
		String sql = 
			"update book set title=?,writer=?,publisher=?,price=? "+
			"where book_num=?";
		return jdbcTemplate.update(sql,
				book.getTitle(), 
				book.getWriter(),
				book.getPublisher(),
				book.getPrice(),
				book.getBookNum()
				);
	}
	
	public int delete(int bookNum){
		String sql = 
			"delete from book where book_num=?";
		return jdbcTemplate.update(sql,
				bookNum
				);
	}
	
	public BookVO select(int bookNum){
		String sql = "select * from book where book_num=?";
		return jdbcTemplate.queryForObject(sql, mapper, bookNum);
	}
	
	public List<BookVO> selectAll(){
		String sql = "select * from book";
		return jdbcTemplate.query(sql, mapper);
	}
	
	public List<BookVO> selectByTitle(String title){
		String sql = "select * from book where title = ?";
		return jdbcTemplate.query(sql, mapper, title);
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







