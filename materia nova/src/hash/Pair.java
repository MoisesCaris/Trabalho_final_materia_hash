package hash;

public class Pair {

	public int key;
	public String value;

	public Pair() {

	}

	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "<" + key + ": " + this.value + ">";
	}

}
