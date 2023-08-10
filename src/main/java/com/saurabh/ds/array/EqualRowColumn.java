package com.saurabh.ds.array;

// https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
class EqualRowColumn {
	public int equalPairs(int[][] grid) {
		int row = grid.length;
		int matchLen = row*row;
		boolean[] matchNotFound = new boolean[matchLen];
		for(int i=0; i< row; i++){
			for(int j=0; j< row; j++) {
				if(!matchNotFound[i*row + j]){
					for(int k=0; k< row; k++){
						if(grid[k][j] != grid[i][k]){
							matchNotFound[i*row + j] = true;
							if((k*row + k) > (i*row + j))
								matchNotFound[k*row + k] = true;
							break;
						}
					}
				}
			}
		}

		int cnt =0;
		for(int i=0; i< matchLen; i++){
			System.out.print(matchNotFound[i] + ", ");
			if(!matchNotFound[i])
				cnt++;
		}
		System.out.println("");
		return cnt;
	}
	
	public static void main(String[] args) {
		EqualRowColumn erc = new EqualRowColumn();
		
		int[][] grid1 = {{3,2,1},{1,7,6},{2,7,7}};
		//System.out.println(erc.equalPairs(grid1));
		
		int[][] grid2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		//System.out.println(erc.equalPairs(grid2));
		
		int[][] grid3 = {{1,5,5,5,5,19,5,18,5,1,5},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9},{19,13,13,13,13,17,13,15,13,8,13},{16,9,9,9,9,15,9,3,9,18,9},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9},{5,9,9,9,9,13,9,9,9,9,9}};
		System.out.println(erc.equalPairs(grid3));
		
	}
}