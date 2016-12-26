package prt4_1;

public class Controller {
	private DAO dao;
	
	public Controller(DAO dao) {
		this.dao = dao;
	}
	
	public void select() {
		System.out.println("현재사용중인DB"+dao.select());
	}
}
