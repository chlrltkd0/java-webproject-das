package com.das.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.board.BoardCategoryService;
import com.das.biz.model.board.BoardCategoryVO;
import com.das.biz.model.board.BoardListVO;
import com.das.biz.model.board.BoardService;
import com.das.biz.model.board.BoardVO;
import com.das.biz.model.party.PartyVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	@Autowired
	private BoardCategoryService bcService;
	
	@RequestMapping("getBoardCategoryList.do")
	@ResponseBody
	public List<BoardCategoryVO> getBoardCategoryList() {
		System.out.println("log getBoartdCategoryList");
		return bcService.getBoardCategoryList();
	}
	
	@RequestMapping("getBoardCategory.do")
	@ResponseBody
	public BoardCategoryVO getBoardCategory(BoardCategoryVO bcvo) {
		System.out.println("log getBoartdCategoryList");
		return bcService.getBoardCategory(bcvo);
	}
	
	@RequestMapping("updateBoardCategory.do")
	@ResponseBody
	public List<BoardCategoryVO> updateBoardCategory(BoardCategoryVO bcvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		bcService.updateBoardCategory(bcvo, pvo);
		return bcService.getBoardCategoryList();
	}
	
	@RequestMapping("insertBoardCategory.do")
	@ResponseBody
	public List<BoardCategoryVO> insertBoardCategory(BoardCategoryVO bcvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		bcService.insertBoardCategory(bcvo, pvo);
		return bcService.getBoardCategoryList();
	}
	
	@RequestMapping("deleteBoardCategory.do")
	@ResponseBody
	public List<BoardCategoryVO> deleteBoardCategory(BoardCategoryVO bcvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		bcService.deleteBoardCategory(bcvo, pvo);
		return bcService.getBoardCategoryList();
	}
	
	@RequestMapping("writeBoard.do")
	@ResponseBody
	public boolean writeBoard(BoardVO bvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return bService.writeBoard(bvo, pvo);
	}
	
	@RequestMapping("updateBoard.do")
	@ResponseBody
	public boolean updateBoard(BoardVO bvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		bService.updateBoard(bvo, pvo);
		return true;
	}
	
	@RequestMapping("deleteBoard.do")
	@ResponseBody
	public boolean deleteBoard(BoardVO bvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		bService.deleteBoard(bvo, pvo);
		return true;
	}
	
	@RequestMapping("getBoard.do")
	@ResponseBody
	public BoardVO getBoard(BoardVO bvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return bService.getBoard(bvo, pvo);
	}
	
	@RequestMapping("getBoardList.do")
	@ResponseBody
	public BoardListVO getBoardList(BoardListVO blvo) {
		BoardListVO bbbvo = bService.getBoardList(blvo);
		return bbbvo;
	}

}