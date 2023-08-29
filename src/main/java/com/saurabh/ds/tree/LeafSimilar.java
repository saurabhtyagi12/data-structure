package com.saurabh.ds.tree;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75

public class LeafSimilar {
 
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
		
		getLeafNodes(root1, l1);
		getLeafNodes(root2, l2);
		
		if(l1.size() != l2.size())
			return false;
			
		for(int i =0; i< l1.size(); i++){
			if(l1.get(i) != l2.get(i))
				return false;
		}
		
		return true;
    }
	
	public void getLeafNodes(TreeNode root, List<Integer> ls) {
		if(root==null)
			return;
			
		if(root.left == null && root.right == null)
			ls.add(root.val);
		
		getLeafNodes(root.left, ls);
		getLeafNodes(root.right, ls);
	}
	
	public static void main(String[] args) {
		LeafSimilar ls = new LeafSimilar();
		
/*		// root1 = [3,5,1,6,2,9,8,null,null,7,4] 
		       3
			  / \
		  5         1
		 / \       / \
		6    2    9   8
		    / \
		   7   4   
*/				
		TreeNode root1 = new TreeNode(3);
		TreeNode l1 = new TreeNode(5);
		TreeNode r1 = new TreeNode(1);
		root1.left = l1;
		root1.right = r1;
		TreeNode ll1 = new TreeNode(6);
		TreeNode rr1 = new TreeNode(2);
		l1.left = ll1;
		l1.right = rr1;
		TreeNode rll1 = new TreeNode(9);
		TreeNode rrr1 = new TreeNode(8);
		r1.left = rll1;
		r1.right = rrr1;
		TreeNode r2ll1 = new TreeNode(7);
		TreeNode r2rr1 = new TreeNode(4);
		rr1.left = r2ll1;
		rr1.right = r2rr1;

/*		// root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
		       3
			/    \
	     5          1
	    / \        / \
	   6   7      4   2
		             / \
		            9   8   
				
*/				

		TreeNode root2 = new TreeNode(3);
		TreeNode l2 = new TreeNode(5);
		TreeNode r2 = new TreeNode(1);
		root2.left = l2;
		root2.right = r2;
		TreeNode ll2 = new TreeNode(6);
		TreeNode lr2 = new TreeNode(7);
		l2.left = ll2;
		l2.right = lr2;
		TreeNode rl2 = new TreeNode(4);
		TreeNode rr2 = new TreeNode(2);
		r2.left = rl2;
		r2.right = rr2;
		TreeNode rrl2 = new TreeNode(9);
		TreeNode rrr2 = new TreeNode(8);
		rr2.left = rrl2;
		rr2.right = rrr2;
		
		System.out.println(ls.leafSimilar(root1, root2));
	}
	
}

// Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
