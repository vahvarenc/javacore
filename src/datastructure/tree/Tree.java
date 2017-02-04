package datastructure.tree;

/**
 * This class implements a binary search tree whose
 * nodes hold objects that implement the Comparable
 * interface.
 */
public class Tree {
    /**
     * Constructs an empty tree.
     */
    public Tree() {
        root = null;
    }

    /**
     * Inserts a new node into the tree.
     *
     * @param obj the object to insert
     */
    public void insert(Comparable obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) root = newNode;
        else root.insertNode(newNode);
    }

    /**
     * Prints the contents of the tree in sorted order.
     */
    public void print() {
        if (root != null)
            root.printNodes();
    }

    private Node root;

    /**
     * A node of a tree stores a value item and references
     * of the child nodes to the left and to the right.
     */
    private class Node {
        public Comparable data;
        public Node left;
        public Node right;

        /**
         * Inserts a new node as a descendant of this node.
         *
         * @param newNode the node to insert
         */
        public void insertNode(Node newNode) {
            if (newNode.data.compareTo(data) < 0) {
                if (left == null) left = newNode;
                else left.insertNode(newNode);
            } else {
                if (right == null) right = newNode;
                else right.insertNode(newNode);
            }
        }

        /**
         * Prints this node and all of its descendants
         * in sorted order.
         */
        public void printNodes() {
            if (left != null)
                left.printNodes();
            System.out.println(data);
            if (right != null)
                right.printNodes();
        }
    }
}



