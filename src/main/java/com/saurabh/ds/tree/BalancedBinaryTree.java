package com.saurabh.ds.tree;

/* 
 * 
 * A balanced binary tree, also referred to as a height-balanced binary tree, is defined as a binary tree in which the height of the 
 * left and right subtree of any node differ by not more than 1.
 * 
 * Following are the conditions for a height-balanced binary tree:
 *   difference between the left and the right subtree for any node is not more than one
 *   the left subtree is balanced
 *   the right subtree is balanced
 *   
 *   
 */
public class BalancedBinaryTree {

	Node root;
	
	public BalancedBinaryTree(int data) {
		root = new Node(data);
	}
	
	int getHeight(Node node) {
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 0;
		
		int leftSubtreeHeight = 1 + getHeight(node.left);
		int rightSubtreeHeight = 1 + getHeight(node.right);

		if(leftSubtreeHeight >= rightSubtreeHeight)
			return leftSubtreeHeight;
		else
			return rightSubtreeHeight;

	}
	
	/*
	 * 
	 */
	boolean isHeightBalancedBinaryTree(Node node) {
		if(node == null)
			return true;
		
		int leftSubtreeHeight = getHeight(node.left);
		int rightSubtreeHeight = getHeight(node.right);
		
		if(leftSubtreeHeight >= rightSubtreeHeight)
			return leftSubtreeHeight - rightSubtreeHeight <= 1;
		else
			return rightSubtreeHeight - leftSubtreeHeight <=1;
	}

	/*
	 * 
	 */
	boolean isHeightBalancedBinaryTree(Node node, Height height) {
		if(node == null) {
			height.setHeight(0);
			return true;
		}

		Height leftHeight = new Height();
		Height rightHeight = new Height();
		boolean leftHeightBalancedSubTree = isHeightBalancedBinaryTree(node.left, leftHeight);
		boolean rightHeightBalancedSubTree = isHeightBalancedBinaryTree(node.right, rightHeight);
		
		int nodeHeight = (leftHeight.getHeight() >= rightHeight.getHeight() ? leftHeight.getHeight() : rightHeight.getHeight())+1;
		height.setHeight(nodeHeight);
		
		if((leftHeight.getHeight() - rightHeight.getHeight()) >= 2 || (rightHeight.getHeight() - leftHeight.getHeight()) >=2 )
			return false;
		
		return leftHeightBalancedSubTree && rightHeightBalancedSubTree;		
	}	

	public static void main(String[] args) {
		BalancedBinaryTree bbt = new BalancedBinaryTree(10);
		bbt.root.left = new Node(20);
		bbt.root.right = new Node(30);
		bbt.root.left.left = new Node(40);
		bbt.root.left.right = new Node(50);
		
		boolean isHeightBalancedBinaryTree = bbt.isHeightBalancedBinaryTree(bbt.root, new Height());
		
		if(isHeightBalancedBinaryTree) {
			System.out.println("Height balanced boolean tree");
		} else {
			System.out.println("Not a height balanced boolean tree");			
		}

		System.out.println("");
		
//		bbt.root.right.right = new Node(60);
		bbt.root.left.left.left = new Node(60);
//		isHeightBalancedBinaryTree = bbt.isHeightBalancedBinaryTree(bbt.root);
		isHeightBalancedBinaryTree = bbt.isHeightBalancedBinaryTree(bbt.root, new Height());
		if(isHeightBalancedBinaryTree) {
			System.out.println("Height balanced boolean tree");
		} else {
			System.out.println("Not a height balanced boolean tree");			
		}

	}
}
