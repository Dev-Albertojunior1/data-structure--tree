

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert a new value into the binary tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // In-order traversal (prints elements in sorted order)
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal (prints root before children)
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal (prints children before root)
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search for a value in the binary tree
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        }
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // Delete a value from the binary tree using the maximum value in the left subtree
    public void deleteUsingMaxInLeftSubtree(int data) {
        root = deleteRecUsingMaxInLeft(root, data);
    }

    //serach
    private Node deleteRecUsingMaxInLeft(Node root, int data) {
        if (root == null) {
            return root; // Caso base: árvore vazia
        }
        if (data < root.data) {
            root.left = deleteRecUsingMaxInLeft(root.left, data); // Procura na subárvore esquerda
        } else if (data > root.data) {
            root.right = deleteRecUsingMaxInLeft(root.right, data); // Procura na subárvore direita
        } else {
            // Encontramos o nó a ser deletado
            if (root.left == null) {
                return root.right; // Caso com zero ou um filho (lado direito), ele é simplesmente removido e substituído por esse filho (ou por null se não tiver filhos).
            } else if (root.right == null) {
                return root.left; // Caso com zero ou um filho (lado esquerdo)
            }

            // Caso com dois filhos: substitui pelo maior valor na subárvore esquerda
            root.data = maxValue(root.left); // Atribui o valor máximo da subárvore esquerda ao nó atual
            root.left = deleteRecUsingMaxInLeft(root.left, root.data); // Deleta o nó com o maior valor na subárvore esquerda
        }
        return root;

    }

    private int maxValue(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }
}


//                 50
//                /  \
//                30  70
//                / \    / \
//               20 40  60  80
//
//
//                          40
//                         /  \
//                       30    70
//                       /      / \
//                      20     60  80

//Considere a seguinte árvore e o desejo de excluir o nó 50 (que possui dois filhos):
//O maior valor na subárvore esquerda de 50 é 40.
//Substituímos 50 por 40 e, em seguida, excluímos 40 da subárvore esquerda.

