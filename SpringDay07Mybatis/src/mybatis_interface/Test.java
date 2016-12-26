package mybatis_interface;

import vo.Book;

public class Test {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		
		for(Book b: dao.selectList()){
			System.out.println(b);
		}
//		Book b = new Book();
//		b.setTitle("마이바티스");
//		b.setPublisher("멀티캠퍼스");
//		b.setWriter("양유진");
//		b.setPrice(50000);
//		
//		System.out.println("insert 결과:"+ dao.insert(b));
	}
}
