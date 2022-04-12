public class SinglyListNode {
    SinglyListNode next;
    private Integer value;

    public SinglyListNode(Integer value, SinglyListNode next) {
        this.next = next;
        this.value = value;
    }

    public SinglyListNode getNext() {
        return next;
    }

    public void setNext(SinglyListNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SinglyListNode) {
            SinglyListNode other = (SinglyListNode) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

    public String toString() {

        return String.valueOf(this.value);
    }
}
