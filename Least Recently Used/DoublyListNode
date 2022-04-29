public class DoublyListNode {
	
	private Integer key;
	private Integer value;
	private DoublyListNode next;
	private DoublyListNode previous;
	
	public DoublyListNode(Integer key, Integer value){
		this(key, value, null, null);
	}
	
	public DoublyListNode(Integer key, Integer value, DoublyListNode next, DoublyListNode previous) {
		this.key = key;
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public DoublyListNode getNext() {
		return next;
	}

	public void setNext(DoublyListNode next) {
		this.next = next;
	}

	public DoublyListNode getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(DoublyListNode previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "(" + this.key + ", " + this.value + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true;}
		if(obj instanceof DoublyListNode){
			DoublyListNode otherListNode = (DoublyListNode) obj;
			return this.value.equals(otherListNode.value);
		}
		return false;
	}
}
