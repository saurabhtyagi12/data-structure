package com.saurabh.ds.linkedlist;

// https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null)
			return head;
			
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		ListNode evenNodeList = head.next;
		while(oddNode!=null && evenNode!=null && evenNode.next!=null){
			oddNode.next = evenNode.next;
			oddNode = evenNode.next;
			evenNode.next = oddNode.next;
			evenNode = oddNode.next;
		}
		oddNode.next = evenNodeList;
        return head;
    }
	
	public static void main(String[] args) {
		// head = [1,2,3,4,5]
		OddEvenList oel = new OddEvenList();
		ListNode head5 = new ListNode(5);
		ListNode head4 = new ListNode(4, head5);
		ListNode head3 = new ListNode(3, head4);
		ListNode head2 = new ListNode(2, head3);
		ListNode head = new ListNode(1, head2);
		
		print(head);		
		print(oel.oddEvenList(head));		

		ListNode head22 = new ListNode(2);
		ListNode head12 = new ListNode(1, head22);
		
		print(head12);		
		print(oel.oddEvenList(head12));		
		
		// [2,1,3,5,6,4,7]
		ListNode head107 = new ListNode(7);
		ListNode head106 = new ListNode(4, head107);
		ListNode head105 = new ListNode(6, head106);
		ListNode head104 = new ListNode(5, head105);
		ListNode head103 = new ListNode(3, head104);
		ListNode head102 = new ListNode(1, head103);
		ListNode head10 = new ListNode(2, head102);
		
		print(head10);		
		print(oel.oddEvenList(head10));		
		
		// 1,2,3,4
		ListNode head404 = new ListNode(4);
		ListNode head403 = new ListNode(3, head404);
		ListNode head402 = new ListNode(2, head403);
		ListNode head40 = new ListNode(1, head402);
		
		print(head40);		
		print(oel.oddEvenList(head40));		

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
