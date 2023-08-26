package lab7;
import java.util.LinkedList;  
import java.util.Queue;
public class BinaryTree {
    BinaryNode root;
    public BinaryTree() {
        this.root = null;
    }
    void insertNode(int value) {
        BinaryNode node = new BinaryNode(value);
        if (root == null) {
            root = node;
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
                if (currentNode.left != null) {
                queue.add(currentNode.left);
            } else {
                currentNode.left = node;
                return;
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            } else {
                currentNode.right = node;
                return;
            }
        }
    }
    // Delete a node
    void delete(int deleteValue) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode nodeToDelete;
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
            if (currentNode.value == deleteValue) {
                nodeToDelete = currentNode;
                BinaryNode depestNode = getDepestNode();
                nodeToDelete.value = depestNode.value;
                deleteDepestNode(depestNode);
                break;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // get depest node
    private BinaryNode getDepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode depestNode = null;
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            depestNode = currentNode;
        }
        return depestNode;
    }
    // Delete deepest node
    private void deleteDepestNode(BinaryNode depestNode) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
            try {
                if (currentNode.left == depestNode) {
                    currentNode.left = null;
                } else if (currentNode.right == depestNode) {
                    currentNode.right = null;
                } else {
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            } catch (NullPointerException ignored) {
            }
        }
    }

    // Delete entire tree
    void deleteTree() {
        root = null;
    }

    // Print Pre Order (ROOT _ LEFT _ RIGHT)
    void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    
    // Print In Order (LEFT _ ROOT _ RIGHT)
    void printInOrder() {
        this.printInOrder(this.root);
    }

    private void printInOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    // print Post Order (LEFT _ RIGHT _ ROOT)
    void printPostOrder() {
        this.printPostOrder(this.root);
    }
    private void printPostOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Print Level Order (level 1 all, then 2 all and so on)
    void printLevelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // Search in Binary tree
    void searchNode(int searchValue) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            BinaryNode currentNode = queue.remove();
            if (currentNode.value == searchValue) {
                System.out.println("The value is found in Tree!");
                return;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println("The value is NOT there in tree!");
    }
// <--------- Node Class ----------->
class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int value) {
        this.value = value;
    }
}
    public static void main(String args[]){
    	BinaryTree bt=new BinaryTree();
    	bt.insertNode(10);
    	bt.insertNode(100);
    	bt.insertNode(20);
    	bt.insertNode(30);
    	bt.insertNode(50);
    	bt.printPreOrder();
    	//System.out.println();
    	//bt.delete(10);
    	//bt.printInOrder();
    }
}
