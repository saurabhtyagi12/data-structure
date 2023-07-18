package com.saurabh.ds.string;

// https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = n;
        int prev = -1;
        int curr = 0;
        int next = 1;

        if(n==0){
            return true;
        } 
        
        if(flowerbed.length == 1){
            if(flowerbed[curr]==0 && n==1){
                return true;
            } else {
                return false;
            }
        }

        if(flowerbed[curr]==0 && flowerbed[next]==0){
            flowerbed[curr]=1;
            total--;
        }
        prev = prev + 2;
        curr = curr + 2;
        next = next + 2;

        while(curr < flowerbed.length - 1){
            if(flowerbed[prev]==0 && flowerbed[curr]==0 && flowerbed[next]==0){
                flowerbed[curr]=1;
                total--;
                prev = prev + 2;
                curr = curr + 2;
                next = next + 2;
            } else {
                prev++;
                curr++;
                next++;
            }

            if(total <= 0){
                return true;
            }
        }

        if(flowerbed[flowerbed.length - 2]==0 && flowerbed[flowerbed.length - 1]==0){
            total--;
        }

        if(total <= 0){
            return true;
        }

        return false;
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		CanPlaceFlowers cpf = new CanPlaceFlowers();
		System.out.println(cpf.canPlaceFlowers(flowerbed, 1));
	}
}