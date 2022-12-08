package br.unicap.ed1.atividade03;

public class Utils {
    public static SinglyLinkedList sum(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList result = new SinglyLinkedList();
        SinglyListNode currentNodeList1 = list1.getHead();
        SinglyListNode currentNodeList2 = list2.getHead();
        int carryOne = 0;

        while (currentNodeList1 != null || currentNodeList2 != null || carryOne > 0) {
            int sum = carryOne;
            if (currentNodeList1 != null) {
                sum += currentNodeList1.getValue();
                currentNodeList1 = currentNodeList1.getNext();
            }
            if (currentNodeList2 != null) {
                sum += currentNodeList2.getValue();
                currentNodeList2 = currentNodeList2.getNext();
            }

            int digit = sum % 10;
            carryOne = sum / 10;
            result.addLast(digit); //com add frist result.reverse();
        }
        return result;
    }

    public static SinglyLinkedList multiply(Integer times, SinglyLinkedList list) {
        SinglyLinkedList result = list;
        for (int i = 1; i < times; i++) {
            result = sum(result, list);
        }
        return result;
    }
}
