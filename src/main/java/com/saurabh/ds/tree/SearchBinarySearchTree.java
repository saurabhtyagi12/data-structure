package com.saurabh.ds.tree;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class SearchBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
		if(root == null)
			return null;
		
        if(root.val == val)
			return root;
		
		TreeNode left = searchBST(root.left, val);
		if(left!=null)
			return left;
		return searchBST(root.right, val);
    }
	
	public static void main(String[] args) {
		SearchBinarySearchTree sbst = new SearchBinarySearchTree();
/*
Input: root = [4,2,7,1,3], val = 2
Output: 2

*/

		String[] str1 = {"4","2","7","1","3"};
		TreeNode root1 = getTree(str1);
		System.out.println(sbst.searchBST(root1, 2));


/*
Input: root = [4,2,7,1,3], val = 5
Output: []

*/
		String[] str2 = {"4","2","7","1","3"};
		TreeNode root2 = getTree(str2);
		System.out.println(sbst.searchBST(root2, 5));
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
