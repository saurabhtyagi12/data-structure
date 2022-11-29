package com.saurabh.ds.tree;

/*
 * 
 * Height of a Node -> The height of a node is the number of edges from the node to the deepest leaf 
 * (ie. the longest path from the node to a leaf node).
 * 
 * Depth of a Node -> The depth of a node is the number of edges from the root to the node.
 * 
 * Degree of a Node -> The degree of a node is the total number of branches of that node.
 *
 *
 *
 * Binary search tree is a data structure that quickly allows us to maintain a sorted list of numbers.
 *
 *   It is called a binary tree because each tree node has a maximum of two children.
 *   It is called a search tree because it can be used to search for the presence of a number in O(log(n)) time.
 *
 * The properties that separate a binary search tree from a regular binary tree is
 *
 *   All nodes of left subtree are less than the root node
 *   All nodes of right subtree are more than the root node
 *   Both subtrees of each node are also BSTs i.e. they have the above two properties
 *
 *
 */
public class BinarySearchTree {

	private BinarySearchTree leftBinarSearchTree;
	private BinarySearchTree rightBinarySearchTree;
	private int data ;

	public BinarySearchTree(int value) {
		this.data = value;
	}
	
	public boolean insertNode(int value) {
		if(value < this.data ) {
			if(leftBinarSearchTree == null) {
				leftBinarSearchTree = new BinarySearchTree(value);
			} else {
				leftBinarSearchTree.insertNode(value);
			}
		} else {
			if(rightBinarySearchTree == null) {
				rightBinarySearchTree = new BinarySearchTree(value);
			} else {
				rightBinarySearchTree.insertNode(value);
			}
		}
		
		return true;
	}
	
	public boolean containesNode(int value) {
		if (this.data == value) {
			return true;
		} else if (value < this.data) {
			if (leftBinarSearchTree != null)
				return leftBinarSearchTree.containesNode(value);
		} else {
			if (rightBinarySearchTree != null)
				return rightBinarySearchTree.containesNode(value);
		}
		return false;
	}
	
	public BinarySearchTree findNode(int value) {
		if(this.data == value)
			return this;
		else if(value < this.data) {
			if(leftBinarSearchTree != null)
				return leftBinarSearchTree.findNode(value);
		} else {
			if(rightBinarySearchTree !=null) {
				return rightBinarySearchTree.findNode(value);
			}
		}
		return null;
	}
	
	// print left child node first -> then current node -> then right child node
	public void printInOrderTraversal() {
		if(leftBinarSearchTree!=null)
			leftBinarSearchTree.printInOrderTraversal();
		
		System.out.print(this.data + " ");
		
		if(rightBinarySearchTree!=null)
			rightBinarySearchTree.printInOrderTraversal();
	}
	
	// print current node -> then left child node first -> then right child node
	public void printPreOrderTraversal() {
		System.out.print(this.data + " ");

		if(leftBinarSearchTree!=null)
			leftBinarSearchTree.printPreOrderTraversal();
		
		if(rightBinarySearchTree!=null)
			rightBinarySearchTree.printPreOrderTraversal();
	}

	// print left child node first -> then right child node -> then current node 
	public void printPostOrderTraversal() {
		if(leftBinarSearchTree!=null)
			leftBinarSearchTree.printPostOrderTraversal();
		
		if(rightBinarySearchTree!=null)
			rightBinarySearchTree.printPostOrderTraversal();

		System.out.print(this.data + " ");
	}

	public BinarySearchTree deleteNode(BinarySearchTree root, int key) {
		if(root == null)
			return null;
		
		
		if(key < root.data) // key is less than the current node so traverse through left
		{
			root.leftBinarSearchTree = deleteNode(root.leftBinarSearchTree, key);
			return root;
		}
		else if(key > root.data) // key is greater than the current node so traverse through right
		{
			root.rightBinarySearchTree = deleteNode(root.rightBinarySearchTree, key);
			return root;
		}
		else // Got the node to be deleted, now delete the node and replace it with the child node
		{
			// left and right child both are not null
			if(root.leftBinarSearchTree != null && root.rightBinarySearchTree != null) {
				BinarySearchTree tempNode = getInorderSuccessor(root.rightBinarySearchTree);
				root.data = tempNode.data;
				root.rightBinarySearchTree = deleteNode(root.rightBinarySearchTree, tempNode.data);
				return root;
			}
			
			// left child is not null
			if(root.leftBinarSearchTree!=null) {
				root = root.leftBinarSearchTree;
				return root;
			}
			
			// right child is not null
			if(root.rightBinarySearchTree!=null) {
				root = root.rightBinarySearchTree;
				return root;
			}
			
			// this is leaf node
			root = null;
			return null;
		}
			
	}
	
	private BinarySearchTree getInorderSuccessor(BinarySearchTree node) {
		if(node == null)
			return null;
		if(node.leftBinarSearchTree == null) {
			return node;
		}
		return getInorderSuccessor(node.leftBinarSearchTree);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = createTree();
		System.out.println("Inorder traversal");
		bst.printInOrderTraversal();
		
		System.out.println("");
		System.out.println("Preorder traversal");
		bst.printPreOrderTraversal();
		
		System.out.println("");
		System.out.println("Postorder traversal");
		bst.printPostOrderTraversal();

		System.out.println("");
		bst = createTree();
		System.out.println("Deleting node (2) from leaf ...");
		bst.printInOrderTraversal();
		System.out.println("");
		bst.deleteNode(bst, 2);
		bst.printInOrderTraversal();

		System.out.println("");
		bst = createTree();
		System.out.println("Deleting node (3) with left child...");
		bst.printInOrderTraversal();
		System.out.println("");
		bst.deleteNode(bst, 3);
		bst.printInOrderTraversal();

		System.out.println("");
		bst = createTree();
		System.out.println("Deleting node (8) with right child ...");
		bst.insertNode(9);
		bst.printInOrderTraversal();
		System.out.println("");
		bst.deleteNode(bst, 8);
		bst.printInOrderTraversal();

		System.out.println("");
		bst = createTree();
		System.out.println("Deleting node (4) with both left and right child ...");
		bst.printInOrderTraversal();
		System.out.println("");
		bst.deleteNode(bst, 4);
		bst.printInOrderTraversal();

	}

	private static BinarySearchTree createTree() {
		BinarySearchTree bst = new BinarySearchTree(10);
		
		bst.insertNode(4);
		bst.insertNode(15);
		bst.insertNode(3);
		bst.insertNode(8);
		bst.insertNode(2);
		return bst;
	}
}
