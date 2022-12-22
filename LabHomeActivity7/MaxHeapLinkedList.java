package LabHomeActivity7;
import java.util.LinkedList;
import java.util.Queue;

//MaxHeap using linkedList ...
public class MaxHeapLinkedList {
    private static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (current.left == null) {
                    current.left = newNode;
                    newNode.parent = current;
                    maxHeapify(newNode);
                    break;
                } else if (current.right == null) {
                    current.right = newNode;
                    newNode.parent = current;
                    maxHeapify(newNode);
                    break;
                } else {
                    current = current.left;
                }
            }
        }
        size++;
    }

    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value + "  ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }

        }

    }

    public void displayHeap() {
        if (isMaxHeap(root)) {
            System.out.println("The heap is a max heap.");
        } else {
            System.out.println("The heap is not a max heap.");
        }
    }

    private boolean isMaxHeap(Node node) {
        if (node == null)
            return true;
        if (node.left != null && node.value < node.left.value)
            return false;
        if (node.right != null && node.value < node.right.value)
            return false;
        return isMaxHeap(node.left) && isMaxHeap(node.right);
    }

    private void maxHeapify(Node node) {
        while (node != root && node.value > node.parent.value) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    private void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        System.out.print(node.value + " ");
        print(node.right);
    }

}