package mybatis_xml;

import vo.Book;

public class Test {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		
//		for(Book b : dao.selectList()){
//			System.out.println(b);
//		}
		
		int a = 1;
		System.out.println(dao.select(a));
		
//		Book b = new Book();
//		b.setTitle("���̹�Ƽ��");
//		b.setPublisher("��ķ");
//		b.setWriter("ktm");
//		b.setPrice(5000);
		
//		System.out.println("insert ��� : " + dao.insert(b));
		
	}
}
