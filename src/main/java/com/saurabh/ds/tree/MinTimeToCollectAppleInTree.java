package com.saurabh.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
public class MinTimeToCollectAppleInTree {

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		GenericTreeNode root = getTree(edges);
		int minTime = getMinTime(root, hasApple);
		return minTime > 0 ? minTime - 2 : minTime;
	}

	private int getMinTime(GenericTreeNode root, List<Boolean> hasApple) {
		int minTime = 0;

		if (root == null) {
			return 0;
		} else if (root.childNodes.size() == 0) {
			if (hasApple.get(root.val)) {
				return 2;
			} else {
				return 0;
			}
		} else {
			for (GenericTreeNode childNode : root.childNodes.values()) {
				int minTimeTemp = getMinTime(childNode, hasApple);
				if (minTimeTemp > 0) {
					minTime = minTime + minTimeTemp;
				} 			
			}
			if (minTime > 0) {
				minTime = minTime + 2;
			} else if (hasApple.get(root.val)) {
				minTime = 2;
			}				

		}
		return minTime;
	}

	private GenericTreeNode getTree(int[][] edges) {
		GenericTreeNode root = null;
		Map<Integer, GenericTreeNode> nodes = new HashMap<Integer, GenericTreeNode>();
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			
			GenericTreeNode node = nodes.get(edge[0]);
			if (node == null) {
				GenericTreeNode nodeEdge = nodes.get(edge[1]);
				if (nodeEdge == null) {
					root = new GenericTreeNode(edge[0]);
					nodes.put(Integer.valueOf(edge[0]), root);
					GenericTreeNode childNode = new GenericTreeNode(edge[1]);
					root.addChildNode(childNode);
					nodes.put(Integer.valueOf(edge[1]), childNode);
				} else {
					GenericTreeNode childNode = new GenericTreeNode(edge[0]);
					nodeEdge.addChildNode(childNode);
					nodes.put(Integer.valueOf(edge[0]), childNode);
				}
			} else {
				GenericTreeNode childNode = new GenericTreeNode(edge[1]);
				node.addChildNode(childNode);
				nodes.put(Integer.valueOf(edge[1]), childNode);
			}
		}
		return root;
	}

	public class GenericTreeNode {
		int val;
		Map<Integer, GenericTreeNode> childNodes;

		GenericTreeNode() {
			childNodes = new HashMap<Integer, GenericTreeNode>();
		}

		GenericTreeNode(int val) {
			this.val = val;
			childNodes = new HashMap<Integer, GenericTreeNode>();
		}

		GenericTreeNode(int val, Map<Integer, GenericTreeNode> chidNodes) {
			this.val = val;
			this.childNodes = chidNodes;
		}
		
		void addChildNode(GenericTreeNode childNode) {
			this.childNodes.put(Integer.valueOf(childNode.val), childNode);
		}

	}

	public static void main(String[] args) {
		MinTimeToCollectAppleInTree minTime = new MinTimeToCollectAppleInTree();
		minTime.testcase1();
		minTime.testcase2();
		minTime.testcase3();
		minTime.testcase4();
		minTime.testcase5();
	}

	public void testcase1() {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = new ArrayList<Boolean>();
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(true);
		hasApple.add(false);
		System.out.println("1. -->>> " + minTime(7, edges, hasApple));
	}

	public void testcase2() {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = new ArrayList<Boolean>();
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		System.out.println("2. -->>> " + minTime(7, edges, hasApple));
	}

	public void testcase3() {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = new ArrayList<Boolean>();
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(false);
		System.out.println("3. -->>> " + minTime(7, edges, hasApple));
	}

	public void testcase4() {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 4, 7 } };
		List<Boolean> hasApple = new ArrayList<Boolean>();
		hasApple.add(true);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(true);
		hasApple.add(false);
		System.out.println("4. -->>> " + minTime(8, edges, hasApple));
	}

	public void testcase5() {
		int[][] edges = {{0,2},{0,3},{1,2}};
		List<Boolean> hasApple = new ArrayList<Boolean>();
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(false);
		System.out.println("5. -->>> " + minTime(4, edges, hasApple));
	}

}
