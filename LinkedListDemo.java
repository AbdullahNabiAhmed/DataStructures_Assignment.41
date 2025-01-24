// Node class representing a single element in the linked list
class Node {
    String data;
    Node next;

    // Constructor for Node
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List implementation
class LinkedList {
    private Node head; // Head of the list
    private int size;  // Size of the list

    // Constructor for LinkedList
    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a node at the beginning of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        size++;
        newNode.next = head;
        head = newNode;
    }

    // Add a node at the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    // Print the elements of the list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    // Delete the first node of the list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty! Cannot delete.");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete the last node of the list
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty! Cannot delete.");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // Get the size of the list
    public int getSize() {
        return size;
    }

    // Search for an element in the list
    public boolean search(String key) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Clear the entire list
    public void clear() {
        head = null;
        size = 0;
        System.out.println("The list has been cleared.");
    }
}

// Main class to test the LinkedList implementation
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the list
        list.addFirst("3");
        list.addLast("5");
        list.addFirst("2");
        list.addLast("7");

        // Printing the list
        System.out.println("Current List:");
        list.printList();

        // Searching for an element
        System.out.println("Is '5' in the list? " + list.search("5"));
        System.out.println("Is '10' in the list? " + list.search("10"));

        // Deleting elements
        list.deleteFirst();
        System.out.println("After deleting the first node:");
        list.printList();

        list.deleteLast();
        System.out.println("After deleting the last node:");
        list.printList();

        // Displaying the size of the list
        System.out.println("Size of the list: " + list.getSize());

        // Clearing the list
        list.clear();
        list.printList();
    }
}
