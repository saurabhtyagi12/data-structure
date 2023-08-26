package com.saurabh.ds.linkedlist;
// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75

class RemoveMiddleElement {
	
    public ListNode deleteMiddle(ListNode head) {
		if(head.next == null)
			return null;
		
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        ListNode prev = head;
		int size = 0;
		while(fastPoint != null && fastPoint.next != null){
			size++;
			prev = slowPoint;
			slowPoint = slowPoint.next;
			fastPoint = fastPoint.next.next;
		}
		
		prev.next = slowPoint.next;
		slowPoint.next = null;
		
		return head;
    }	

	public static void main(String[] args) {
		// head = [1,2,3,4,5]
		RemoveMiddleElement rme = new RemoveMiddleElement();
		ListNode head5 = new ListNode(5);
		ListNode head4 = new ListNode(4, head5);
		ListNode head3 = new ListNode(3, head4);
		ListNode head2 = new ListNode(2, head3);
		ListNode head = new ListNode(1, head2);
		
		print(head);		
		print(rme.deleteMiddle(head));		

		ListNode head22 = new ListNode(2);
		ListNode head12 = new ListNode(1, head22);
		
		print(head12);		
		print(rme.deleteMiddle(head12));		
		
		// [1,3,4,7,1,2,6]
		ListNode head107 = new ListNode(6);
		ListNode head106 = new ListNode(2, head107);
		ListNode head105 = new ListNode(1, head106);
		ListNode head104 = new ListNode(7, head105);
		ListNode head103 = new ListNode(4, head104);
		ListNode head102 = new ListNode(3, head103);
		ListNode head10 = new ListNode(1, head102);
		
		print(head10);		
		print(rme.deleteMiddle(head10));		
		
		// 1,2,3,4
		ListNode head404 = new ListNode(4);
		ListNode head403 = new ListNode(3, head404);
		ListNode head402 = new ListNode(2, head403);
		ListNode head40 = new ListNode(1, head402);
		
		print(head40);		
		print(rme.deleteMiddle(head40));		

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
