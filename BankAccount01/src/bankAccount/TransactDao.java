package bankAccount;

import java.lang.annotation.Target;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import bankAccount.vo.TransactVO;

@Component
public class TransactDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private TransactMapper mapper = new TransactMapper();
	
	public TransactDao (JdbcTemplate jdbctemplate){
		this.jdbctemplate = jdbctemplate;
	}
	
	public TransactDao(){}
	
	public int insertWithDeposit(String account_num, int deposit){
		String sql = "insert into transact(account_num,deposit,withdraw,date) values(?,?,0,now())";
		return jdbctemplate.update(sql, account_num, deposit);
	}
	
	public int insertWithWithdraw(String account_num, int withdraw){
		String sql = "insert into transact(account_num,deposit,withdraw,date) values(?,0,?,now())";
		return jdbctemplate.update(sql, account_num, withdraw);
	}
	
	public TransactVO select(int transactNum){
		String sql = "select * from transact where transact_num=?";
		return jdbctemplate.queryForObject(sql, mapper, transactNum);
	}
	
	public List<TransactVO> selectBydepositRecent(String account_num){
		String sql = "select * from transact where account_num=? and deposit <>0 order by date desc limit 0,10";
		return jdbctemplate.query(sql, mapper, account_num);
	}
	
	public List<TransactVO> selectBywithdrawRecent(String account_num){
		String sql = "select * from transact where account_num=? and withdraw <>0 order by date desc limit 0,10";
		return jdbctemplate.query(sql, mapper, account_num);
	}
	
	public List<TransactVO> selectBydepositAll(String account_num){
		String sql = "select * from transact where account_num=? and deposit <>0 order by date desc";
		return jdbctemplate.query(sql, mapper, account_num);
	}
	
	public List<TransactVO> selectBywithdrawAll(String account_num){
		String sql = "select * from transact where account_num=? and withdraw <>0 order by date desc";
		return jdbctemplate.query(sql, mapper, account_num);
	}
	
	
	class TransactMapper implements RowMapper<TransactVO> {

		@Override
		public TransactVO mapRow(ResultSet rs, int arg1) throws SQLException {
			TransactVO transact = new TransactVO();
			transact.setAccountNum(rs.getString("account_num"));
			transact.setDate(rs.getTimestamp("date"));
			transact.setDeposit(rs.getInt("deposit"));
			transact.setTransactNum(rs.getInt("transact_num"));
			transact.setWithdraw(rs.getInt("withdraw"));
			return transact;
		}
		
	}
}
