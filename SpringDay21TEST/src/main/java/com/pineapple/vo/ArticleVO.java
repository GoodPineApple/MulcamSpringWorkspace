package com.pineapple.vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int articleNum;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	private Timestamp writeDate;
	private int group;
	private int step;
	public ArticleVO(int articleNum, String title, String writer, String content, int readCount, Timestamp writeDate,
			int group, int step) {
		super();
		this.articleNum = articleNum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
		this.group = group;
		this.step = step;
	}
	public ArticleVO(String title, String writer, String content, int readCount, Timestamp writeDate, int group,
			int step) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
		this.group = group;
		this.step = step;
	}
	public ArticleVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public ArticleVO() {
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	@Override
	public String toString() {
		return "ArticleVO [articleNum=" + articleNum + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", readCount=" + readCount + ", writeDate=" + writeDate + ", group=" + group + ", step="
				+ step + "]";
	}
	
	
	

}
