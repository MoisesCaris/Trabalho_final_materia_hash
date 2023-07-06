package hash;

public class SimpleLinkedList<T> {

	private Node<T> head;
	int size;

	public void insert(T value, int idx) throws IndexOutOfBoundsException {
		if (idx < 0 || idx > this.size) {
			throw new IndexOutOfBoundsException("");
		}
		Node<T> node = new Node<T>();
		node.setValue(value);
		if (idx == 0) {
			node.setNext(this.head);
			this.head = node;
		} else if (idx == this.size && this.size > 0) {
			Node<T> aux = this.head;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(node);
		} else {
			Node<T> aux = this.head;
			for (int i = 0; i < idx - 1; i++) {
				aux = aux.getNext();
			}
			node.setNext(aux.getNext());
			aux.setNext(node);
		}
		this.size++;
	}

	public T get(int idx) throws IndexOutOfBoundsException {
		if (idx < 0 || idx >= this.size) {
			throw new IndexOutOfBoundsException("");
		}
		Node<T> aux = this.head;
		for (int i = 0; i < idx; i++) {
			aux = aux.getNext();
		}
		return aux.getValue();
	}

	@Override
	public String toString() {
		String out = "[";
		Node<T> aux = this.head;
		while (aux != null) {
			out += aux.getValue().toString();
			out += (aux.getNext() != null ? ", " : "");
			aux = aux.getNext();
		}
		return out + "]";
	}
}