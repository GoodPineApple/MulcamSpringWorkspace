package prt1_2;

public class Controller {
	private DAO dao;
	
	public Controller(){
		dao = new OracleDAO();
	}
	
	public void select(){
		System.out.println("현재 사용중인 DB:"+dao.select());
	}
}
