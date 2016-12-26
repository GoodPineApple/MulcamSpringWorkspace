package test02_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDao {
	// DB 관련 문자열 상수 선언
	public static final String DRIVER_NAME = 
					"com.mysql.jdbc.Driver";
	public static final String DB_URL = 
					"jdbc:mysql://127.0.0.1:3306/spring";
	public static final String DB_ID = "root";
	public static final String DB_PW = "sds902";
////////////////////////////////////////////////////////	
	private Connection con;

	// 드라이버 jar 파일 로딩은 생성자에서 1번만 실행.
	public ProductDao(){
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////	
	public void startTransaction(){
		try {
			con = DriverManager.getConnection
					(DB_URL,DB_ID,DB_PW);// 커넥션 생성
			con.setAutoCommit(false); // 트랜잭션 시작
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
	}
	public void commitTransaction(){
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("커밋 오류");
			e.printStackTrace();
		}
	}
	public void rollbackTransaction(){
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("롤백 오류");
			e.printStackTrace();
		}
	}
	public void closeConnection(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("커넥션 종료 오류");
				e.printStackTrace();
			}
		}
	}
////////////////////////////////////////////////////////
	public int updateProductQuantity
					(int productNum, int quantity){
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update product set "
				+ "quantity=quantity-? where product_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, productNum);
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("updateProductQuantity 에러");
			e.printStackTrace();
		} finally {
			try {	pstmt.close();	} 
			catch (SQLException e) {	}
		}
		return result;
	}

	public int insertSaleRecord
					(int productNum,Date saleDate,
							String buyer,int saleCount)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into sale" + 
			"(product_num,sale_date,buyer,sale_count)" + 
			"values(?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(saleDate);
			
			pstmt.setInt(1, productNum); // 상품 번호
			pstmt.setString(2, currentTime);
			pstmt.setString(3, buyer); // 구매자
			pstmt.setInt(4, saleCount); // 판매수량 
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertSaleRecord 에러");
			e.printStackTrace();
		}
		return result;
	}
}





