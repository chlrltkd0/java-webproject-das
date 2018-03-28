package com.das.biz.model.board;

import java.util.List;

public class BoardListVO {
	private int categoryIdx;
	private int page;
	private String range;
	private String keyword = "";
	private int boardCount;
	private List<BoardVO> boardList;
	
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public List<BoardVO> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	public BoardListVO(int categoryIdx, int page, String range, String keyword, int boardCount,
			List<BoardVO> boardList) {
		super();
		this.categoryIdx = categoryIdx;
		this.page = page;
		this.range = range;
		this.keyword = keyword;
		this.boardCount = boardCount;
		this.boardList = boardList;
	}
	public BoardListVO() {
		super();
	}
	@Override
	public String toString() {
		return "BoardListVO [categoryIdx=" + categoryIdx + ", page=" + page + ", range=" + range + ", keyword="
				+ keyword + ", boardCount=" + boardCount + ", boardList=" + boardList + "]";
	}
}
