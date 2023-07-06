package hash;

public class HashTable {

	private SimpleLinkedList<?> buckets[];

	public HashTable() {
		this.buckets = new SimpleLinkedList<?>[3];
		for (int i = 0; i < this.buckets.length; i++) {
			this.buckets[i] = new SimpleLinkedList<Pair>();
		}
	}

	private int hash_function(int key) {
		return key % this.buckets.length;
	}

	public void put(int key, String value) {
		int b = this.hash_function(key);
		boolean flag = false;
		for (int i = 0; i < this.buckets[b].size; i++) {
			if (((Pair) this.buckets[b].get(i)).key == key) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			Pair p = new Pair(key, value);
			SimpleLinkedList<Pair> tmp = (SimpleLinkedList<Pair>) this.buckets[b];
			tmp.insert(p, this.buckets[b].size);
		}
	}

	public String get(int key) {
		int b = this.hash_function(key);
		for (int i = 0; i < this.buckets[b].size; i++) {
			Pair p = (Pair) this.buckets[b].get(i);
			if (p.key == key) {
				return p.value;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String out = "{\n";
		for (int i = 0; i < this.buckets.length; i++) {
			out += "\t" + this.buckets[i].toString() + "\n";
		}
		return out + "}";
	}

	public static void main(String[] args) {

		HashTable ht = new HashTable();
		System.out.println(ht.toString());
		ht.put(0, "a");
		System.out.println(ht.toString());
		ht.put(1, "b");
		System.out.println(ht.toString());
		ht.put(2, "c");
		System.out.println(ht.toString());
		ht.put(3, "d");
		System.out.println(ht.toString());
		ht.put(4, "e");
		System.out.println(ht.toString());
		ht.put(5, "f");
		System.out.println(ht.toString());

		System.out.println(ht.get(2));
		System.out.println(ht.get(10));

	}

}