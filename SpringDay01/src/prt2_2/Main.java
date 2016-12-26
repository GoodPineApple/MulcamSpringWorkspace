package prt2_2;

public class Main {
	public static void main(String[] args) {
		Controller con = new Controller();
		DAO dao = new OracleDAO();
		con.setDAO(dao);
		con.select();
	}
}
