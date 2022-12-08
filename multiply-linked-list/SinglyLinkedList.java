package br.unicap.ed1.atividade03;

public class SinglyLinkedList {
	private SinglyListNode head;

	public SinglyLinkedList() {
		this.head = null;
	}

	public SinglyListNode getHead() {
		return this.head;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void addFirst(Integer value) {
		SinglyListNode newHead = new SinglyListNode(value, this.head);
		this.head = newHead;
	}

	public void addLast(Integer value) {
		SinglyListNode newTail = new SinglyListNode(value, null);
		if (this.isEmpty()) {
			this.head = newTail;
			
		}else{
			SinglyListNode oldTail = this.head;
			while (oldTail.getNext() != null) {
				oldTail = oldTail.getNext();
			}
			oldTail.setNext(newTail);
		}
	}

	public SinglyListNode search(int value) {
		SinglyListNode currentNode = this.head;
		while (currentNode != null) {
			if (currentNode.getValue().equals(value)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	public int size() {
		int size = 0;
		SinglyListNode current = this.head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	public void reverse() {
		SinglyListNode previous = this.head;
		SinglyListNode current = previous.getNext();
		while (current != null) {
			SinglyListNode next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		} 
		this.head.setNext(null);
		this.head = previous;
	}

	public boolean isOrdered(boolean ascending) {
		if (this.isEmpty() || this.size() == 1) {
			return true;
		}
		boolean result = true;
		SinglyListNode previousValue = this.head;
		SinglyListNode nextValue = previousValue.getNext();

		while (nextValue != null) {
			boolean elementsAscending = nextValue.getValue() > previousValue.getValue();
			if (ascending && !elementsAscending) {
				result = false;
				break;
			}
			if (!ascending && elementsAscending) {
				result = false;
				break;
			}
			previousValue = nextValue;
			nextValue = previousValue.getNext();
		};

		return result;
	}

	public void delete(SinglyListNode nodeDelete) {
		if(this.isEmpty()) {
			return;
		}
		if(this.head.equals(nodeDelete)) {
			this.head = this.head.getNext();
			return;
		}
//		if(this.head == nodeDelete) {
//			this.head = this.head.getNext();	
//			return;
//		}
		SinglyListNode previousNode = this.head;
		while(previousNode != null) {
//			if(previousNode.getNext() == nodeDelete) {
			if(previousNode.getNext().equals(nodeDelete)) {
//				previousNode.setNext(nodeDelete.getNext());
				previousNode.setNext(previousNode.getNext().getNext());
				break;
			}
			previousNode = previousNode.getNext();
		}
	}

	public SinglyLinkedList copy(){
		SinglyLinkedList copy = new SinglyLinkedList();
		
		SinglyListNode current = this.head;
		while(current != null){

			copy.addLast(current.getValue());
			current = current.getNext();

		}
		return copy;
	}

	public Integer[] toArray() {
		int size = this.size();
		Integer[] values = new Integer[this.size()];
		SinglyListNode currentNode = this.head;
		for(int i = 0; i < size; i++){
			values[i] = currentNode.getValue();
			currentNode = currentNode.getNext();	
		}
		return values;
	}

}
