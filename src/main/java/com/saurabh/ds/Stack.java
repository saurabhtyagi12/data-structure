package com.saurabh.ds;

/*
 * LIFO
 */
public class Stack {

	private int[] dataArrary;
	private int stackSize = 0;
	private int top = -1;
	
	Stack(int size){
		this.stackSize = size;
		this.dataArrary = new int[this.stackSize];
	}
	
	public void add(int item) throws Exception {
		if(this.top == this.stackSize -1) {
			System.out.println("Stack is FULL, can't add more element");
			throw new Exception("Stack is FULL");
		}
		
		this.top++;
		this.dataArrary[this.top] = item;
		
	}
	
	public int pop() throws Exception {
		if(this.top == -1) {
			System.out.println("Stack is EMPTY, can't remove element");
			throw new Exception("Stack is Empty");
		}
		
		int item = this.dataArrary[this.top];
		this.dataArrary[this.top]=0;
		
		this.top--;
		return item;
	}

	public int peek() throws Exception {
		if(this.top == -1) {
			System.out.println("Stack is EMPTY, can't remove element");
			throw new Exception("Stack is Empty");
		}
		
		return this.dataArrary[this.top];
	}

	public int itemCountSize() {
		return top +1;
	}
	
	public void printStack() {
		for(int i=top; i>=0; i--) {
			System.out.print(this.dataArrary[i] +" ");
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		try {
		stack.add(10);
		stack.add(5);
		stack.add(45);
		stack.add(2);
		stack.add(67);
		}catch (Exception e) {
			e.printStackTrace();
		}
		stack.printStack();
		
		try {
			System.out.println("Adding element to full stack");
			stack.add(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Peeking element");
		try {
			System.out.println("Stack size " + stack.itemCountSize());
			System.out.println(stack.peek());
			System.out.println("Stack size " + stack.itemCountSize());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Poping element");
		try {
			System.out.println("Stack size " + stack.itemCountSize());
			System.out.println(stack.pop());
			System.out.println("Stack size " + stack.itemCountSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
