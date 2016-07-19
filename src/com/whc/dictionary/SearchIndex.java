package com.whc.dictionary;

import java.util.ArrayList;

public class SearchIndex {
	private Tire index;
	public SearchIndex(Tire tire) {
		this.index = tire;
	}

	public String exactSearch(String word){
		return index.query(word);
	}
	public ArrayList<String> getQuery(String input) {
		ArrayList<String> output = new ArrayList<String>();
		TreeNode node = this.index.search(input);
		try {
			getNext(node, output);
		} catch (Exception e) {
			ArrayList<String> s = new ArrayList<String>();
			s.add("");
			s.add("");
			s.add("");
			s.add("");
			s.add("");
			return s;
		}
		while(output.size()<5){
			output.add(" ");
		}
		return output;
	}

	private void getNext(TreeNode node, ArrayList<String> results) {
		if (results.size() >= 5) {
			return;
		}
		if (node.getResult() != null) {
			results.add(node.getResult());
		}
		if (node.getChildList() != null) {
			for (TreeNode subNode : node.getChildList()) {
				getNext(subNode, results);
			}
		} else {
			return;
		}
	}

}
