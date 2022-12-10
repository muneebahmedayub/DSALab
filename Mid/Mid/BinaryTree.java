package Mid;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);

        if(this.root == null) {
            this.root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(this.root);

        while(!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            
            if(temp.left != null) {
                q.add(temp.left);
            } else {
                temp.left = newNode;
                return;
            }
            if(temp.right != null) {
                q.add(temp.right);
            } else {
                temp.right = newNode;
                return;
            }
        }
    }

    public void printLevelOrder() {
        if(this.root == null) {
            System.out.println("Tree is empty");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        System.out.println();
    }
    
}
