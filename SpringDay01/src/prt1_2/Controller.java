package prt1_2;

public class Controller {
	private DAO dao;
	
	public Controller(){
		dao = new OracleDAO();
	}
	
	public void select(){
		System.out.println("���� ������� DB:"+dao.select());
	}
}
