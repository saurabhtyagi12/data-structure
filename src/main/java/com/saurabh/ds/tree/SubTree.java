package com.saurabh.ds.tree;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubTree {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root != null && subRoot != null) {
			boolean isMatchFound = false;
			if (root.val == subRoot.val) {
				isMatchFound = compareSubtree(root.left, subRoot.left) && compareSubtree(root.right, subRoot.right);
			}

			if (isMatchFound)
				return isMatchFound;

			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}

		if (root == null && subRoot == null) {
			return true;
		}

		return false;
	}

	public boolean compareSubtree(TreeNode root, TreeNode subRoot) {
		if (root != null && subRoot != null) {
			if (root.val == subRoot.val) {
				return compareSubtree(root.left, subRoot.left) && compareSubtree(root.right, subRoot.right);
			}
			return false;
		}

		if (root == null && subRoot == null) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		SubTree st = new SubTree();

		TreeNode p = new TreeNode(3);
		p.left = new TreeNode(9);
		p.right = new TreeNode(20);
		p.right.left = new TreeNode(15);
		p.right.right = new TreeNode(7);

		TreeNode q = new TreeNode(20);
		q.left = new TreeNode(15);
		q.right = new TreeNode(7);

		System.out.println(st.isSubtree(p, q));

		p.right.left.right = new TreeNode(2);
		System.out.println(st.isSubtree(p, q));
	}
}
