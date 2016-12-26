package bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bankAccount.vo.AccountVO;

@Component("service")
public class AccountService {
	@Autowired
	private AccountDao dao;
	
	public AccountService(){}
	
	public AccountService(AccountDao dao){
		this.dao = dao;
	}
	
	public int createAccount(String name, int deposit, String password){
		AccountVO account = new AccountVO();
		account.setName(name);
		account.setBalance(deposit);
		account.setPassword(password);
		String accountNum = "9301-21-";
//		boolean isDuplicated = true;
		
		for(int i=0; i<1; i++){
			accountNum = "9301-21-";
			int randomNum = (int)(Math.random()*1000);
			if(randomNum<10){
				accountNum += "000" + randomNum;
			} else if(randomNum<100){
				accountNum += "00" + randomNum;
			} else if(randomNum<1000){
				accountNum += "0" + randomNum;
			}
			AccountVO check = new AccountVO();
			try{
				check = dao.select(accountNum);
				i--;
			} catch(Exception e) {
			}
		}
		account.setAccountNum(accountNum);
		System.out.println("»ý¼º °èÁÂ:"+accountNum);
		return dao.insert(account);
	}
	
	public AccountVO firstCreate(){
		AccountVO account = dao.selectbyRecentDate();
		return account;
	}
	
	public int increaseBalance(String accountNum, int deposit){
		return dao.increaseBalanceUpdate(accountNum, deposit);
	}
	
	public int withdraw(String accountNum, int withdraw) {
		return dao.decreaseBalanceUpdate(accountNum, withdraw);
	}
	
	public AccountVO select(String accountNum){
		return dao.select(accountNum);
	}
	
	public boolean checkPassword(String accountNum, String password){
		AccountVO account = dao.select(accountNum);
		if(account.getPassword().equals(password)){
			return true;
		} else {
			return false;
		}
	}
	
	public int remitt(String accountNum, String remittAccountNum, int remitt){
		AccountVO account = dao.select(accountNum);
		try {
			AccountVO remittAccount = dao.select(remittAccountNum);
			dao.decreaseBalanceUpdate(accountNum, remitt);
			dao.increaseBalanceUpdate(remittAccountNum, remitt);
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}
}
