// Part 3: Implementing Queue Using Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    Node front = null;
    Node rear = null;

    public boolean isEmpty() {
        return rear == null && front == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int result = front.data;
        if (front == rear) {
            rear = null;
        }
        front = front.next;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return front.data;
    }

    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(5);
        q.add(3);
        q.print();
    }
}
