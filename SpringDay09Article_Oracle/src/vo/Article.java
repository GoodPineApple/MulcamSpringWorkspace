package vo;

import java.sql.Timestamp;

public class Article {
	private int articleNum;
	private Timestamp createDate;
	private int hits;
	private String writer;
	private String pw;
	private String title;
	private String ct;
	private int gp;
	private int step;
	
	public Article(int articleNum, Timestamp createDate, int hits, String writer, String pw, String title, String ct,
			int gp, int step) {
		this.articleNum = articleNum;
		this.createDate = createDate;
		this.hits = hits;
		this.writer = writer;
		this.pw = pw;
		this.title = title;
		this.ct = ct;
		this.gp = gp;
		this.step = step;
	}

	public Article(String writer, String pw, String title, String ct) {
		this.writer = writer;
		this.pw = pw;
		this.title = title;
		this.ct = ct;
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public int getGp() {
		return gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "Article [articleNum=" + articleNum + ", createDate=" + createDate + ", hits=" + hits + ", writer="
				+ writer + ", pw=" + pw + ", title=" + title + ", ct=" + ct + ", gp=" + gp + ", step=" + step + "]";
	}
}
