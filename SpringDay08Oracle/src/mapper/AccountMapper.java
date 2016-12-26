package mapper;

import java.util.List;

import vo.Account;

public interface AccountMapper {
	public int insert(Account account);
//	public int update(Account account);
	public int delete(String AccountNum);
	public Account select(String accountNum);
	public List<Account> selectList();
}
