public class LRUCache {

	private int capacity;
	private DoublyLinkedList list;

	public LRUCache(int capacity, DoublyLinkedList list, LRUCache cache) {
		this.capacity = capacity;
		this.list = list;

	}

	public LRUCache(DoublyLinkedList list, int capacity) {
		list = new DoublyLinkedList();
		this.capacity = capacity;
	}

	public Integer get(Integer key) {
		DoublyListNode node = this.list.search(key);
		if (node != null) {
			this.updateMostRecentNode(node);
			return node.getValue();
		}
		return null;
	}

	public void set(Integer key, Integer value) {
		DoublyListNode node = this.list.search(key);
		if (node == null) {
			this.list.addFirst(key, value);
			if (this.list.size() > this.capacity) {
				this.list.delete(this.list.getTail());
			}
		} else {
			node.setValue(value);
			this.updateMostRecentNode(node);
		}
	}

	private void updateMostRecentNode(DoublyListNode node) {
		this.list.delete(node);
		this.list.addFirst(node.getKey(), node.getValue());
	}

}
