package br.unicap.ed1.atividade03;

public class SinglyListNode {

	private Integer value;
    private SinglyListNode next;
    
    public SinglyListNode(){
    	
    }
   
    public SinglyListNode(Integer value, SinglyListNode next){
    	this.value = value;
    	this.next = next;	
    }
    
    public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public SinglyListNode getNext() {
		return this.next;
	}

	public void setNext(SinglyListNode next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SinglyListNode) {
			SinglyListNode other = (SinglyListNode) obj;
			return this.value.equals(other.value);	
		}
		return false;
	}
	
    @Override
    public String toString() {
    	return String.valueOf(value);
    }
}
