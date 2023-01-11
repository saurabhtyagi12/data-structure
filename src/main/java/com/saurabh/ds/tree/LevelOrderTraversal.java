package com.saurabh.ds.tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	levelOrder(root, list, 0);
        return list;
    }
    
    public void levelOrder(TreeNode root, List<List<Integer>> list, int index) {
    	if(root == null)
    		return ;
    	
    	List<Integer> levelList = null;
    	if(list.size() == index) { // traversing level first time
    		levelList = new ArrayList<Integer>();
    		list.add(levelList);    		
    	} else {
        	levelList = list.get(index);    		
    	}
    	
    	levelList.add(root.val);
    	levelOrder(root.left, list, index + 1);
    	levelOrder(root.right, list, index + 1);
    }
    
    public static void main(String[] args) {
    	LevelOrderTraversal lot = new LevelOrderTraversal();

		TreeNode root = lot.testcase1();
		System.out.println(lot.levelOrder(root));

		root = lot.testcase2();
		System.out.println(lot.levelOrder(root));

		root = lot.testcase3();
		System.out.println(lot.levelOrder(root));

	}
    
	public TreeNode testcase1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		return root;
	}

	public TreeNode testcase2() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		return root;
	}

	public TreeNode testcase3() {
		return null;
	}

}
