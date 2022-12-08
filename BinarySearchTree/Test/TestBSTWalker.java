package br.unicap.ed1.atividade06;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBSTWalker {

	@Test
	public void testInOrder() {
		BinarySearchTree<String, Integer> bst = createBST();
		
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<String, Integer>(bst);
		
		List<String> actual = walker.inOrder();
		String[] expected = {"A","C","E","H","M","R","S","X"};

		Assertions.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testPreOrder() {
		BinarySearchTree<String, Integer> bst = createBST();
		
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<String, Integer>(bst);
		
		List<String> actual = walker.preorder();
		
		String[] expected = {"S","E","A","C","R","H","M","X"};

		Assertions.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testPostOrder() {
		BinarySearchTree<String, Integer> bst = createBST();
		
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<String, Integer>(bst);
		
		List<String> actual = walker.postorder();
		
		String[] expected = {"C","A","M","H","R","E","X","S"};

		Assertions.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testBreadthFirst() {
		BinarySearchTree<String, Integer> bst = createBST();
		
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<String, Integer>(bst);
		
		List<String> actual = walker.breadthFirst();
		
		String[] expected = {"S","E","X","A","R","C","H","M"};

		Assertions.assertArrayEquals(expected, actual.toArray());
	}

	private BinarySearchTree<String, Integer> createBST() {
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		bst.put("S", 1);

		bst.put("X", 2);
		bst.put("E", 3);
		
		bst.put("A", 4);
		bst.put("R", 5);
		
		bst.put("C", 6);
		bst.put("H", 7);
		
		bst.put("M", 8);
		return bst;
	}
	
	
	
}
