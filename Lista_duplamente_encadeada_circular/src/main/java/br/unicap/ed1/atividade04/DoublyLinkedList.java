package br.unicap.ed1.atividade04;

public class DoublyLinkedList {
	private DoublyListNode head;
	private DoublyListNode tail;
	private int capacity = 0;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public DoublyLinkedList(DoublyLinkedList l) {

		this.head = l.head;
		this.tail = l.tail;
		this.capacity = l.capacity;
	}

	public DoublyListNode getHead() {
		return this.head;
	}

	public DoublyListNode getTail() {
		return this.tail;
	}

	public void setHead(DoublyListNode head) {
		this.head = head;
	}

	public void setTail(DoublyListNode tail) {
		this.tail = tail;
	}

	public boolean isEmpty() {

		return (this.head == null);

	}

	public void addFirst(Integer i) {
		DoublyListNode newHead = new DoublyListNode(i, this.head, null);
		if (this.isEmpty()) {
			this.tail = newHead;
		} else {
			this.head.setPrevious(newHead);
		}
		this.head = newHead;
		this.capacity++;
	}

	public void addLast(Integer i) { // pode melhorar
		DoublyListNode newTail = new DoublyListNode(i, null, this.tail);
		if (this.isEmpty()) {
			this.head = newTail;
		} else {
			this.tail.setNext(newTail);
		}
		this.tail = newTail;
		this.capacity++;
	}

	public int size() {
		return this.capacity;
	}

	public DoublyListNode search(Integer i) {
		DoublyListNode node = this.head;
		/*
		 * boolean search = (node == null);
		 * while(!search){
		 * if (node.getValue() == i) {
		 * return node; //retorna o node
		 * }
		 * node = node.getNext();
		 * }
		 * return null;
		 * }
		 */
		while (node != null) {
			if (node.getValue() == i) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void reverse() {
		DoublyListNode current = this.head;
		DoublyListNode auxListNode = null;
		while (current != null) {
			auxListNode = current.getNext();
			current.setNext(current.getPrevious());
			current.setPrevious(auxListNode);
			current = auxListNode;
		}
		auxListNode = this.head;
		this.head = this.tail;
		this.tail = auxListNode;
	}
	/*
	 * public void reverse() {
	 * DoublyListNode current = this.head;
	 * DoublyListNode auxListNode = null;
	 * while (current != null) {
	 * DoublyListNode auxListNode = current.getNext();
	 * auxListNode = current.getNext();
	 * current.setNext(current.getPrevious());
	 * current.setPrevious(auxListNode);
	 * current = auxListNode;
	 * }
	 * DoublyListNode oldTail = this.tail;
	 * DoublyListNode oldHead = this.head;
	 * this.head = oldTail;
	 * this.tail = oldHead;
	 * }
	 */

	public boolean isOrdered(boolean ascending) {
		if (isEmpty()) {
			return true;
		}

		DoublyListNode node = this.head;
		while (node.getNext() != null) {
			if (ascending) {
				if (node.getValue() > node.getNext().getValue()) {
					return false;
				}
			}
			if (!ascending) {
				if (node.getValue() < node.getNext().getValue()) {
					return false;
				}
			}
			node = node.getNext();
		}
		return true;
	}

	public void delete(DoublyListNode nodeDelete) {
		if (nodeDelete == this.head) {
			this.head = this.head.getNext();
			if (this.head != null) {
				this.head.setPrevious(null);
			}
			this.capacity--;
			return;
		}

		if (nodeDelete == this.tail) {
			this.tail = this.tail.getPrevious();
			if (this.tail != null) {
				this.tail.setNext(null);
			}
			this.capacity--;
			return;
		}

		DoublyListNode currentNode = this.head;
		while (currentNode.getNext() != null) {
			if (currentNode.getNext() == nodeDelete) {
				currentNode.setNext(currentNode.getNext().getNext());
				currentNode.getNext().setPrevious(currentNode);
				this.capacity--;
				break;
			}
			currentNode = currentNode.getNext();
		}

	}

}
