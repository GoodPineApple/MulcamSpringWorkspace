package bankAccount.vo;

import java.sql.Timestamp;

public class TransactVO {
	private int transactNum;
	private String accountNum;
	private int deposit;
	private int withdraw;
	private Timestamp date;
	
	public TransactVO(int transactNum, String accountNum, int deposit, int withdraw, Timestamp date) {
		super();
		this.transactNum = transactNum;
		this.accountNum = accountNum;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.date = date;
	}

	public TransactVO(String accountNum, int deposit, int withdraw, Timestamp date) {
		super();
		this.accountNum = accountNum;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.date = date;
	}

	public TransactVO() {
		super();
	}

	public int getTransactNum() {
		return transactNum;
	}

	public void setTransactNum(int transactNum) {
		this.transactNum = transactNum;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TransactVO [transactNum=" + transactNum + ", accountNum=" + accountNum + ", deposit=" + deposit
				+ ", withdraw=" + withdraw + ", date=" + date + "]";
	}
	
}
