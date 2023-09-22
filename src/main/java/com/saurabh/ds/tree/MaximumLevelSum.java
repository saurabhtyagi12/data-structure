package com.saurabh.ds.tree;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		return getMaxSumLevel(nodes, Integer.MIN_VALUE, 0, 1);
    }

	public int getMaxSumLevel(List<TreeNode> nodes, int max, int maxLevel, int level) {
		if(nodes.isEmpty())
			return maxLevel;
		int sum = 0;
		List<TreeNode> childs = new ArrayList<>();
		for(TreeNode root : nodes) {
			sum += root.val;
			if(root.left!=null)
				childs.add(root.left);
			if(root.right!=null)
				childs.add(root.right);
		}

		if(sum > max){
			max = sum;
			maxLevel = level;
		}
		int tempLevel = getMaxSumLevel(childs, max, maxLevel, level + 1);

		if(tempLevel > maxLevel)
			return tempLevel;
		else
			return maxLevel;
	}

	public static void main(String[] args) {
		MaximumLevelSum mls = new MaximumLevelSum();
/*
Input: root = [1,7,0,7,-8,null,null]
Output: 2

*/

		String[] str1 = {"1","7","0","7","-8","null","null"};
		TreeNode root1 = getTree(str1);
		System.out.println(mls.maxLevelSum(root1));


/*
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

*/
		String[] str2 = {"989","null","10250","98693","-89388","null","null","null","-32127"};
		TreeNode root2 = getTree(str2);
		System.out.println(mls.maxLevelSum(root2));
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
