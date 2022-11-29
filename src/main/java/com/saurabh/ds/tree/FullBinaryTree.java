package com.saurabh.ds.tree;

/*
 * 
 * A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.
 * It is also known as a proper binary tree.
 * 
 */
public class FullBinaryTree {

	Node root;
	
	FullBinaryTree(int data){
		this.root = new Node(data);
	}
	
	boolean isFullBinaryTree(Node node){
		if(node == null)
			return true;
		
		if(node.left == null && node.right == null)
			return true;
		
		if(node.left!=null && node.right!=null)
			return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
		
		return false;
	}
	
	public static void main(String[] args) {
		FullBinaryTree fbt = new FullBinaryTree(10);
		fbt.root.left = new Node(2);
		fbt.root.right = new Node(4);
		fbt.root.right.left = new Node(64);
		fbt.root.right.right = new Node(87);
		
		if(fbt.isFullBinaryTree(fbt.root))
			System.out.println("Full binary tree...");
		else
			System.out.println("NOT a full binary tree...");			

		System.out.println("");
		
		fbt.root.left.left = new Node(342);
		if(fbt.isFullBinaryTree(fbt.root))
			System.out.println("Full binary tree...");
		else
			System.out.println("NOT a full binary tree...");			


	}
}
