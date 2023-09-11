package com.saurabh.ds.tree;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class LongestZigZagPath {
 
    public int longestZigZag(TreeNode root) {
		if(root == null)
			return 0;
		int lLongestPath = longestZigZag(root.left, true, 0);
		int rLongestPath = longestZigZag(root.right, false, 0);
		
		return Math.max(lLongestPath, rLongestPath);
    }
	
    public int longestZigZag(TreeNode root, boolean isLeft, int max) {
		if(root == null)
			return max;
		int lLongestPath = 0;
		int rLongestPath = 0;
		if(isLeft){
			rLongestPath = longestZigZag(root.right, false, max + 1);
			lLongestPath = longestZigZag(root.left, true, 0);
		} else {
			lLongestPath = longestZigZag(root.left, true, max + 1);
			rLongestPath = longestZigZag(root.right, false, 0);
		}
		
		return Math.max(lLongestPath, rLongestPath);
    }
	
	
	public static void main(String[] args) {
		LongestZigZagPath lzzp = new LongestZigZagPath();		
/*		
Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]

		       1
			   \
		        1
		      /  \
		     1    1   
		          /\
		         1  1
				 \
				  1
				  \
				   1
*/				

		String[] str1 = { "1", "null" ,"1","1","1","null","null","1","1","null","1","null","null","null","1"};
		TreeNode root1 = getTree(str1);
		System.out.println(lzzp.longestZigZag(root1));

		
/*		
Input: root = [1,1,1,null,1,null,null,1,1,null,1]

		       1
			  /\
			 1  1
			 \
			  1
			 / \
			1   1
			\
			 1		  
*/				
		String[] str2 = { "1","1","1","null","1","null","null","1","1","null","1"};
		TreeNode root2 = getTree(str2);
		System.out.println(lzzp.longestZigZag(root2));
	
	}
	
	public static TreeNode getTree(String[] elVals) {
		int i = 1;
		TreeNode root = new TreeNode(Integer.parseInt(elVals[0]));
		List<TreeNode> lsNode = new ArrayList<>();
		lsNode.add(root);
		getTree(elVals, lsNode, i);
		return root;
	}

	public static TreeNode getTree(String[] elVals, List<TreeNode> lsNode, int i) {
		List<TreeNode> lsNodeNew = new ArrayList<>();
		int size = lsNode.size();
		int cnt = 0;
		for(TreeNode node : lsNode) {
			if(i >=elVals.length)
				break;
			if(!elVals[i].equals("null")){
				node.left = new TreeNode(Integer.parseInt(elVals[i]));
				lsNodeNew.add(node.left);
			}
			
			if((i+1) >=elVals.length)
				break;
			if(!elVals[i+1].equals("null")){
				node.right = new TreeNode(Integer.parseInt(elVals[i+1]));
				lsNodeNew.add(node.right);
			}
			
			i=i+2;
			
		}
		if(i >= elVals.length)
			return null;
		
		return getTree(elVals, lsNodeNew, i);
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
