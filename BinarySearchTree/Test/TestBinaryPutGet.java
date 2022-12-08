package br.unicap.ed1.atividade06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinaryPutGet {

	@Test
	public void testGetEmpty() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		
		key = 5;
		
		String actual = myBinarySearchTree.get(key);
		String expected = null;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testPutGetOneNode() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		String value; 
		
		key = 5;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		
		String actual = myBinarySearchTree.get(key);
		String expected = value;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testPutGetTwoNodes() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		String value; 
		
		key = 5;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 3;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		
		
		String actual = myBinarySearchTree.get(key);
		String expected = value;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testPutGetThreeNodesHeightOne() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		String value; 
		
		key = 5;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 3;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 8;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		String actual = myBinarySearchTree.get(key);
		String expected = value;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testPutGetFourNodesHeightTwo() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		String value; 
		
		key = 5;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 3;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 8;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 2;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		String actual = myBinarySearchTree.get(key);
		String expected = value;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testPutGetFiveNodesHeightTwo() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		Integer key; 
		String value; 
		
		key = 5;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 3;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 8;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 2;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		key = 7;
		value = "Valor" + String.valueOf(key);
		myBinarySearchTree.put(key, value);
		
		String actual = myBinarySearchTree.get(key);
		String expected = value;
		Assertions.assertEquals(expected, actual);
	}
	
	

}
