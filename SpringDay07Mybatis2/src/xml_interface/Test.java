package xml_interface;

import vo.Book;

public class Test {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		
		Book book = new Book
				("Mybatis", "가메", "최범균", 25000);
		
		System.out.println("result : "+dao.insert(book));
		System.out.println("책번호:"+book.getB_book_num());
	}
}
