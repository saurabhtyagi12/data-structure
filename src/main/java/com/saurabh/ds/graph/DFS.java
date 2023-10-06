package com.saurabh.ds.graph;

import java.util.List;
import java.util.ArrayList;

public class DFS {
	int noOfVertices;
	List<List<Integer>> adjacencyList ;
	boolean visited[] ;

	DFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		visited = new boolean[noOfVertices];
		
		adjacencyList = new ArrayList<List<Integer>>(noOfVertices);
		for(int i=0; i< noOfVertices; i++){
			adjacencyList.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int i, int j){
		adjacencyList.get(i).add(j);
		adjacencyList.get(j).add(i);
	}

	public void removeEdge(int i, int j){
		adjacencyList.get(i).remove(j);
		adjacencyList.get(j).remove(i);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< noOfVertices; i++){
			sb.append(i + ": ");
			for(int vert : adjacencyList.get(i)) {
				sb.append(vert + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void dfs(int vertice) {
		System.out.println(vertice + " ");
		visited[vertice] = true;
		
		List<Integer> matrix = adjacencyList.get(vertice);
		
		for(int edge : matrix){
			if(!visited[edge]){
				dfs(edge);
			}
		}
	}
		
	public static void main(String[] args){
		DFS g = new DFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		System.out.println(g.toString());
		g.dfs(2);
	}


}