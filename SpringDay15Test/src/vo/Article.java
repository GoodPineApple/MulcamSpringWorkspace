package vo;

import java.util.Date;

public class Article {
	private int articleNum;
	private String title;
	private String content;
	private int read_count;
	private Date writeDate;
	private String writer;
	private int family;
	private int parent;
	private int depth;
	
	public Article(){}
	
	public Article(int articleNum, String title, String content, int read_count, Date writeDate, String writer,
			int family, int parent, int depth) {
		super();
		this.articleNum = articleNum;
		this.title = title;
		this.content = content;
		this.read_count = read_count;
		this.writeDate = writeDate;
		this.writer = writer;
		this.family = family;
		this.parent = parent;
		this.depth = depth;
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
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getFamily() {
		return family;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "Article [articleNum=" + articleNum + ", title=" + title + ", content=" + content + ", read_count="
				+ read_count + ", writeDate=" + writeDate + ", writer=" + writer + ", family=" + family + ", parent="
				+ parent + ", depth=" + depth + "]";
	}
	
	
	
}
