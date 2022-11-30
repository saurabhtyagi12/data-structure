package com.saurabh.ds.tree;

// https://leetcode.com/problems/same-tree/
public class SameTree {

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q == null)
//            return true;
//        
//        if((p == null && q!=null) || (p!=null && q == null)){
//            return false;
//        }
//        
//        if(p.val != q.val){
//            return false;
//        }
//
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//
//    }

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			}
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		SameTree st = new SameTree();

		TreeNode p = new TreeNode(3);
		p.left = new TreeNode(9);
		p.right = new TreeNode(20);
		p.right.left = new TreeNode(15);
		p.right.right = new TreeNode(7);

		TreeNode q = new TreeNode(3);
		q.left = new TreeNode(9);
		q.right = new TreeNode(20);
		q.right.left = new TreeNode(15);
		q.right.right = new TreeNode(7);

		System.out.println(st.isSameTree(p, q));

		p.left.left = new TreeNode(2);
		System.out.println(st.isSameTree(p, q));

	}
}
