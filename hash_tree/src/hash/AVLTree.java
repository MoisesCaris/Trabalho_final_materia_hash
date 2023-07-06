package hash;

public class AVLTree {
    private Node root;

    private class Node {
        private int key;
        private Object value;
        private int height;
        private Node left;
        private Node right;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int key, Object value) {
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node node, int key, Object value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else if (key > node.key) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public Object get(int key) {
        Node node = get(root, key);
        return (node != null) ? node.value : null;
    }

    private Node get(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        traverseInOrder(root, sb);
        return sb.toString();
    }

    private void traverseInOrder(Node node, StringBuilder sb) {
        if (node != null) {
            traverseInOrder(node.left, sb);
            sb.append(node.key).append(": ").append(node.value).append("\n");
            traverseInOrder(node.right, sb);
        }
    }
}