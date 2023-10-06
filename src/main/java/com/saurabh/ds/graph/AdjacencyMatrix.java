package com.saurabh.ds.graph;

public class AdjacencyMatrix {
	int noOfVertices;
	boolean[][] adjacencyMatrix;

	AdjacencyMatrix(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjacencyMatrix = new boolean[noOfVertices][noOfVertices];
	}
	
	public void addEdge(int i, int j){
		adjacencyMatrix[i][j] = true;
		adjacencyMatrix[j][i] = true;
	}

	public void removeEdge(int i, int j){
		adjacencyMatrix[i][j] = false;
		adjacencyMatrix[j][i] = false;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< noOfVertices; i++){
			sb.append(i + ": ");
			for(boolean vert : adjacencyMatrix[i]) {
				sb.append((vert ? 1 : 0) + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		AdjacencyMatrix g = new AdjacencyMatrix(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		
		System.out.println(g.toString());
	}
}