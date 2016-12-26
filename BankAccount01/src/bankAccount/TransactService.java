package bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bankAccount.vo.TransactVO;

@Component("transactService")
public class TransactService {
	
	@Autowired
	private TransactDao dao;
	
	public TransactService(TransactDao dao){
		this.dao = dao;
	}
	
	public TransactService(){}
	
	////////////////////////////////////////////////////////////////////
	
	public List<TransactVO> askDepositRecent(String accountNum){
		List<TransactVO> result = dao.selectBydepositRecent(accountNum);
		return result;
	}
	
	public List<TransactVO> askDepositAll(String accountNum){
		List<TransactVO> result = dao.selectBydepositAll(accountNum);
		return result;
	}
	
	public List<TransactVO> askWithdrawRecent(String accountNum){
		List<TransactVO> result = dao.selectBywithdrawRecent(accountNum);
		return result;
	}
	
	public List<TransactVO> askWithdrawAll(String accountNum){
		List<TransactVO> result = dao.selectBywithdrawAll(accountNum);
		return result;
	}

	//////////////////////////////////////////////////////////////////
	
	public void writeDepositRecord(String accountNum, int deposit){
		dao.insertWithDeposit(accountNum, deposit);
	}
	
	public void writeWithdrawRecord(String accountNum, int withdraw){
		dao.insertWithWithdraw(accountNum, withdraw);
	}
	
	
	
}
