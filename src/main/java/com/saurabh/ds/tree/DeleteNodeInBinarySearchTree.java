package com.saurabh.ds.tree;

// https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75

import java.util.List;
import java.util.ArrayList;

public class DeleteNodeInBinarySearchTree {

    public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null)
			return root;
		
		if(root.val == key) {
			if(root.left!=null && root.right!=null){
				if(root.left.right == null){
					root.left.right = root.right;
					root = root.left;
				} else if(root.right.left == null){
					root.right.left = root.left;
					root = root.right;
				} else {
					TreeNode tempNode = root.left.right;
					root.left.right = root.right;
					rebalanceTree(tempNode, root.right);
					root = root.left;
				}
			} else if(root.left!=null){
				return root.left;
			} else if(root.right != null){
				return root.right;
			} else {
				return null;
			}
		} else {
			root.left = deleteNode(root.left, key);
			root.right = deleteNode(root.right, key);
		}
        return root;
    }
	
	public void rebalanceTree(TreeNode tempNode, TreeNode root) {
		if(root.left == null){
			root.left = tempNode;
			return;
		}
		rebalanceTree(tempNode, root.left);
	}
	
	public static void main(String[] args) {
		DeleteNodeInBinarySearchTree dn = new DeleteNodeInBinarySearchTree();
/*
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]

*/

		String[] str1 = {"5","3","6","2","4","null","7"};
		TreeNode root1 = getTree(str1);
		print(root1);
		print(dn.deleteNode(root1, 3));


/*
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]

*/
		String[] str2 = {"5","3","6","2","4","null","7"};
		TreeNode root2 = getTree(str2);
		print(root2);
		print(dn.deleteNode(root2, 0));

/*
Input: root = [], key = 0
Output: []

*/
		TreeNode root3 = null;
		print(root3);
		print(dn.deleteNode(root3, 0));		
		
		String[] str4 = {"15","11","16","8","13","null","17", "5", "9", "12", "14"};
		TreeNode root4 = getTree(str4);
		print(root4);
		print(dn.deleteNode(root4, 11));
		
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

	public static void print(TreeNode root){
		if(root == null){
			System.out.println("[]");
			return;
		}

		System.out.print("[");
		List<TreeNode> nodes = new ArrayList<>();
		nodes.add(root);
		print(nodes);
		System.out.println("]");
	}

	public static void print(List<TreeNode> nodes){
		if(nodes.isEmpty()){
			System.out.print("null,");
			return;
		}

		List<TreeNode> childs = new ArrayList<>();
		for(TreeNode node : nodes){
			if(node == null){
				System.out.print("null,");
				continue;
			}
			System.out.print(node.val + ",");
			childs.add(node.left);
			childs.add(node.right);
		}
		
		print(childs);
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
