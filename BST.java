// Implementing a Binary Search Tree (BST)

public class BST {
    // Node class representing a single node in the BST
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val); // Create a new node if the current root is null
        }

        if (val < root.data) {
            root.left = insert(root.left, val); // Insert in the left subtree
        } else if (val > root.data) {
            root.right = insert(root.right, val); // Insert in the right subtree
        }

        return root;
    }

    // Display the BST using Inorder Traversal (Left -> Root -> Right)
    public static void displayInorder(Node root) {
        if (root == null) {
            return;
        }
        displayInorder(root.left);
        System.out.print(root.data + " ");
        displayInorder(root.right);
    }

    // Search for a value in the BST
    public static boolean search(Node root, int val) {
        if (root == null) {
            return false; // Value not found
        }
        if (val == root.data) {
            return true; // Value found
        }

        // Recursively search in the left or right subtree
        return (val < root.data) ? search(root.left, val) : search(root.right, val);
    }

    // Delete a value from the BST
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null; // Value not found in the tree
        }

        // Navigate to the node to be deleted
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            // Node found, handle the three cases:
            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data; // Replace with inorder successor's value
            root.right = delete(root.right, inorderSuccessor.data); // Delete the successor node
        }

        return root;
    }

    // Find the inorder successor (smallest value in the right subtree)
    private static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print all values within a given range [x, y]
    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y); // Check left subtree
            System.out.print(root.data + " ");
            printInRange(root.right, x, y); // Check right subtree
        } else if (root.data < x) {
            printInRange(root.right, x, y); // Move to the right subtree
        } else {
            printInRange(root.left, x, y); // Move to the left subtree
        }
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // Build the BST by inserting values
        for (int val : values) {
            root = insert(root, val);
        }

        // Display the BST in Inorder
        System.out.print("Inorder Traversal: ");
        displayInorder(root);
        System.out.println();

        // Print values in a specific range
        System.out.print("Values in range [6, 11]: ");
        printInRange(root, 6, 11);
        System.out.println();

        // Search for a value
        int searchValue = 10;
        System.out.println("Search for " + searchValue + ": " + (search(root, searchValue) ? "Found" : "Not Found"));

        // Delete a value and display the BST again
        int deleteValue = 5;
        System.out.println("Deleting value: " + deleteValue);
        root = delete(root, deleteValue);
        System.out.print("Inorder Traversal after deletion: ");
        displayInorder(root);
        System.out.println();
    }
}
