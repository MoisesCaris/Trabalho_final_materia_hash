package hash;

public class HashTable {
	private AVLTree[] buckets;

	public HashTable() {
		this.buckets = new AVLTree[3];
		for (int i = 0; i < this.buckets.length; i++) {
			this.buckets[i] = new AVLTree();
		}
	}

	private int hash_function(int key) {
		return key % this.buckets.length;
	}

	public void put(int key, String value) {
		int b = this.hash_function(key);
		AVLTree bucket = this.buckets[b];
		bucket.insert(key, value);
	}

	public String get(int key) {
		int b = this.hash_function(key);
		AVLTree bucket = this.buckets[b];
		return (String) bucket.get(key);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{\n");
		for (int i = 0; i < this.buckets.length; i++) {
			sb.append("\t").append("Bucket ").append(i).append(":\n").append(this.buckets[i].toString()).append("\n");
		}
		sb.append("}");
		return sb.toString();
	}

	public void preOrder(int bucketIndex) {
		AVLTree bucket = this.buckets[bucketIndex];
		System.out.println("Pre-Order (Bucket " + bucketIndex + "):");
		bucket.preOrder();
		System.out.println();
	}

	public void inOrder(int bucketIndex) {
		AVLTree bucket = this.buckets[bucketIndex];
		System.out.println("In-Order (Bucket " + bucketIndex + "):");
		bucket.inOrder();
		System.out.println();
	}

	public void postOrder(int bucketIndex) {
		AVLTree bucket = this.buckets[bucketIndex];
		System.out.println("Post-Order (Bucket " + bucketIndex + "):");
		bucket.postOrder();
		System.out.println();
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.put(0, "a");
		ht.put(1, "b");
		ht.put(2, "c");
		ht.put(3, "d");
		ht.put(4, "e");
		ht.put(5, "f");
		System.out.println(ht.toString());

		ht.postOrder(0);
		ht.preOrder(0);
		ht.inOrder(0);
	}
}