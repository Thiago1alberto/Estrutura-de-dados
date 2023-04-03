package br.unicap.ed1.atividade04;

public class CircularLinkedList {
    private CircularListNode sentinel;
    private int size = 0;

    public CircularLinkedList() {
        this.sentinel = new CircularListNode();
        this.sentinel.setNext(sentinel);
        this.sentinel.setPrevious(sentinel);
    }

    public CircularListNode getTail() {
        return this.sentinel.getPrevious();
    }

    public CircularListNode getHead() {
        return this.sentinel.getNext();
    }

    public void setHead(CircularListNode newHead) {
        this.sentinel.setNext(newHead);
    }

    public void setTail(CircularListNode newTail) {
        this.sentinel.setPrevious(newTail);
    }

    public boolean isEmpty() {
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public int size() {
        CircularListNode node = this.getHead();
        while (node != sentinel) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    public void addFirst(Integer i) {
        CircularListNode oldHead = this.getHead();
        CircularListNode newHead = new CircularListNode(i, oldHead, this.sentinel);
        oldHead.setPrevious(newHead);
        this.setHead(newHead);

    }

    public void addLast(Integer i) {
        CircularListNode oldTail = this.getTail();
        CircularListNode newTail = new CircularListNode(i, this.sentinel, oldTail);
        oldTail.setNext(newTail);
        this.setTail(newTail);

    }

    public boolean isOrdered(boolean ascending) {
        CircularListNode currentNode = this.getHead();
        while (currentNode.getNext() != this.sentinel) {
            CircularListNode next = currentNode.getNext();
            if (ascending) {
                if (currentNode.getValue() > next.getValue()) {
                    return false;
                }
            } else {
                if (currentNode.getValue() < next.getValue()) {
                    return false;
                }
            }
            currentNode = currentNode.getNext();
        }
        return true;
    }

    public void delete(CircularListNode nodeDelete) {
        CircularListNode next = nodeDelete.getNext();
        CircularListNode previous = nodeDelete.getPrevious();
        next.setPrevious(previous);
        previous.setNext(next);

    }

    public CircularListNode search(Integer i) {
        CircularListNode currentNode = this.getHead();
        while (currentNode != sentinel) {
            if (currentNode.getValue() == i) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void reverse() {
        CircularListNode current = this.sentinel;
        do {
            CircularListNode aux = current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(aux);
            current = aux;
        } while (current != this.sentinel);

    }

    public boolean isEquals(CircularLinkedList l2) {
        if (this == l2) {
            return true;
        }
        CircularListNode current = this.getHead();
        CircularListNode auxCurrent = l2.getHead();
        int contNode = 0;
        do {
            if (current.equals(auxCurrent)) {
                contNode++;
            }
            current = current.getNext();
            auxCurrent = auxCurrent.getNext();
        } while (current != this.sentinel);

        if (contNode == this.size()) {
            return true;
        }
        return false;
    }

    /*
     * public boolean isEquals(CircularLinkedList otherList) {
     * if (otherList instanceof CircularLinkedList) {
     * CircularListNode current = this.getHead();
     * CircularListNode auxCurrent = otherList.getHead();
     * while (current != sentinel && auxCurrent != sentinel) {
     * if (!current.getValue().equals(auxCurrent.getValue())) {
     * return false;
     * }
     * current = current.getNext();
     * auxCurrent = auxCurrent.getNext();
     * }
     * }
     * return true;
     * }
     */

    public CircularLinkedList copy() {
        CircularLinkedList copyList = new CircularLinkedList();
        if (this.isEmpty()) {
            return copyList;
        }
        CircularListNode aux = this.getHead();
        do {
            copyList.addLast(aux.getValue());
            aux = aux.getNext();
        } while (aux != this.sentinel);
        return copyList;
    }

    public int get(CircularListNode currentNode, int index) {
        if (this.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < index; i++) {
            currentNode = getSuccessor(currentNode);

        }
        return currentNode.getValue();
    }

    public CircularListNode getSuccessor(CircularListNode currentNode) {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        if (currentNode == this.getTail()) {
            return this.getHead();
        }

        return currentNode.getNext();

    }

}
