package com.saurabh.ds.tree;

import java.util.List;
import java.util.ArrayList;
// https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75

public class PathSumMatchTargetSum {
 
    public int pathSum(TreeNode root, int targetSum) {
		if(root == null)
			return 0;
		
		return totalPaths(root, new long[]{}, targetSum);
    }

	public int totalPaths(TreeNode root, long[] sums, int targetSum) {
		if(root == null)
			return 0;
		int paths = 0;
		long[] lnewSums = new long[sums.length + 1];
		long[] rnewSums = new long[sums.length + 1];
		int i =0; 
		for(; i < sums.length; i++){
			long newSum = sums[i] + root.val;
			if(newSum == targetSum)
				paths++;
			lnewSums[i] = newSum;			
			rnewSums[i] = newSum;	
		}

		if(root.val == targetSum)
			paths++;
		lnewSums[i] = root.val;			
		rnewSums[i] = root.val;			
		
		return paths + totalPaths(root.left, lnewSums, targetSum) + totalPaths(root.right, rnewSums, targetSum);
	}
	
	public static void main(String[] args) {
		PathSumMatchTargetSum ps = new PathSumMatchTargetSum();		
/*		
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
		       10
			  / \
		    5    -3
		   / \    \
		  3  2    11   
		 /\   \
		3 -2   1
*/				
		TreeNode root_10 = new TreeNode(10);
		TreeNode l_5 = new TreeNode(5);
		TreeNode r_3 = new TreeNode(-3);
		root_10.left = l_5;
		root_10.right = r_3;
		TreeNode l_5_l_3 = new TreeNode(3);
		TreeNode l_5_r_2 = new TreeNode(2);
		l_5.left = l_5_l_3;
		l_5.right = l_5_r_2;
		TreeNode r_3_r_11 = new TreeNode(11);
		r_3.right = r_3_r_11;
		TreeNode l_3_l_3 = new TreeNode(3);
		TreeNode l_3_l_2 = new TreeNode(-2);
		l_5_l_3.left = l_3_l_3;
		l_5_l_3.right = l_3_l_2;
		l_5_r_2.right = new TreeNode(1);

//		System.out.println(ps.pathSum(root_10, 8));
		
/*		
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22

		       5
			  / \
		    4    8
		   /    / \
		  11   13  4   
		 /\        /\
		7  2      5  1
		  
*/				
		System.out.println("\n");
		TreeNode l7 = new TreeNode(7);
		TreeNode r2 = new TreeNode(2);
		TreeNode l11 = new TreeNode(11, l7, r2);
		TreeNode l4 = new TreeNode(4, l11, null);

		TreeNode l5 = new TreeNode(5);
		TreeNode r1 = new TreeNode(1);
		TreeNode r4 = new TreeNode(4, l5, r1);
		TreeNode l13 = new TreeNode(13);
		TreeNode r8 = new TreeNode(8, l13, r4);
		
		TreeNode root_5 = new TreeNode(5, l4, r8);
//		System.out.println(ps.pathSum(root_5, 22));
	



/*		
Input: root = [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000], targetSum = 0

		       1000000000
			  / 
		    1000000000    
		   /    
		  294967296      
		 /        
		1000000000        
	   /
	  1000000000
	 /
	1000000000  
*/				
		System.out.println("\n");
		TreeNode l100000 = new TreeNode(1000000000);
		TreeNode l10000 = new TreeNode(1000000000, l100000, null);
		TreeNode l1000 = new TreeNode(1000000000, l10000, null);
		TreeNode l294 = new TreeNode(294967296, l1000, null);
		TreeNode l100 = new TreeNode(1000000000, l294, null);
		
		TreeNode root = new TreeNode(1000000000, l100, null);
		System.out.println(ps.pathSum(root, 0));
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
