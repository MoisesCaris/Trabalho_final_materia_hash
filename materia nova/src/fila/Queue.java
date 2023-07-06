package fila;

import stack.Node;
import java.util.Stack;

public class Queue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public void reverse() {
		Stack<T> stack = new Stack<>();
		while (!isEmpty()) {
			try {
				stack.push(dequeue());
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		while (!stack.isEmpty()) {
			enqueue(stack.pop());
		}
	}

	public T dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		T aux = this.head.getValue();
		this.head = this.head.getNext();
		if (this.head == null) {
			this.tail = null;
		}
		this.size--;
		return aux;
	}

	public void enqueue(T data) {
		Node<T> tmp = new Node<T>();
		tmp.setValue(data);
		if (this.isEmpty()) {
			this.head = tmp;
		} else {
			this.tail.setNext(tmp);
		}
		this.tail = tmp;
		this.size++;
	}

	public void enqueueAll(T[] elements) {
		for (T element : elements) {
			enqueue(element);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public T head() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		return this.tail.getValue();
	}

	public String toString() {
		String out = "head -> [";
		Node<T> aux = this.head;
		while (aux != null) {
			out += aux.getValue();
			out += (aux.getNext() != null ? "," : "");
			aux = aux.getNext();
		}
		return out + "] <- tail";
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		String[] initialElements = {"a", "b", "c"};
        q.enqueueAll(initialElements);
		q.enqueue("d");
		System.out.println(q.toString());
		q.enqueue("e");
		System.out.println(q.toString());
		q.enqueue("f");
		System.out.println(q.toString());
		q.reverse();
		System.out.println(q.toString());
		try {
			System.out.println(q.dequeue());
			System.out.println(q.toString());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
