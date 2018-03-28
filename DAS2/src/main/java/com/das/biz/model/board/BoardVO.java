package com.das.biz.model.board;

import java.sql.Timestamp;

public class BoardVO {
	private int idx;
	private int categoryIdx;
	private String title;
	private String content;
	private String writer;
	private int writerIdx;
	private Timestamp regDate;
	private Timestamp modifyDate;
	private int likePoint;
	private int hatePoint;
	private int comments;
	private int hit;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
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
	public int getWriterIdx() {
		return writerIdx;
	}
	public void setWriterIdx(int writerIdx) {
		this.writerIdx = writerIdx;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getLikePoint() {
		return likePoint;
	}
	public void setLikePoint(int likePoint) {
		this.likePoint = likePoint;
	}
	public int getHatePoint() {
		return hatePoint;
	}
	public void setHatePoint(int hatePoint) {
		this.hatePoint = hatePoint;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public BoardVO(int idx, int categoryIdx, String title, String content, String writer, int writerIdx,
			Timestamp regDate, Timestamp modifyDate, int likePoint, int hatePoint, int comments, int hit) {
		super();
		this.idx = idx;
		this.categoryIdx = categoryIdx;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writerIdx = writerIdx;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
		this.likePoint = likePoint;
		this.hatePoint = hatePoint;
		this.comments = comments;
		this.hit = hit;
	}
	public BoardVO() {
		super();
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", categoryIdx=" + categoryIdx + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", writerIdx=" + writerIdx + ", regDate=" + regDate + ", modifyDate="
				+ modifyDate + ", likePoint=" + likePoint + ", hatePoint=" + hatePoint + ", comments=" + comments
				+ ", hit=" + hit + "]";
	}
}