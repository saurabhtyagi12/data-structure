package com.saurabh.ds.tree;

public class AvlNode {

	int data;
	int height;
	
	AvlNode left;
	AvlNode right;
	
	public AvlNode(int data) {
		this.data = data;
		this.height = 1;
		left = null;
		right = null;
	}
}
