package lab7;
import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree {
    Node root;
    void insert(int insertionValue) {
        if (root == null) {
            root = new Node(insertionValue);
            return;
        }
        insert(root, insertionValue);
    }

    private Node insert(Node node, int nodeValue) {
        if (node == null) {
            Node newNode = new Node(nodeValue);
            return newNode;
        } else if (nodeValue > node.value) {
            node.right = insert(node.right, nodeValue);
        } else {
            node.left = insert(node.left, nodeValue);
        }
        return node;
    }

    // Search method
    void search(int value) {
        search(value, root);
    }

    private void search(int value, Node node) {
        if (node == null) {
            System.out.println("The searched value was not found in tree!");
            return;
        }
        if (value > node.value) {
            search(value, node.right);
        } else if (value < node.value) {
            search(value, node.left);
        } else {
            System.out.println("The search value " + node.value + " is present in the Tree!");
        }
    }

    // delete method
    void delete(int value) {
        DeleteNode(root, value);
    }

    private Node DeleteNode(Node node, int value) {
        if (node == null) {
            System.out.println("The node to delete was not found!");
            return null;
        }
        if (value < node.value) {
            node.left = DeleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = DeleteNode(node.right, value);
        } else {
//          <------ case 1 ----->
            if (node.left != null && node.right != null) {
                Node temp = node;
                Node minNodeFromRight = getMinimumNode(temp.right);
                temp.value = minNodeFromRight.value;
                node.right = DeleteNode(node.right, minNodeFromRight.value);
            } //          <----- case 2 ----->
            else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
//          <----- case 3 ----->     
            } else {
                node = null;
            }
        }
        return node;
    }

    private Node getMinimumNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinimumNode(node.left);
    }

    // PreOrder
    void print_PreOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // inOrder
    void print_InOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
    	if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    // postOrder
    void print_PostOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    // levelOrder
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
        
    }
    public static void main(String args[]){
    	BinarySearchTree bst=new BinarySearchTree();
    	bst.insert(14);;
    	bst.insert(10);
    	bst.insert(16);
    	bst.insert(8);
    	bst.insert(11);
    	bst.insert(15);
    	//bt.printInOrder();
    	//System.err.println();
    	bst.print_InOrder();
    	
    }
}
