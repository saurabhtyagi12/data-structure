package com.saurabh.ds.tree;

/*
 * 
 * A complete binary tree is just like a full binary tree, but with two major differences
 *
 *   All the leaf elements must lean towards the left.
 *   The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.
 *
 * 
 * If the index of any element in the array is i, 
 * the element in the index 2i+1 will become the left child 
 * and element in 2i+2 index will become the right child. 
 * Also, the parent of any element at index i is given by the lower bound of (i-1)/2.
 * 
 * 
 */
public class CompleteBinaryTree {

	Node root;
	
	public CompleteBinaryTree() {
	}
	
	public CompleteBinaryTree(int data) {
		root = new Node(data);
	}
	
	int getNodeCount(Node root) {
		if(root == null)
			return 0;
		return 1 + getNodeCount(root.left) + getNodeCount(root.right);
	}
	
	boolean isCompleteBinaryTree(Node node, int index, int numberOfNodes) {
		if(node == null)
			return true;
		
		if(index >= numberOfNodes)
			return false;
		
		return isCompleteBinaryTree(node.left, (2*index + 1), numberOfNodes) && isCompleteBinaryTree(node.right, (2*index+2), numberOfNodes);
	}
	
	public static void main(String[] args) {
		CompleteBinaryTree cbt = new CompleteBinaryTree(10);
		cbt.root.left = new Node(20);
		cbt.root.right = new Node(30);
		
		int numberOfNodes = cbt.getNodeCount(cbt.root);
		System.out.println(numberOfNodes);
		
		boolean isCompleteBinaryTree = cbt.isCompleteBinaryTree(cbt.root, 0, cbt.getNodeCount(cbt.root));
		if(isCompleteBinaryTree)
			System.out.println("Complete binary tree");
		else
			System.out.println("Not a complete binary tree");

		System.out.println("");
		
		cbt.root.left.right = new Node(40);
		numberOfNodes = cbt.getNodeCount(cbt.root);
		System.out.println(numberOfNodes);
		
		isCompleteBinaryTree = cbt.isCompleteBinaryTree(cbt.root, 0, cbt.getNodeCount(cbt.root));
		if(isCompleteBinaryTree)
			System.out.println("Complete binary tree");
		else
			System.out.println("Not a complete binary tree");

	}
}
