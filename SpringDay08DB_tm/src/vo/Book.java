package vo;

public class Book {
	private int bookNum;
	private String title;
	private String writer;
	private int price;
	private String publisher;
	
	public Book() {
		super();
	}

	public Book(String title, String writer, int price, String publisher) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
	}

	public Book(int bookNum, String title, String writer, int price, String publisher) {
		super();
		this.bookNum = bookNum;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
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
		return "Book [bookNum=" + bookNum + ", title=" + title + ", writer=" + writer + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}
}
