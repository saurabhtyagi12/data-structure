package com.saurabh.ds.tree;

// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class TreeRightSideView {
 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

		if(root != null){
			List<TreeNode> childs = new ArrayList<>();
			childs.add(root);
			rightSideView(childs, list);
		}
		
		return list;
    }

    public List<Integer> rightSideView(List<TreeNode> parents, List<Integer> list) {
		int size = parents.size();
		if(size == 0)
			return list;
		
		list.add(parents.get(size - 1).val);
		
		List<TreeNode> childs = new ArrayList<>();
		for(TreeNode root : parents){
			if(root.left != null)
				childs.add(root.left);
			if(root.right != null)
				childs.add(root.right);
		}
		
		return rightSideView(childs, list);
    }

	public static void main(String[] args) {
		TreeRightSideView trsv = new TreeRightSideView();		
/*		
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

*/				

		String[] str1 = {"1","2","3","null","5","null","4"};
		TreeNode root1 = getTree(str1);
		System.out.println(trsv.rightSideView(root1));

		
/*		
Input: root = [1,null,3]
Output: [1,3]
	  
*/				
		String[] str2 = {"1","null","3"};
		TreeNode root2 = getTree(str2);
		System.out.println(trsv.rightSideView(root2));

/*
Input: root = []
Output: []
*/	
		TreeNode root3 = null;
		System.out.println(trsv.rightSideView(root3));
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
