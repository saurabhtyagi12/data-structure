package com.saurabh.ds.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
	int noOfVertices;
	List<List<Integer>> adjacencyList ;
	boolean visited[] ;

	BFS(int noOfVertices) {
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
	
	public void bfs(int vertice) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertice);
		visited[vertice] = true;
		
		while(queue.size()!=0){
			int vert = queue.poll();
			
			System.out.println(vert + " ");
			
			List<Integer> matrix = adjacencyList.get(vert);
			for(int verts : matrix){
				if(!visited[verts]){
					queue.add(verts);
					visited[verts] = true;
				}
			}
		}
	}
		
	public static void main(String[] args){
		BFS g = new BFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		System.out.println(g.toString());
		g.bfs(2);
	}


}