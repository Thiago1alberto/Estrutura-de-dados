package br.unicap.ed1.atividade06;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeWalker<Key extends Comparable<Key>, Value> {

    private BinarySearchTree<Key, Value> tree;

    public BinaryTreeWalker(BinarySearchTree<Key, Value> tree) {
        this.tree = tree;
    }

    public List<Key> inOrder() {
        List<Key> listInOrder = new ArrayList<>();
        this.inOrder(tree.getRoot(), listInOrder);
        return listInOrder;
    }

    private void inOrder(Node<Key, Value> root, List<Key> listInOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), listInOrder);
        listInOrder.add(root.getKey());
        inOrder(root.getRight(), listInOrder);
    }

    public List<Key> preorder() {
        List<Key> listPreorder = new ArrayList<>();
        this.preorder(tree.getRoot(), listPreorder);
        return listPreorder;
    }

    private void preorder(Node<Key, Value> root, List<Key> listPreorder) {
        if (root == null) {
            return;
        }
        listPreorder.add(root.getKey());
        preorder(root.getLeft(), listPreorder);
        preorder(root.getRight(), listPreorder);
    }

    public List<Key> breadthFirst() {
        List<Key> listBreadthFirst = new ArrayList<>(); // cria a lista
        Queue<Key, Value> queue = new Queue<Key, Value>(); // cria a fila
        queue.enqueue(tree.getRoot()); // enfileira a fila
        while (!queue.isEmpty()) { // enquanto a fila não estiver vazia
            Node<Key, Value> frist = queue.dequeue(); //
            listBreadthFirst.add(frist.getKey());
            if (frist.getLeft() != null) { // caso base 
                queue.enqueue(frist.getLeft());
            }
            if (frist.getRight() != null) { // caso base 
                queue.enqueue(frist.getRight());
            }
            
        }
        return listBreadthFirst;
    }

    public List<Key> postorder() {
		List<Key> listPostOrder = new ArrayList<Key>();
		this.postorder(tree.getRoot(), listPostOrder);
		return listPostOrder;
	}

	private void postorder(Node<Key, Value> node, List<Key> listPostOrder) {
		if (node == null) {
			return;
		}
		this.postorder(node.getLeft(), listPostOrder);
		this.postorder(node.getRight(), listPostOrder);
		listPostOrder.add(node.getKey());
	}

}
