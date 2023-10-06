package com.saurabh.ds.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean visitedRoom[] = new boolean[n];
		
		Queue<Integer> roomsQueue = new LinkedList<Integer>();
		roomsQueue.add(0);
		visitedRoom[0] = true;
		
		while(roomsQueue.size() != 0){
			int room = roomsQueue.poll();
			for(int roomsLs : rooms.get(room)) {
				if(!visitedRoom[roomsLs]){
					roomsQueue.add(roomsLs);
					visitedRoom[roomsLs] = true;
				}
			}
		}
		
		for(boolean isVisited : visitedRoom){
			if(!isVisited)
				return false;
		}
        return true;
    }
	
	public static void main(String[] args) {
		KeysAndRooms kar = new KeysAndRooms();

		// Input: rooms = [[1],[2],[3],[]]
		// Output: true
		
		List<List<Integer>> rooms1 = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		rooms1.add(l1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		rooms1.add(l2);
		List<Integer> l3 = new ArrayList<>();
		l3.add(3);
		rooms1.add(l3);
		List<Integer> l4 = new ArrayList<>();
		rooms1.add(l4);
		System.out.println("rooms1 : " + kar.canVisitAllRooms(rooms1));
		// Input: rooms = [[1,3],[3,0,1],[2],[0]]
		// Output: false

		List<List<Integer>> rooms2 = new ArrayList<List<Integer>>();
		List<Integer> l11 = new ArrayList<>();
		l11.add(1);
		l11.add(3);
		rooms2.add(l11);
		List<Integer> l12 = new ArrayList<>();
		l12.add(3);
		l12.add(0);
		l12.add(1);
		rooms2.add(l12);
		List<Integer> l13 = new ArrayList<>();
		l13.add(2);
		rooms2.add(l13);
		List<Integer> l14 = new ArrayList<>();
		l14.add(0);
		rooms2.add(l14);
		System.out.println("rooms2 : " + kar.canVisitAllRooms(rooms2));
	}
}