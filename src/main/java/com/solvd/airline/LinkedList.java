package main.java.com.solvd.airline;

public class LinkedList<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node<T> head;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
	
	public boolean remove(T data) {
		if (this.head == null) {
			return false;
		}
		
		if (this.head.data.equals(data)) {
			this.head = this.head.next;
			this.size--;
			return true;
		}
		
		Node<T> current = this.head;
		while (current.next != null && !current.next.data.equals(data)) {
			current = current.next;
		}
		
		if (current.next == null) {
			return false;
		}
		
		current.next = current = current.next.next;
		this.size--;
		return true;
	}
	
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	public void insert(int index, T data) {
	    if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	    }

	    Node<T> newNode = new Node<>(data);

	    if (index == 0) {
	        newNode.next = head;
	        head = newNode;
	    } else {
	        Node<T> current = head;
	        for (int i = 0; i < index - 1; i++) {
	            current = current.next;
	        }
	        newNode.next = current.next;
	        current.next = newNode;
	    }
	    size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void clear() {
		this.head = null;
		this.size = 0;
	}
}
