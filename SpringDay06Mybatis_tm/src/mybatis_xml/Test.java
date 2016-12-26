package mybatis_xml;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vo.Account;

public class Test {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Account account = new Account("pineapple", "1111-1111", 1000, "1234567889");
//		Account accountForUpdate = new Account("pineapple", "1111-1111", timestamp, 1000, "1234");
		
		String num = "1111-1111";
//		System.out.println(dao.insert(account));
		
//		System.out.println(dao.selectList());
		
//		System.out.println(dao.select(num));
		
		System.out.println(dao.update(account));
	}
}
