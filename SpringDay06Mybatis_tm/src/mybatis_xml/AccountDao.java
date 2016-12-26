package mybatis_xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Account;

public class AccountDao {
	private SqlSessionFactory factory;
	
	public AccountDao (){
		String resource = "mybatis_xml/conf.xml";
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			System.out.println("마이바티스 설정파일 에러");
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				System.out.println("is 종료 오류");
				e.printStackTrace();
			}
		}
	}
	
	public int insert(Account account){
		SqlSession session = factory.openSession(true);
		return session.insert("ktm.insertAccount", account);
	}
	
	public int update(Account account){
		SqlSession session = factory.openSession(true);
		return session.update("ktm.updateAccount", account);
	}
	
	public int delete(String account_num){
		SqlSession session = factory.openSession(true);
		return session.delete("ktm.deleteAccount", account_num);
	}
	
	public Account select(String account_num){
		SqlSession session = factory.openSession();
		return session.selectOne("ktm.selectAccount", account_num);
	}
	
	public List<Account> selectList(){
		SqlSession session = factory.openSession();
		return session.selectList("ktm.selectAccountList");
	}
}
