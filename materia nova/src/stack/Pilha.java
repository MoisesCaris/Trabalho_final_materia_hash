package stack;

public class Pilha<T> {
	private Node<T> top;
	private int size;

	public void push(T data) {
		Node<T> tmp = new Node<T>();
		tmp.setValue(data);
		tmp.setNext(top);
		this.top = tmp;
		this.size++;
	}

	public T pop() throws StackUnderFlowException {
		if (this.isEmpety()) {
			throw new StackUnderFlowException();
		}
		T aux = this.top.getValue();
		this.top = this.top.getNext();
		this.size--;
		return aux;
	}

	public T top() throws StackUnderFlowException {
		if (this.isEmpety()) {
			throw new StackUnderFlowException();
		}
		return this.top.getValue();
	}

	public boolean isEmpety() {
		return this.top == null;
	}

	@Override
	public String toString() {
		String out = "top -> [";
		Node<T> aux = this.top;
		while (aux != null) {
			out += aux.getValue();
			out += (aux.getNext() != null ? "," : "");
			aux = aux.getNext();
		}
		return out + "]";
	}

	public static void main(String[] args) {
		Pilha<String> s = new Pilha<String>();
		s.push("a");
		System.out.println(s.toString());
		s.push("b");
		System.out.println(s.toString());
		s.push("c");
		System.out.println(s.toString());
		s.push("d");
		System.out.println(s.toString());
		try {
			System.out.println(s.pop());
		}catch(StackUnderFlowException e) {
		e.printStackTrace();
	}
		System.out.println(s.toString());
	}
}
