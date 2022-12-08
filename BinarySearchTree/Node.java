package br.unicap.ed1.atividade06;

public class Node<Key extends Comparable<Key>, Value> {

    private Key key;
    private Value value;
    private Node<Key, Value> right;
    private Node<Key, Value> left;
    private int size;

    public Node(Key key, Value value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node<Key, Value> getRight() {
        return right;
    }

    public void setRight(Node<Key, Value> right) {
        this.right = right;
    }

    public Node<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(Node<Key, Value> left) {
        this.left = left;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "[" + key.toString() + ", " + value.toString() + "]";
    }
}
