package test01_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
	// * JDBC 작업 매뉴얼
	// 1. 드라이버 로딩
	// 2. 커넥션 생성
	// 3. SQL 작성
	// 4. PreparedStatement 생성
	// 5. 쿼리 실행
	// 6. 결과값 핸들링
	// 7. 자원반납
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user01","sds902");
			System.out.println("test");
//			Class.forName("com.mysql.jdbc.Driver");
//
//			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring", "root", "sds902");
			con.setAutoCommit(false); // 트랜잭션 시작
			
			sql = "update product set quantity=quantity-1 " + "where product_num=2";

			pstmt1 = con.prepareStatement(sql);
			int result = pstmt1.executeUpdate();

			System.out.println("수량 감소결과:" + result);

			if(new Random().nextBoolean()){
				throw new SQLException("프로그램 중단됨!!");
			}
			
			sql = "insert into sale" + "(product_num,sale_date,buyer,sale_count)" + "values(?,?,?,?)";
			pstmt2 = con.prepareStatement(sql);

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(now);

			pstmt2.setInt(1, 2); // 2번 상품 판매함
			pstmt2.setString(2, currentTime);
			pstmt2.setString(3, "Yangyu"); // 구매자
			pstmt2.setInt(4, 1); // 판매수량 1

			result = pstmt2.executeUpdate();
			con.commit(); // 트랜잭션 완료 커밋
			System.out.println("판매정보 기록 결과:" + result);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
//			con.rollback(); // 진행된 쿼리 취소시키기
			System.out.println("SQL 예외 발생");
		}

	}
}
