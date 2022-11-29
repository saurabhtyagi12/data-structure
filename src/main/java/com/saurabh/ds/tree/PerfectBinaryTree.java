package com.saurabh.ds.tree;

/*
 * 
 * A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.
 * Perfect Binary Tree
 * 
 * 
 */
public class PerfectBinaryTree {

	Node root;

	public PerfectBinaryTree(int data) {
		this.root = new Node(data);
	}

	int getDepth(Node node) {
		int depth = 0;
		Node tempNode = node;
		while (tempNode != null) {
			tempNode = tempNode.left;
			depth++;
		}
		return depth;
	}

	boolean isPerfectTree(Node node) {
		int depth = getDepth(node);
		return isPerfectTree(node, depth, 1);
	}

	boolean isPerfectTree(Node node, int depth, int level) {
		if (node == null)
			return true;

		if (node.left == null && node.right == null) {
			return depth == level;
		}

		if (node.left != null && node.right != null) {
			return isPerfectTree(node.left, depth, level + 1) && isPerfectTree(node.right, depth, level + 1);
		}

		return false;
	}
	
	public static void main(String[] args) {
		PerfectBinaryTree pbt = new PerfectBinaryTree(10);
		pbt.root.left = new Node(20);
		pbt.root.right = new Node(30);
		pbt.root.left.left = new Node(40);
		pbt.root.left.right = new Node(50);
		
		boolean isPerfectTree = pbt.isPerfectTree(pbt.root);
		if(isPerfectTree)
			System.out.println("Perfect Binary Tree...");
		else
			System.out.println("NOT a perfect Binary Tree...");
		
		pbt.root.right.left = new Node(630);
		pbt.root.right.right = new Node(730);

		System.out.println("");
		isPerfectTree = pbt.isPerfectTree(pbt.root);
		if(isPerfectTree)
			System.out.println("Perfect Binary Tree...");
		else
			System.out.println("NOT a perfect Binary Tree...");
	
	}
}
