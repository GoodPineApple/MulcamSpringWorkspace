package bankAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import bankAccount.vo.AccountVO;

@Component
public class AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AccountMapper mapper = new AccountMapper();
	
	public AccountDao(){}
	
	public AccountDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(AccountVO account){
		String sql = "insert into account(name, account_num, create_date, balance, password)"+
					" values(?,?,now(),?,?)";
		return jdbcTemplate.update(sql, account.getName(), account.getAccountNum(), account.getBalance(), account.getPassword());
	}
	
	public AccountVO select(String accountNum){
		String sql = "select * from account where account_num=?";
		return jdbcTemplate.queryForObject(sql, mapper, accountNum);
	}
	
	public AccountVO selectbyRecentDate(){
		String sql = "select * from account order by create_date desc limit 0,1";
		return jdbcTemplate.queryForObject(sql, mapper);
	}
	
	public int increaseBalanceUpdate(String accountNum, int deposit){
		String sql = "update account set balance = balance+? where account_num=?";
		return jdbcTemplate.update(sql, deposit, accountNum);
	}
	
	public int decreaseBalanceUpdate(String accountNum, int withdraw) {
		String sql = "update account set balance = balance-? where account_num=?";
		return jdbcTemplate.update(sql, withdraw, accountNum);
	}
	
	
	
	
	
	class AccountMapper implements RowMapper<AccountVO>{

		@Override
		public AccountVO mapRow(ResultSet rs, int arg1) throws SQLException {
			AccountVO account = new AccountVO();
			account.setAccountNum(rs.getString("account_num"));
			account.setCreateDate(rs.getTimestamp("create_date"));
			account.setBalance(rs.getInt("balance"));
			account.setName(rs.getString("name"));
			account.setPassword(rs.getString("password"));
			return account;
		}
		
	}
	
}
