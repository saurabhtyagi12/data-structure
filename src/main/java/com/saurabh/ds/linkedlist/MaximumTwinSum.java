package com.saurabh.ds.linkedlist;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
class MaximumTwinSum {
    public int pairSum(ListNode head) {
		int n = 0;
		ListNode node = head;

		while(node!=null){
			n++;
			node = node.next;
		}

		int sum = 0;
		int max = 0;
		int[] sumArr = new int[n/2];
		node = head;
		int i = 0;

		while(i < (n/2)){
			sumArr[i] = node.val;
			i++;
			node = node.next;
		}

		i--;

		while(node!=null){
			sum = sumArr[i] + node.val;
			if(sum > max)
				max = sum;
			i--;
			node = node.next;
		}
        return max;
    }

	public static void main(String[] args) {
		// head = [1,2,3,4]
		MaximumTwinSum mts = new MaximumTwinSum();
		ListNode head4 = new ListNode(4);
		ListNode head3 = new ListNode(3, head4);
		ListNode head2 = new ListNode(2, head3);
		ListNode head = new ListNode(1, head2);
		
		print(head);		
		System.out.println(mts.pairSum(head));		

		ListNode head22 = new ListNode(2);
		ListNode head12 = new ListNode(1, head22);
		
		print(head12);		
		System.out.println(mts.pairSum(head12));		
		
		// [2,1,3,5,6,4]
		ListNode head106 = new ListNode(4);
		ListNode head105 = new ListNode(6, head106);
		ListNode head104 = new ListNode(5, head105);
		ListNode head103 = new ListNode(3, head104);
		ListNode head102 = new ListNode(1, head103);
		ListNode head10 = new ListNode(2, head102);
		
		print(head10);		
		System.out.println(mts.pairSum(head10));		
		
		// 1,2,3,4
		ListNode head404 = new ListNode(4);
		ListNode head403 = new ListNode(3, head404);
		ListNode head402 = new ListNode(2, head403);
		ListNode head40 = new ListNode(1, head402);
		
		print(head40);		
		System.out.println(mts.pairSum(head40));		

	}
	
	public static void print(ListNode head){
		System.out.print("[");
		ListNode node = head;
		while(node != null && node.next != null){
			System.out.print(node.val + " -> ");			
			node = node.next;
		}
		System.out.print(node.val);			
		System.out.print("]");
		System.out.println();
	}

}	

//  Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
