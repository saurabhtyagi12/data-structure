package com.saurabh.ds.tree;

// https://leetcode.com/problems/invert-binary-tree/
public class BinaryTreeInversion {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		if (root.left != null && root.right != null) {
			TreeNode left = root.left;
			root.left = root.right;
			root.right = left;
			invertTree(root.left);
			invertTree(root.right);
		} else if (root.left != null) {
			root.right = root.left;
			root.left = null;
			invertTree(root.right);
		} else if (root.right != null) {
			root.left = root.right;
			root.right = null;
			invertTree(root.left);
		}

		return root;
	}

	public static void main(String[] args) {
		BinaryTreeInversion bti = new BinaryTreeInversion();

		TreeNode root = new TreeNode(100);

		bti.invertTree(root);
	}
}
