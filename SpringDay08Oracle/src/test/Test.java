package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.AccountDao;
import vo.Account;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		Account account = new Account("ลยนฮ", "9301-21-0845", 100000, "1234");
		
//		System.out.println(dao.insert(account));
		
		List<Account> accountList = dao.selectList();
		for(Account a : accountList){
			System.out.println(a);
		}
	}
}
