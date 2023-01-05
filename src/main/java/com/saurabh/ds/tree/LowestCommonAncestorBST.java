package com.saurabh.ds.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null )
    		return null;
    	
        if(p.val == q.val && root.val == p.val){
            return root;
        }
        
    	if(p.val < root.val && q.val < root.val) {
    		TreeNode lca = lowestCommonAncestor(root.left, p, q);
//    		if(lca!=null) {
//    			return root.val < lca.val ? root : lca;
//    		}
    		return lca;
    	} else if(p.val > root.val && q.val > root.val) {
    		TreeNode lca = lowestCommonAncestor(root.right, p, q);    		
//    		if(lca!=null) {
//    			return root.val < lca.val ? root : lca;
//    		}
    		return lca;
    	} else if(p.val < root.val && q.val > root.val) {
//    		TreeNode left = lowestCommonAncestor(root.left, p, null);    		
//    		TreeNode right = lowestCommonAncestor(root.right, null, q);
    		TreeNode left = lowestCommonAncestor(root.left, p, q);    		
    		TreeNode right = lowestCommonAncestor(root.right, p, q);
    		if(left!=null && right !=null) {
    			return root;
    		} else if(left!=null ) {
    			return root.val < left.val ? root : left;
    		} else if(right!=null ) {
    			return root.val < right.val ? root : right;
    		}
    		return null;
    	} else if(p.val > root.val && q.val < root.val) {
//    		TreeNode left = lowestCommonAncestor(root.left, null, q);    		
//    		TreeNode right = lowestCommonAncestor(root.right, p, null);
    		TreeNode left = lowestCommonAncestor(root.left, p, q);    		
    		TreeNode right = lowestCommonAncestor(root.right, p, q);
    		if(left!=null && right !=null) {
    			return root;
    		} else if(left!=null ) {
    			return root.val < left.val ? root : left;
    		} else if(right!=null ) {
    			return root.val < right.val ? root : right;
    		}
    		return null;
    	} else if(root.val == p.val || root.val == q.val){
    		return root;
    	}

        return null;        
    }
    
    public static void main(String[] args) {
		LowestCommonAncestorBST lcabst = new LowestCommonAncestorBST();
		
		TreeNode root = lcabst.testcase1();
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		System.out.println("1. ==>> " + (lcabst.lowestCommonAncestor(root, p, q)).val);

		root = lcabst.testcase2();
		p = new TreeNode(2);
		q = new TreeNode(8);
		System.out.println("2. ==>> " + (lcabst.lowestCommonAncestor(root, p, q)).val);

		root = lcabst.testcase2();
		p = new TreeNode(2);
		q = new TreeNode(4);
		System.out.println("3. ==>> " + (lcabst.lowestCommonAncestor(root, p, q)).val);

		root = lcabst.testcase2();
		p = new TreeNode(3);
		q = new TreeNode(5);
		System.out.println("4. ==>> " + (lcabst.lowestCommonAncestor(root, p, q)).val);

    }
    
    public TreeNode testcase1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
    	
		return root;
    }

    public TreeNode testcase2() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
    	
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		return root;
    }
}
