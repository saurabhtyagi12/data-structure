package com.saurabh.ds.graph;

import java.util.List;
import java.util.ArrayList;

public class AdjacencyList {
	int noOfVertices;
	List<List<Integer>> adjacencyList ;

	AdjacencyList(int noOfVertices) {
		this.noOfVertices = noOfVertices;
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
	
	public static void main(String[] args){
		AdjacencyList g = new AdjacencyList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		//g.addEdge(2, 0);
		g.addEdge(2, 3);
		
		System.out.println(g.toString());
	}
}