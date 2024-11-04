public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // In-order traversal before deletion
        System.out.print("In-order traversal before deletion: ");
        tree.inOrder();
        System.out.println();

        // Delete node with two children using max in left subtree
        tree.deleteUsingMaxInLeftSubtree(50);
        System.out.print("In-order traversal after deleting 50: ");
        tree.inOrder();
        System.out.println();

        // Pre-order traversal
        System.out.print("Pre-order traversal: ");
        tree.preOrder();
        System.out.println();

        // Post-order traversal
        System.out.print("Post-order traversal: ");
        tree.postOrder();
        System.out.println();

        // Search for elements
        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));
    }
}
