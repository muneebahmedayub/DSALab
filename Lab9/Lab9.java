package Lab9;

public class Lab9 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        tree.insert(41);
        tree.insert(62);
        tree.insert(42);

        tree.print2D();
    }
}
