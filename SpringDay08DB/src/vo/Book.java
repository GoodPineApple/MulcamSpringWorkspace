package vo;

public class Book {
	private int b_book_num;
	private String b_title;
	private String b_publisher;
	private String b_writer;
	private int b_price;
	
	public Book(int b_book_num, String b_title, String b_publisher, String b_writer, int b_price) {
		super();
		this.b_book_num = b_book_num;
		this.b_title = b_title;
		this.b_publisher = b_publisher;
		this.b_writer = b_writer;
		this.b_price = b_price;
	}

	public Book(String b_title, String b_publisher, String b_writer, int b_price) {
		super();
		this.b_title = b_title;
		this.b_publisher = b_publisher;
		this.b_writer = b_writer;
		this.b_price = b_price;
	}

	
	public Book() {
		super();
	}

	public int getB_book_num() {
		return b_book_num;
	}

	public void setB_book_num(int b_book_num) {
		this.b_book_num = b_book_num;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_publisher() {
		return b_publisher;
	}

	public void setB_publisher(String b_publisher) {
		this.b_publisher = b_publisher;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	@Override
	public String toString() {
		return "Book [b_book_num=" + b_book_num + ", b_title=" + b_title + ", b_publisher=" + b_publisher
				+ ", b_writer=" + b_writer + ", b_price=" + b_price + "]";
	}
	
}
