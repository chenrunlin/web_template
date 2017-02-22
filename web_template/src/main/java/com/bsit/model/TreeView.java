package com.bsit.model;

import java.util.ArrayList;
import java.util.List;

public class TreeView {
	
	private String text;
	
	private List<TreeView> nodes;
	
	private String tags;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeView> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeView> nodes) {
		this.nodes = nodes;
	}
	
	public void addChild(TreeView node){
        if(this.nodes == null){
        	nodes = new ArrayList<TreeView>();
        	nodes.add(node);
        }else{
        	nodes.add(node);
        }
    }

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
