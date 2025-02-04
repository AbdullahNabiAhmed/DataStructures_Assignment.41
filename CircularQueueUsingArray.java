// Part 2: Implementing Circular Queue Using Array

class CircularQueue {
    int arr[];
    int size;
    int rear = -1;
    int front = -1;

    CircularQueue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Full Queue");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int result = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return arr[front];
    }

    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }
}

public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(1);
        q.add(2);
        q.print();
    }
}