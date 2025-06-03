package com.vishnu.stack;
class StackInput
{
    private int arr[];
    private int top;
    private int capacity;
 
    // Constructor to initialize the stack
    StackInput(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
 
    // Utility function to add an element `x` to the stack
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
 
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
 
    // Utility function to pop a top element from the stack
    public int pop()
    {
        // check for stack underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Removing " + peek());
 
        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }
 
    // Utility function to return the top element of the stack
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(1);
        }
 
        return -1;
    }
 
    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }
 
    // Utility function to check if the stack is empty or not
    public Boolean isEmpty()
    {
        return top == -1;               // or return size() == 0;
    }
 
    // Utility function to check if the stack is full or not
    public Boolean isFull() {
        return top == capacity - 1;     // or return size() == capacity;
    }
}
public class CustomStack {
	
	    public static void main (String[] args)
	    {
	        StackInput stackInput = new StackInput(3);
	 
	        stackInput.push(1);      // inserting 1 in the stack
	        stackInput.push(2);      // inserting 2 in the stack
	 
	        stackInput.pop();        // removing the top element (2)
	        stackInput.pop();        // removing the top element (1)
	 
	        stackInput.push(3);      // inserting 3 in the stack
	 
	        System.out.println("The top element is " + stackInput.peek());
	        System.out.println("The stack size is " + stackInput.size());
	 
	        stackInput.pop();        // removing the top element (3)
	 
	        // check if the stack is empty
	        if (stackInput.isEmpty()) {
	            System.out.println("The stack is empty");
	        }
	        else {
	            System.out.println("The stack is not empty");
	        }
	    }
	}
