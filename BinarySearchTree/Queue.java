package br.unicap.ed1.atividade06;

import java.util.ArrayList;

public class Queue<Key extends Comparable<Key>, Value>{
    
    private ArrayList<Node<Key, Value>> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public void enqueue(Node<Key, Value> node) {
        queue.add(node);
    }
        
    public Node<Key, Value> dequeue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Node<Key, Value> save = queue.get(0);
        queue.remove(queue.get(0));
        return save;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
