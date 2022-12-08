package br.unicap.ed1.atividade06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBSTMinMax {
	
	@Test
	public void testMinTree() {
		BinarySearchTree<Integer, String> myBinarySearchTree = getBST();

		int expected = 2;
		int actual = myBinarySearchTree.min();
		Assertions.assertEquals(expected, actual);
	}

	
	
	@Test
	public void testMaxTree() {
		BinarySearchTree<Integer, String> myBinarySearchTree = getBST();

		int expected = 8;
		int actual = myBinarySearchTree.max();
		Assertions.assertEquals(expected, actual);
	}
	
	private BinarySearchTree<Integer, String> getBST() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		int[] keys = {5,3,8,2,7};
		for(int key : keys) {
			myBinarySearchTree.put(key, String.valueOf(key));	
		}
		return myBinarySearchTree;
	}
}
