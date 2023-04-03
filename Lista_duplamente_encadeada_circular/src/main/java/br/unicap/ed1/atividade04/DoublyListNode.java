package br.unicap.ed1.atividade04;

public class DoublyListNode {
    private Integer value;
    private DoublyListNode next;
    private DoublyListNode previous;

    public DoublyListNode() {

    }

    public DoublyListNode(Integer value, DoublyListNode next, DoublyListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;

    }

    public DoublyListNode(DoublyLinkedList l) {
        this.value = l.getHead().getValue();
        this.next = l.getHead().getNext();
        this.previous = l.getHead().getPrevious();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DoublyListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyListNode previous) {
        this.previous = previous;
    }

    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof DoublyListNode) {
            DoublyListNode other = (DoublyListNode) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public String toString() {

        return String.valueOf(value);
    }

}
