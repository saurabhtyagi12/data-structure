package com.saurabh.ds.linkedlist;
// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75

class ReverseLinkedlist {
    public ListNode reverseList(ListNode head) {
		ListNode node = head;
		ListNode prev = null;
		while(node!=null){
			ListNode next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
        return prev;
    }
	

	public static void main(String[] args) {
		// head = [1,2,3,4,5]
		ReverseLinkedlist rl = new ReverseLinkedlist();
		ListNode head5 = new ListNode(5);
		ListNode head4 = new ListNode(4, head5);
		ListNode head3 = new ListNode(3, head4);
		ListNode head2 = new ListNode(2, head3);
		ListNode head = new ListNode(1, head2);
		
		print(head);		
		print(rl.reverseList(head));		

		ListNode head22 = new ListNode(2);
		ListNode head12 = new ListNode(1, head22);
		
		print(head12);		
		print(rl.reverseList(head12));		

	}
	
	public static void print(ListNode head){
		System.out.print("[");
		ListNode node = head;
		while(node != null){
			System.out.print(node.val + " -> ");			
			node = node.next;
		}
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
