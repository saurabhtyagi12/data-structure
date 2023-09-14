package com.saurabh.ds.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class LowestCommonAncestor {
 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		
		if(root.val == p.val || root.val == q.val)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left!=null && right!=null)
			return root;
		
		return left!=null ? left : right;
    }

	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();		
/*		
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3

*/				

		String[] str1 = {"3","5","1","6","2","0","8","null","null","7","4"};
		TreeNode root1 = getTree(str1);
		TreeNode p1 = new TreeNode(5);
		TreeNode q1 = new TreeNode(1);
		System.out.println(lca.lowestCommonAncestor(root1, p1, q1).val);

		
/*		
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
	  
*/				
		String[] str2 = { "3","5","1","6","2","0","8","null","null","7","4"};
		TreeNode root2 = getTree(str2);
		TreeNode p2 = new TreeNode(5);
		TreeNode q2 = new TreeNode(4);
		System.out.println(lca.lowestCommonAncestor(root2, p2, q2).val);

/*
Input: root = [1,2], p = 1, q = 2
Output: 1
*/	
		String[] str3 = { "1","2"};
		TreeNode root3 = getTree(str3);
		TreeNode p3 = new TreeNode(1);
		TreeNode q3 = new TreeNode(2);
		System.out.println(lca.lowestCommonAncestor(root3, p3, q3).val);
		
/*
Input: root = [1,2,3,null,4], p=4, q=3
Output: 1
*/		
		String[] str4 = { "1","2","3","null","4"};
		TreeNode root4 = getTree(str4);
		TreeNode p4 = new TreeNode(4);
		TreeNode q4 = new TreeNode(3);
		System.out.println(lca.lowestCommonAncestor(root4, p4, q4).val);

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
			
			if((i+1) >=elVals.length){
				i++;
				break;
			}
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
