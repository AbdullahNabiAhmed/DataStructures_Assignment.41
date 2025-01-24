// Implementing a stack using ArrayList

import java.util.ArrayList;

class Stack {
    private ArrayList<Integer> list = new ArrayList<>();

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Push an element onto the stack
    public void push(int data) {
        list.add(data);
        System.out.println(data + " pushed to stack.");
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        int top = list.remove(list.size() - 1);
        System.out.println(top + " popped from stack.");
        return top;
    }

    // Peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1;
        }
        return list.get(list.size() - 1);
    }

    // Print and clear all elements in the stack
    public void printAndClear() {
        System.out.println("Stack elements (from top to bottom):");
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Popping one element
        stack.pop();

        // Print and clear the stack
        stack.printAndClear();
    }
}
