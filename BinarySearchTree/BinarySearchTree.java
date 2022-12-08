package br.unicap.ed1.atividade06;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public Node<Key, Value> getRoot() {
        return root;
    }

    public void setRoot(Node<Key, Value> root) {
        this.root = root;
    }

    public void put(Key key, Value value) {
        this.setRoot(put(key, value, this.getRoot()));
    }

    private Node<Key, Value> put(Key key, Value value, Node<Key, Value> node) {
        if (node == null) {
            return new Node<Key, Value>(key, value, 1);
        } else {
            int cmp = key.compareTo(node.getKey());
            if (cmp < 0) {
                Node<Key, Value> leftSubTree = this.put(key, value, node.getLeft());
                node.setLeft(leftSubTree);
            } else if (cmp > 0) {
                Node<Key, Value> rigthtSubTree = this.put(key, value, node.getRight());
                node.setRight(rigthtSubTree);
            } else {
                node.setValue(value);
            }
            int newSize = 1 + size(node.getLeft()) + size(node.getRight());
            node.setSize(newSize);
            return node;
        }
    }

    public Value get(Key key) {
        return this.get(key, this.getRoot());
    }

    private Value get(Key key, Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            return this.get(key, node.getLeft());
        } else if (cmp > 0) {
            return this.get(key, node.getRight());
        } else {
            return node.getValue();
        }
    }

    public int size(Node<Key, Value> node) {
        if (node == null) {
            return 0;
        }
        return node.getSize();
    }

    public int size() {
        return this.size(this.getRoot());
    }

    public void delete(Key key) {
        this.setRoot(delete(this.getRoot(), key));
    }

    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) { // caso base
            return null;
        }
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) { // casos a esquerda
            node.setLeft(delete(node.getLeft(), key));
        } else if (cmp > 0) { // casos a direita
            node.setRight(delete(node.getRight(), key));
        } else { // com 1 folha
            if (node.getLeft() == null) {
                int newSize = 1 + size(node.getLeft()) + size(node.getRight()); //rank + 1 
                node.setSize(newSize); // libera o espaço
                return node.getRight(); // retorna a direita
            }
            if (node.getRight() == null) { // se o direito tiver vazio
                int newSize = 1 + size(node.getLeft()) + size(node.getRight()); // rank + 1 
                node.setSize(newSize); // libera o espaço
                return node.getLeft(); // retorna a esquerda
            }
            // com 2 folhas
            Node<Key, Value> delete = node;
            node = min(delete.getRight()); // successor do nó é seu min
            node.setRight(delete(delete.getRight(), node.getKey())); // sobe a folha
            node.setLeft(delete.getLeft());
        }

        int newSize = 1 + size(node.getLeft()) + size(node.getRight()); //rank + 1 
        node.setSize(newSize);
        return node;

    }

    /*
     * T ou F
     * min(node.rightSubtree) == successor(node)
     * select(node.rank) + 1 == min(node.rightSubtree)
     * successor(node) == select(node.rank) + 1
     */

    public Key min() {
        Node<Key, Value> min = this.min(this.getRoot());
        if (min == null) {
            return null;
        }
        return min.getKey();
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node;
        }
        return this.min(node.getLeft());
    }

    public Key max() {
        Node<Key, Value> max = this.max(this.getRoot());
        if (max == null) {
            return null;
        }
        return max.getKey();
    }

    private Node<Key, Value> max(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node;
        }
        return this.max(node.getRight());
    }

    public Key select(int i) {
        BinaryTreeWalker<Key, Value> treeWalker = new BinaryTreeWalker<>(this);
        List<Key> selectList = new ArrayList<>();
        selectList = treeWalker.inOrder();
        if (i == selectList.size()) {
            return null;
        }
        return selectList.get(i);
    }

}
