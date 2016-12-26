package prt1;

public class Controller {
	private SqlDAO sqlDAO;
	
	public Controller(){
		sqlDAO = new SqlDAO();
	}
	
	public void select(){
		String result = sqlDAO.selectFromSQL();
		System.out.println("현재 사용중인 DB:"+result); 
	}
}
