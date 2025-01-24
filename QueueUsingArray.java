// Part 1: Implementing Queue Using Array

class ArrayQueue {
    int arr[];
    int size;
    int rear = -1;

    ArrayQueue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Full Queue");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return arr[0];
    }

    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
    }
}