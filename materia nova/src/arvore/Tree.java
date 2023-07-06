package arvore;

public class Tree {

	private Node root;

	public void insert(int key, Object value) {
		this.root = this.insert(this.root, key, value);
		this.root = balance(this.root);
	}

	private Node insert(Node root, int key, Object value) {
		if (root == null) {
			Node node = new Node();
			node.setKey(key);
			node.setValue(value);
			return node;
		} else {
			if (key < root.getKey()) {
				root.setLeft(this.insert(root.getLeft(), key, value));
			} else if (key > root.getKey()) {
				root.setRight(this.insert(root.getRight(), key, value));
			}
		}
		return root;
	}

	private String print(Node root, int lvl) {
		String out = "";
		for (int i = 0; i < lvl; i++) {
			out += "\t";
		}
		out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
		out += "\n";
		out += (root.getLeft() != null ? print(root.getLeft(), lvl + 1) : "");
		out += (root.getRight() != null ? print(root.getRight(), lvl + 1) : "");
		return out;
	}

	@Override
	public String toString() {
		return this.print(this.root, 0);
	}

	public Object get(int key) {
		return this.get(this.root, key);
	}

	private Object get(Node root, int key) {
		if (root != null) {
			if (key < root.getKey()) {
				return this.get(root.getLeft(), key);
			} else if (key > root.getKey()) {
				return this.get(root.getRight(), key);
			} else {
				return root.getValue();
			}
		}
		return null;
	}

	private Node balance(Node node) {
		if (node == null)
			return null;

		int balanceFactor = getBalanceFactor(node);

		if (balanceFactor > 1) {
			if (getBalanceFactor(node.getLeft()) < 0)
				node.setLeft(leftRotate(node.getLeft()));
			node = rightRotate(node);
		} else if (balanceFactor < -1) {
			if (getBalanceFactor(node.getRight()) > 0)
				node.setRight(rightRotate(node.getRight()));
			node = leftRotate(node);
		}

		return node;
	}

	private int getHeight(Node node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}

	private int getBalanceFactor(Node node) {
		if (node == null)
			return 0;
		return getHeight(node.getLeft()) - getHeight(node.getRight());
	}

	private Node rightRotate(Node node) {
		Node newRoot = node.getLeft();
		node.setLeft(newRoot.getRight());
		newRoot.setRight(node);
		return newRoot;
	}

	private Node leftRotate(Node node) {
		Node newRoot = node.getRight();
		node.setRight(newRoot.getLeft());
		newRoot.setLeft(node);
		return newRoot;
	}

	public void remove(int key) {
		this.root = remove(this.root, key);
		this.root = balance(this.root);
	}

	private Node remove(Node root, int key) {
		if (root == null)
			return null;

		if (key < root.getKey()) {
			root.setLeft(remove(root.getLeft(), key));
		} else if (key > root.getKey()) {
			root.setRight(remove(root.getRight(), key));
		} else {
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			} else if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				Node minNode = findMinNode(root.getRight());
				root.setKey(minNode.getKey());
				root.setValue(minNode.getValue());
				root.setRight(remove(root.getRight(), minNode.getKey()));
			}
		}

		return root;
	}

	private Node findMinNode(Node node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.getKey() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getKey() + " ");
			inOrder(node.getRight());
		}
	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}

	public static void main(String[] args) {
		Tree t = new Tree();

		t.insert(20, "20");
		t.insert(5, "5");
		t.insert(40, "40");
		t.insert(0, "0");
		t.insert(10, "10");
		t.insert(30, "30");
		t.insert(50, "50");
		System.out.println(t.toString());
		t.remove(30);
		System.out.println(t.get(0));
		System.out.println(t.toString());
		t.preOrder();
		System.out.println("\n");
		t.inOrder();
		System.out.println("\n");
		t.postOrder();
	}
}
