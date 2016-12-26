package vo;

public class Book {
	private int book_num;
	private String title;
	private String writer;
	private int price;
	private String publisher;
	
	public Book(int book_num, String title, String writer, int price, String publisher) {
		super();
		this.book_num = book_num;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
	}

	public Book(){}
	
	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [book_num=" + book_num + ", title=" + title + ", writer=" + writer + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}
	
}
