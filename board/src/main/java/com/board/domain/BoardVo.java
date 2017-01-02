package com.board.domain;

import java.util.Date;

public class BoardVo {
	private int bno;
	private String subject;
	private String content;
	private String writer;
	private Date reg_date;
	private int hit;
	
	public BoardVo(int bno, String subject, String content, String writer, Date reg_date, int hit) {
		super();
		this.bno = bno;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	public BoardVo(String subject, String content, String writer, Date reg_date, int hit) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	public BoardVo() {
		super();
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", reg_date=" + reg_date + ", hit=" + hit + "]";
	}
	
	
	
	
}
