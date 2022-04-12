public class SinglyLinkedList {
    SinglyListNode head;
    int size;

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public SinglyListNode getHead() {
        if (isEmpty() == true) {
            return null;
        }
        return this.head;
    }

    public SinglyLinkedList() {
        this.head = head;
    }

    public int size() {
        size = 0;
        SinglyListNode CurrNode = head;
        while (CurrNode != null) {
            CurrNode = CurrNode.next;
            size++;
        }
        return size;
    }

    public void addFirst(Integer value) {
        SinglyListNode newNode = new SinglyListNode(value, this.head);
        head = newNode;
        size++;
    }

    public SinglyListNode search(Integer value) {
        SinglyListNode aux = this.head;
        while (aux != null) {
            if (aux.getValue() == value) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    public void addLast(Integer value) {
        SinglyListNode newTail = new SinglyListNode(value, null);
        if (isEmpty() == true) {
            this.head = newTail;
            size++;
            return;
        }
        SinglyListNode currentTail = this.head;
        while (currentTail.next != null) {
            currentTail = currentTail.next;
        }
        currentTail.next = newTail;
        size++;
    }

    public void delete(SinglyListNode nodeDelete) {
        if (this.head == nodeDelete) {
            this.head = this.head.getNext();
            return;
        }
        SinglyListNode currentTail = this.head;
        while (currentTail != null) {
            if (nodeDelete == currentTail.getNext()) {
                currentTail.setNext(currentTail.getNext().getNext());
                break;
            }
            currentTail = currentTail.getNext();
        }
    }

    public boolean isOrdered(boolean ascending) {
        if (isEmpty()) {
            return true;
        }
        SinglyListNode CurrNode = head;
        while (CurrNode.getNext() != null) {
            SinglyListNode OrderedNode = CurrNode.getNext();
            if (ascending) {
                if (CurrNode.getValue() > OrderedNode.getValue()) {
                    return false;
                }
            } else {
                if (CurrNode.getValue() < OrderedNode.getValue())
                    return false;
            }
            CurrNode = CurrNode.getNext();
        }
        return true;

    }

    public void reverse() {
        SinglyListNode currentTail = this.head;
        SinglyListNode next = null;
        SinglyListNode previous = null;

        while(currentTail !=null){
            next = currentTail.getNext();
            currentTail.setNext(previous);
            previous = currentTail;
            currentTail = next;

        }

        this.head = previous;
    }

}
