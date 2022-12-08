package br.unicap.ed1.atividade06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinarySearchTreeSelect {
	
	@Test
	public void testSelectFirst() {
		BinarySearchTree<String, Integer> bst  = this.createBST();
		
		String actual = bst.select(0);
		String expected = "A";
		
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testSelectSecond() {
		BinarySearchTree<String, Integer> bst  = this.createBST();
		
		String actual = bst.select(1);
		String expected = "C";
		
		Assertions.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSelectLast() {
		BinarySearchTree<String, Integer> bst  = this.createBST();
		
		String actual = bst.select(bst.size() - 1);
		String expected = "X";
		
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testSelectOutOfBounds() {
		BinarySearchTree<String, Integer> bst  = this.createBST();
		
		String actual = bst.select(bst.size());
		String expected = null;
		
		Assertions.assertEquals(expected, actual);
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
