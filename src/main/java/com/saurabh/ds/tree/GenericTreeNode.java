package com.saurabh.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class GenericTreeNode {
	int val;
	List<GenericTreeNode> childNodes;

	GenericTreeNode() {
		childNodes = new ArrayList<GenericTreeNode>();
	}

	GenericTreeNode(int val) {
		this.val = val;
		childNodes = new ArrayList<GenericTreeNode>();
	}

	GenericTreeNode(int val, List<GenericTreeNode> chidNodes) {
		this.val = val;
		this.childNodes = chidNodes;
	}
	
	void addChildNode(GenericTreeNode childNode) {
		this.childNodes.add(childNode);
	}
	
}
