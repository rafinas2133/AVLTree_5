public class AVLTree {

    int size;

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

     // Inorder traversal
    public void printInorder(Node node) {
        if (node != null) {   
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
        }
    }

    // Postorder traversal
    public void printPostorder(Node node) {
        if (node != null) {   
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
        }
    }

    // Level order traversal
    public void printLevelOrder() {
        int height = this.height(root);
            for (int i = 1; i <= height; i++) {
                printGivenLevel(root, i);
                if(i==height){
                    System.out.print("\nLevel Tree: "+height);
                }
            }
        }
    private void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.key + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level-1);
            printGivenLevel(node.right, level-1);
        }
    } 

}
