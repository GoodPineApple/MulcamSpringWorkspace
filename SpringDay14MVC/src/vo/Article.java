package vo;

import java.util.Date;

public class Article {
	private int articleNum;
	private String title;
	private String content;
	private String writer;
	private int readCount ;
	private Date writeDate ;
	
	public Article(int articleNum, String title, String content, String writer, int readCount, Date writeDate) {
		super();
		this.articleNum = articleNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}

	public Article(String title, String content, String writer, int readCount, Date writeDate) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}

	public Article() {
		super();
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Article [articleNum=" + articleNum + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", readCount=" + readCount + ", writeDate=" + writeDate + "]";
	}
}
