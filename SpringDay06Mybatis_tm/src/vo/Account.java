package vo;

import java.sql.Timestamp;

public class Account {
	private String name;
	private String account_num;
	private Timestamp create_date;
	private int balance;
	private String password;
	
	public Account(){}
	
	public Account(String name, String account_num, Timestamp create_date, int balance, String password) {
		super();
		this.name = name;
		this.account_num = account_num;
		this.create_date = create_date;
		this.balance = balance;
		this.password = password;
	}

	public Account(String name, String account_num, int balance, String password) {
		super();
		this.name = name;
		this.account_num = account_num;
		this.balance = balance;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
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
		return "Account [name=" + name + ", account_num=" + account_num + ", create_date=" + create_date + ", balance="
				+ balance + ", password=" + password + "]";
	}
	
}
