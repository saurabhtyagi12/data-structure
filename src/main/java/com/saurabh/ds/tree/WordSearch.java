package com.saurabh.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/word-search-ii/

public class WordSearch {

    public List<String> findWords(char[][] board, String[] words) {
    	List<String> matchedWords = new ArrayList<String>();
//    	matchedWords.add("abc");
    	for(int i =0; i<board.length; i++) {
    		for(int j=0; j<board[i].length; j++) {
    			
    		}
    	}
        return matchedWords;
    }
    
    public Node getTriRootNode(char[][] board, int row, int col, Map<int, int> travseredPositions) {
    	Node root = new Node(board[row][col]);
    	
    	return root;
    }
    
    class Node {
    	char letter;
    	List<Node> childs = null;
    	
    	public Node(char letter) {
			this.letter = letter;
		}
    	
    	public void addChild(Node child){
    		if(childs == null)
    			childs = new ArrayList<Node>();

    		childs.add(child);
    	}
    	
    	public List<Node> getChilds() {
			return childs;
		}
    }
    
    public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};
		String[] words = {"eat"};
		System.out.println(new WordSearch().findWords(board, words ));
	}
    
    
    
    
    
}
