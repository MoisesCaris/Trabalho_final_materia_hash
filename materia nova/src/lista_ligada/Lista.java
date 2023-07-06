package lista_ligada;

public class Lista<T> {
	private Node<T> head;
	private int size;

	public void insert(T value, int idx) throws IndexOutOfBoundsException {
		if (idx >= 0 && idx > this.size) {
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
			aux = aux.getNext();
		} else {
			Node<T> aux = this.head;
			for (int i = 0; i < idx; i++) {
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

	public void remove(int idx) {
		if (idx == 0) {
			this.head = this.head.getNext();
		} else {
			int i = 0;
			for (Node<T> aux = this.head; aux.getNext() != null; aux = aux.getNext()) {
				i++;
				if (i == idx) {
					aux.setNext(aux.getNext().getNext());
					break;
				}
			}

			if (i >= this.size) {
				throw new IndexOutOfBoundsException("");
			}
		}
	}

	public static void main(String[] args) {
		Lista<String> sll = new Lista<String>();
		sll.insert("aa", 0);
		sll.insert("bb", 0);
		sll.insert("cc", 0);
		sll.insert("dd", 0);
		sll.insert("ee", 0);
		System.out.println(sll.toString());
		sll.remove(4);
		System.out.println(sll.toString());
	}
}
