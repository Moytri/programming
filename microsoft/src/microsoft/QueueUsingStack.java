package microsoft;

import java.util.Stack;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/implement-queue-using-stacks/
 *
 */
public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.push(2);
		queue.push(1);
		queue.push(3);
		System.out.println(queue.peek());
		queue.pop();
		System.out.println(queue.peek());
	}
	
	public QueueUsingStack() {
		stack1 = new Stack<>();
        stack2 = new Stack<>();
	}
	
	public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
       if (stack2.isEmpty()) {
          while(!stack1.isEmpty()) {
              stack2.push(stack1.pop());
          }  
        }
        return stack2.pop();
    }
    
    public int peek() {
      if (stack2.isEmpty()) {
          while(!stack1.isEmpty()) {
              stack2.push(stack1.pop());
          }  
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }	

}
