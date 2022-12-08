package br.unicap.ed1.atividade06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinaryTreeSize {

	
	
	@Test
	public void testEmpty() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		int expected = 0;
		int actual = myBinarySearchTree.size();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testOne() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		myBinarySearchTree.put(1, "Valor1");
		int expected = 1;
		int actual = myBinarySearchTree.size();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testTwo() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		myBinarySearchTree.put(1, "Valor1");
		myBinarySearchTree.put(2, "Valor2");
		int expected = 2;
		int actual = myBinarySearchTree.size();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testN() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		int n = 10;
		for(int i = 0; i < n ; i++) {
			myBinarySearchTree.put(i, String.valueOf(i));	
		}
		int expected = n;
		int actual = myBinarySearchTree.size();
		Assertions.assertEquals(expected, actual);
	}
}
