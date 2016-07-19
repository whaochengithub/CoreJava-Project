package com.whc.dictionary;

import java.util.ArrayList;


public class TreeNode {
	private char content;
	private boolean isEnd;
	private int count;
	private ArrayList<TreeNode> childList;
	private String result;
	
	public TreeNode(char c){
		
		this.childList = new ArrayList<TreeNode>();
		this.isEnd = false;
		this.content = c;
		this.count = 0;
		this.result= null;
	}
	
	
	public TreeNode subNode(char c){
		 if (this.childList != null)
	            for (TreeNode eachChild : this.childList)
	                if (eachChild.content == c)
	                    return eachChild;
	        return null;
	}
	public char getContent() {
		return this.content;
	}



	public void setContent(char content) {
		this.content = content;
	}



	public boolean isEnd() {
		return this.isEnd;
	}



	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}



	public int getCount() {
		return this.count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public ArrayList<TreeNode> getChildList() {
		return childList;
	}



	public void setChildList(ArrayList<TreeNode> childList) {
		this.childList = childList;
	}



	public String getResult() {
		return this.result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	
	
	
	
}
