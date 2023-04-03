package br.unicap.ed1.atividade04;

public class JosephusProblem {

    public static Integer[] solve(int m, int n) {
        CircularLinkedList list = new CircularLinkedList();
        Integer[] CircleofDeath = new Integer[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        CircularListNode aux = list.getHead();
        CircularListNode eliminated;
        while (!list.isEmpty()) {

            int value = list.get(aux, m - 1);
            aux = list.search(value);
            eliminated = aux;
            aux = list.getSuccessor(aux);
            list.delete(eliminated);
            CircleofDeath[index] = value;
            index++;
        }
        return CircleofDeath;
    }
}
