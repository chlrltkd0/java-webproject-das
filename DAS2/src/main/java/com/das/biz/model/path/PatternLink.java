package com.das.biz.model.path;

public class PatternLink {
	private int id;
	private int partyId;
	private int fromNodeId;
	private int toNodeId;
	private PatternNode fromNode;
	private PatternNode toNode;
	
	public boolean isEqualPath(PatternLink pl) {
		if(fromNodeId==pl.getFromNodeId() && toNodeId==pl.getToNodeId())
			return true;
		return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public int getFromNodeId() {
		return fromNodeId;
	}
	public void setFromNodeId(int fromNodeId) {
		this.fromNodeId = fromNodeId;
	}
	public int getToNodeId() {
		return toNodeId;
	}
	public void setToNodeId(int toNodeId) {
		this.toNodeId = toNodeId;
	}
	public PatternNode getFromNode() {
		return fromNode;
	}
	public void setFromNode(PatternNode fromNode) {
		this.fromNode = fromNode;
	}
	public PatternNode getToNode() {
		return toNode;
	}
	public void setToNode(PatternNode toNode) {
		this.toNode = toNode;
	}
	public PatternLink(int id, int partyId, int fromNodeId, int toNodeId, PatternNode fromNode, PatternNode toNode) {
		super();
		this.id = id;
		this.partyId = partyId;
		this.fromNodeId = fromNodeId;
		this.toNodeId = toNodeId;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}
	public PatternLink() {
		super();
	}
	public PatternLink(int id, PatternNode fromNode, PatternNode toNode) {
		super();
		this.id = id;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}
	public PatternLink(int id, int fromNodeId, int toNodeId) {
		super();
		this.id = id;
		this.fromNodeId = fromNodeId;
		this.toNodeId = toNodeId;
	}
	public PatternLink(PatternNode fromNode, PatternNode toNode) {
		super();
		this.fromNode = fromNode;
		this.toNode = toNode;
	}
	public PatternLink(int fromNodeId, int toNodeId) {
		super();
		this.fromNodeId = fromNodeId;
		this.toNodeId = toNodeId;
	}
	@Override
	public String toString() {
		return "PatternLink [id=" + id + ", partyId=" + partyId + ", fromNodeId=" + fromNodeId + ", toNodeId="
				+ toNodeId + ", fromNode=" + fromNode + ", toNode=" + toNode + "]";
	}
}
