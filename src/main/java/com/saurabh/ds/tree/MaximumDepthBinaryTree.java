package com.saurabh.ds.tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return maxValue(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public int maxValue(int left, int right) {
		return left >= right ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		MaximumDepthBinaryTree mdbt = new MaximumDepthBinaryTree();
		System.out.println(mdbt.maxDepth(root));
	}
}
