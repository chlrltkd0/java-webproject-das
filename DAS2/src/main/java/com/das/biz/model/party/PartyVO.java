package com.das.biz.model.party;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.das.biz.model.action.Moving;
import com.das.biz.model.action.Staying;
import com.das.biz.model.path.PartyLocationVO;
import com.das.biz.model.path.PatternLink;
import com.das.biz.model.path.PatternNode;

public class PartyVO {
	private int id;
    private String name;			
    private String loginId;
    private String loginPwd;
    private int cash;
    private int grade;
    private int score;
    private int securityDeposit;
    private Timestamp regDt;
    private Timestamp lastLoginDt;
    
    private List<PartyLocationVO> listLoc = new ArrayList<>();
    private List<Moving> listMoving = new ArrayList<>();
    private List<Staying> listStaying = new ArrayList<>();
    private List<PatternLink> listLink = new ArrayList<>();
    private List<PatternNode> listNode = new ArrayList<>();
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(int securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public Timestamp getRegDt() {
		return regDt;
	}
	public void setRegDt(Timestamp regDt) {
		this.regDt = regDt;
	}
	public Timestamp getLastLoginDt() {
		return lastLoginDt;
	}
	public void setLastLoginDt(Timestamp lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}
	public List<PartyLocationVO> getListLoc() {
		return listLoc;
	}
	public void setListLoc(List<PartyLocationVO> listLoc) {
		this.listLoc = listLoc;
	}
	public List<PatternLink> getListLink() {
		return listLink;
	}
	public void setListLink(List<PatternLink> listLink) {
		this.listLink = listLink;
	}
	public List<PatternNode> getListNode() {
		return listNode;
	}
	public void setListNode(List<PatternNode> listNode) {
		this.listNode = listNode;
	}
	public List<Moving> getListMoving() {
		return listMoving;
	}
	public void setListMoving(List<Moving> listMoving) {
		this.listMoving = listMoving;
	}
	public List<Staying> getListStaying() {
		return listStaying;
	}
	public void setListStaying(List<Staying> listStaying) {
		this.listStaying = listStaying;
	}
	public PartyVO() {
		super();
	}
	public PartyVO(int id, String name, String loginId, String loginPwd, int cash, int grade, int score,
			int securityDeposit, Timestamp regDt, Timestamp lastLoginDt, List<PartyLocationVO> listLoc,
			List<Moving> listMoving, List<Staying> listStaying, List<PatternLink> listLink,
			List<PatternNode> listNode) {
		super();
		this.id = id;
		this.name = name;
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.cash = cash;
		this.grade = grade;
		this.score = score;
		this.securityDeposit = securityDeposit;
		this.regDt = regDt;
		this.lastLoginDt = lastLoginDt;
		this.listLoc = listLoc;
		this.listMoving = listMoving;
		this.listStaying = listStaying;
		this.listLink = listLink;
		this.listNode = listNode;
	}
	@Override
	public String toString() {
		return "PartyVO [id=" + id + ", name=" + name + ", loginId=" + loginId + ", loginPwd=" + loginPwd + ", cash="
				+ cash + ", grade=" + grade + ", score=" + score + ", securityDeposit=" + securityDeposit + ", regDt="
				+ regDt + ", lastLoginDt=" + lastLoginDt + ", listLoc=" + listLoc + ", listLink=" + listLink
				+ ", listNode=" + listNode + "]";
	}
}
