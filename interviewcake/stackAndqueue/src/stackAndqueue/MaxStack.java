package stackAndqueue;

import java.util.*;
import java.lang.*;

public class MaxStack {
	Stack<Integer> newStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    
    public void push(int item) {
        newStack.push(item);
        
        if (maxStack.isEmpty()) {  
            maxStack.push(item); 
        } 
        else {
            maxStack.push(Math.max(item, maxStack.peek()));
        }
    }

    public int pop() {
        maxStack.pop();
        return newStack.pop();
    }

    public int getMax() {
        return maxStack.peek();
    }
    
	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.push(10);
		System.out.println(stack.getMax());
        stack.push(4);
        stack.push(7);
        stack.push(7);
        stack.push(8);
        stack.pop();
        System.out.println(stack.getMax());
	}

}
