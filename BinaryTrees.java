import java.util.*;

// Class representing a Node in the Binary Tree
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Class containing Binary Tree operations
class BinaryTree {
    private int index = -1;

    // Building the binary tree from an array
    public Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null; // Base case: if node is -1, it's null
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes); // Recursive call for the left subtree
        newNode.right = buildTree(nodes); // Recursive call for the right subtree

        return newNode;
    }

    // Preorder traversal: Root -> Left -> Right
    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder traversal: Left -> Root -> Right
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder traversal: Left -> Right -> Root
    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level-order traversal using a queue
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Marker for the end of a level

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current == null) {
                System.out.println(); // End of the current level
                if (!queue.isEmpty()) {
                    queue.add(null); // Add marker for the next level
                }
            } else {
                System.out.print(current.data + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    // Counting the number of nodes in the tree
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // Calculating the sum of all nodes
    public int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return sumNodes(root.left) + sumNodes(root.right) + root.data;
    }

    // Calculating the height of the binary tree
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Inverting (mirroring) the binary tree
    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // Swap left and right subtrees
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}

public class BinaryTrees {
    public static void main(String[] args) {
        // Input array to build the binary tree
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Display the root data
        System.out.println("Root of the tree: " + root.data);

        // Preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preorder(root);
        System.out.println();

        // Invert the tree
        tree.invertTree(root);
        System.out.println("Tree inverted.");

        // Preorder traversal after inversion
        System.out.print("Preorder traversal (after inversion): ");
        tree.preorder(root);
        System.out.println();

        // Inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inorder(root);
        System.out.println();

        // Postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postorder(root);
        System.out.println();

        // Level-order traversal
        System.out.println("Level-order traversal:");
        tree.levelOrder(root);

        // Count and sum of nodes
        System.out.println("Total nodes: " + tree.countNodes(root));
        System.out.println("Sum of all nodes: " + tree.sumNodes(root));

        // Height of the tree
        System.out.println("Height of the tree: " + tree.height(root));
    }
}
