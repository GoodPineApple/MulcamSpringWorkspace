package bankAccount.vo;

import java.sql.Timestamp;

public class AccountVO {
	private String name;
	private String accountNum;
	private Timestamp createDate;
	private int balance;
	private String password;
	
////////////////////////////////////////////////////////////////////////////////////////
	
	public AccountVO() {
		super();
	}

	public AccountVO(String name, String accountNum, Timestamp createDay, int balance) {
		super();
		this.name = name;
		this.accountNum = accountNum;
		this.createDate = createDay;
		this.balance = balance;
	}

	public AccountVO(String name, String accountNum, Timestamp createDate, int balance, String password) {
		super();
		this.name = name;
		this.accountNum = accountNum;
		this.createDate = createDate;
		this.balance = balance;
		this.password = password;
	}

/////////////////////////////////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountVO [name=" + name + ", accountNum=" + accountNum + ", createDate=" + createDate + ", balance="
				+ balance + ", password=" + password + "]";
	}

}
