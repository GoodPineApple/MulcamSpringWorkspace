package prt2_1;

public class Main {
	public static void main(String[] args) {
		OracleDAO dao = new OracleDAO();
		Controller con = new Controller(dao);
		con.select();
	}
}
