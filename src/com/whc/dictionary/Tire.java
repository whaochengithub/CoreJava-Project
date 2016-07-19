package com.whc.dictionary;

public class Tire {
	private TreeNode root;
	
	public Tire(){
		this.root = new TreeNode(' ');
	}
	
	public TreeNode search(String word){
		TreeNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return null;
            else
                current = current.subNode(ch);
        }      
		return current;
	}
	
	 public String query(String word)
	    {
	        TreeNode current = root;  
	        for (char ch : word.toCharArray() )
	        {
	            if (current.subNode(ch) == null)
	                return "404 not found";
	            else
	                current = current.subNode(ch);
	        }      
	        if (current.getResult() !=null) 
	            return current.getResult();
	        return "404 not found";
	    }
	
	public void insert(String word, String result){
		if (search(word) !=null) 
            return;        
        TreeNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TreeNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.getChildList().add(new TreeNode(ch));
                 current = current.subNode(ch);
            }
            current.setCount(current.getCount()+1);
        }
        current.setResult(result);
        current.setEnd(true);
	}
}
