package Mid;

class Mid {
    public static void main(String[] args) {
        System.out.println("Hello World");
        BinaryTree b = new BinaryTree();

        b.insert(16);
        b.insert(59);
        b.insert(6);
        b.insert(19);
        b.insert(16);
        b.insert(28);
        b.insert(33);
        b.insert(10);
        b.insert(5);
        b.insert(4);
        b.insert(47);
        b.printLevelOrder();
    }
}