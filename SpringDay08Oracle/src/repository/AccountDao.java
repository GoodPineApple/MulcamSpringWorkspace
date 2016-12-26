package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.AccountMapper;
import vo.Account;

@Component
public class AccountDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSqlSessionTemplate(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insert(Account account){
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		return mapper.insert(account);
	}
	
	public List<Account> selectList(){
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		return mapper.selectList();
	}
}
