package fila;

public class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> ant;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	public Node<T> getAnt() {
		return ant;
	}

	public void setAnt(Node<T> ant) {
		this.ant = ant;
	}
}

