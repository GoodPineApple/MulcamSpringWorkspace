package xml_interface;

import vo.Book;

public class Test {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		
		Book book = new Book
				("Mybatis", "����", "�ֹ���", 25000);
		
		System.out.println("result : "+dao.insert(book));
		System.out.println("å��ȣ:"+book.getB_book_num());
	}
}
