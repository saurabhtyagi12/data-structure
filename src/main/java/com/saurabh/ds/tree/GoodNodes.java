package com.saurabh.ds.tree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75

public class GoodNodes {
 
    public int goodNodes(TreeNode root) {
		int maxVal = root.val;
		return goodNodesCount(root.left, maxVal) + goodNodesCount(root.right, maxVal) + 1;
    }

    public int goodNodesCount(TreeNode root, int maxVal) {
		if(root == null)
			return 0;
		
		if(root.val >= maxVal){
			maxVal = root.val;
			return goodNodesCount(root.left, maxVal) + goodNodesCount(root.right, maxVal) + 1;
		} else {
			return goodNodesCount(root.left, maxVal) + goodNodesCount(root.right, maxVal);
		}
    }
	
	public static void main(String[] args) {
		GoodNodes gn = new GoodNodes();
		
/*		// root1 = [3,1,4,3,null,1,5] 
		       3
			  / \
		    1    4
		   /    / \
		  3    1   5
*/				
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(4);
		root.left = l1;
		root.right = r1;
		TreeNode ll1 = new TreeNode(3);
		l1.left = ll1;
		TreeNode rll1 = new TreeNode(1);
		TreeNode rrr1 = new TreeNode(5);
		r1.left = rll1;
		r1.right = rrr1;

		System.out.println(gn.goodNodes(root));
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
