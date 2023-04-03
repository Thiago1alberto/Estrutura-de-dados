package br.unicap.ed1.atividade04;

public class Utils {

    public static boolean isPalindrome(DoublyLinkedList l) {
        DoublyLinkedList reversList = new DoublyLinkedList(l);
        reversList.reverse();
        DoublyListNode realNode = l.getHead();
        DoublyListNode reversNode = reversList.getHead();
        while (realNode != null) {
            if (!realNode.equals(reversNode)) {
                return false;
            }
            realNode = realNode.getPrevious();
            reversNode = reversNode.getNext();
        }
        return true;
    }

}
