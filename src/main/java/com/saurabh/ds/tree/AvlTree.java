package com.saurabh.ds.tree;

public class AvlTree {

	AvlNode root;
	
	int height(AvlNode node)
	{
		if(node == null)
			return 0;
		
		return node.height;
	}
	
	int max(int left, int right) {
		return left > right ? left : right;
	}

	AvlNode rightRotate(AvlNode node) {
		if(node == null)
			return node;
		AvlNode leftChildNode = node.left;
		AvlNode rightChildNode = leftChildNode.right;
		
		leftChildNode.right = node;
		node.left = rightChildNode;
		node.height = max(height(node.left), height(node.right)) + 1;
		leftChildNode.height = max(height(leftChildNode.left), height(leftChildNode.right)) + 1;
		
		return leftChildNode;
	}
	
	AvlNode leftRotate(AvlNode node) {
		if(node == null)
			return node;
		AvlNode rightChildNode = node.right;
		AvlNode leftChildNode = rightChildNode.left;
		
		rightChildNode.left = node;
		node.right = leftChildNode;
		
		node.height = max(height(node.left), height(node.right)) + 1;
		rightChildNode.height = max(height(node.left), height(node.right)) + 1;
		
		return rightChildNode;
	}
	
	AvlNode insertNode(AvlNode node, int value) {
		if(node == null)
			return new AvlNode(value);
		
		if(value < node.data) {
			node.left = insertNode(node.left, value);
		} else if (value > node.data) {
			node.right = insertNode(node.right, value);
		} else {
			return node;
		}
		
		node.height = max(height(node.left), height(node.right)) + 1;
		
		int balanceFactor = getBalanceFactor(node);
		if(balanceFactor > 1) {
			if(value < node.left.data)
				return rightRotate(node);
			else if(value > node.left.data) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}				
		} else if(balanceFactor < -1) {
			if(value > node.right.data)
				return leftRotate(node);
			else if(value < node.right.data){
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		} 
		
		return node;
	}

	AvlNode deleteNode(AvlNode node, int value) {
		if(node == null)
			return null;
		
		if(value < node.data) {
			node.left = deleteNode(node.left, value);
		} else if(value > node.data) {
			node.right = deleteNode(node.right, value);
		} else {
			AvlNode nodeToBeDeleted = null;
			if(node.left == null && node.right == null) {
				node = null;
				return nodeToBeDeleted;
			} else if(node.left !=null && node.right !=null) {
				AvlNode successorNode = findSuccessor(node.right);
				node.data = successorNode.data;
				
				node.right = deleteNode(node.right, successorNode.data);
			} else if(node.left !=null) {
				return node.left;
			} else if(node.right!=null) {
				return node.right;
			}
		}
		
		node.height = max(height(node.left), height(node.right)) + 1;
		
		// Now rebalance the tree
		int balanceFactor = getBalanceFactor(node);
		if(balanceFactor > 1) {
			if(getBalanceFactor(node.left) >=0 ) {
				return rightRotate(node);
			} else {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		} else if (balanceFactor < -1) {
			if(getBalanceFactor(node.right) <=0) {
				return leftRotate(node);
			} else {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
			
		}
		
		return node;
	}
	
	private AvlNode findSuccessor(AvlNode node) {
		if(node == null)
			return null;
		if(node.left == null && node.right == null) {
			return node;
		} else if(node.left !=null) {
			return findSuccessor(node.left);
		} else {
			return node;			
		}
	}

	private int getBalanceFactor(AvlNode node) {
		if(node == null)
			return 0;
		return height(node.left) - height(node.right);
	}
	
	
	
	
	
	  // Print the tree
	  private void printTree(AvlNode currPtr, String indent, boolean last) {
	    if (currPtr != null) {
	      System.out.print(indent);
	      if (last) {
	        System.out.print("R----");
	        indent += "   ";
	      } else {
	        System.out.print("L----");
	        indent += "|  ";
	      }
	      System.out.println(currPtr.data);
	      printTree(currPtr.left, indent, false);
	      printTree(currPtr.right, indent, true);
	    }
	  }
	
	  // Driver code
	  public static void main(String[] args) {
	    AvlTree tree = new AvlTree();
	    tree.root = tree.insertNode(tree.root, 33);
	    tree.root = tree.insertNode(tree.root, 13);
	    tree.root = tree.insertNode(tree.root, 53);
	    tree.root = tree.insertNode(tree.root, 9);
	    tree.root = tree.insertNode(tree.root, 21);
	    tree.root = tree.insertNode(tree.root, 61);
	    tree.root = tree.insertNode(tree.root, 8);
	    tree.root = tree.insertNode(tree.root, 11);
	    tree.root = tree.insertNode(tree.root, 40);
	    tree.root = tree.insertNode(tree.root, 19);
	    tree.root = tree.insertNode(tree.root, 7);
	    tree.printTree(tree.root, "", true);
	    tree.root = tree.deleteNode(tree.root, 13);
	    System.out.println("After Deletion: ");
	    tree.printTree(tree.root, "", true);
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
