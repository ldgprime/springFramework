package com.ldg.dbs.dto;

import java.util.Date;

public class ReplyVO {
	
	private int rno;
	private String content;
	private String wrter;
	private Date regdate;
	private int bno;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrter() {
		return wrter;
	}
	public void setWrter(String wrter) {
		this.wrter = wrter;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override	
	public String toString() {
		return "ReplyVO [rno=" + rno + ", content=" + content + ", wrter=" + wrter + ", regdate=" + regdate + ", bno="
				+ bno + "]";
	}
	
	

}
