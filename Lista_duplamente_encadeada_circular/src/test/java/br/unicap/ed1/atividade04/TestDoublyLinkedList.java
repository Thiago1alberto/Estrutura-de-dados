package br.unicap.ed1.atividade04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDoublyLinkedList 
{
	@Test
    public void test01EmptyTrue()
    {
        DoublyLinkedList l = new DoublyLinkedList();
        Assertions.assertTrue(l.isEmpty());
    }
	
	@Test
    public void testEmptyFalse()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        l.addFirst(0);
        Assertions.assertTrue(!l.isEmpty());
    }
	
	@Test
    public void test02AddFirst()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addFirst(i);
        }
        
        DoublyListNode node = l.getTail();
        for (int expected: list_expected  ) {
        	int actual = node.getValue();
        	Assertions.assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
    }
	
	@Test
	public void test03SearchEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
        DoublyListNode expected = null;
        DoublyListNode actual = l.search(1);
        Assertions.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSearchNull() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        DoublyListNode expected = null;
        DoublyListNode actual = l.search(4);
        Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test04SearchTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        DoublyListNode expected = new DoublyListNode(2, null, null);
        DoublyListNode actual = l.search(2);
        Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testSizeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
        int expected = 0;
        int actual = l.size();
        Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test05Size3() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        int expected = 3;
        int actual = l.size();
        Assertions.assertEquals(expected, actual);
	}
	
	
	@Test
    public void test06AddLast()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        
        int size = l.size();
		if(size != 3) {
			Assertions.fail();
		}
		
        int[] list_expected_reversed = {3,2,1};
        DoublyListNode node = l.getTail();
        for (int expected: list_expected_reversed  ) {
        	int actual = node.getValue();
        	Assertions.assertEquals(expected, actual);
        	node = node.getPrevious();
        }       
    }
	
	@Test
    public void test07Reverse()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] listOriginal = {1,2,3};
        for (int i: listOriginal ) {
        	l.addLast(i);
        }
        
        
        l.reverse();
        int[] listReversed = {3,2,1};
        DoublyListNode nodeHead = l.getHead();
        DoublyListNode nodeTail = l.getTail();
        int i = 0;
        int size = l.size();
		if(size != 3) {
			Assertions.fail();
		}
		
        while (i < size) {
        	int actualHead = nodeHead.getValue();
        	Assertions.assertEquals(listReversed[i], actualHead);
        	int actualTail = nodeTail.getValue();
        	Assertions.assertEquals(listOriginal[i], actualTail);
        	nodeHead = nodeHead.getNext();
        	nodeTail = nodeTail.getPrevious();
        	i ++;
        }       
    }
	
	@Test
    public void test08ReverseOneElement()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] listOriginal = {1};
        for (int i: listOriginal ) {
        	l.addLast(i);
        }
        
        l.reverse();
        int[] listReversed = {1};
        DoublyListNode nodeHead = l.getHead();
        DoublyListNode nodeTail = l.getTail();
        int i = 0;
        int size = l.size();
        while (i < size) {
        	int actualHead = nodeHead.getValue();
        	Assertions.assertEquals(listReversed[i], actualHead);
        	int actualTail = nodeTail.getValue();
        	Assertions.assertEquals(listOriginal[i], actualTail);
        	nodeHead = nodeHead.getNext();
        	nodeTail = nodeTail.getPrevious();
        	i ++;
        }       
    }
	
	
	@Test
	public void test09IsOrderedFalseAscendingTrue() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {2,1,3};
		for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}
	

	@Test
	public void test10IsOrderedFalseAscendingFalse() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {2,1,3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test11IsOrderedTrueAscendingFalse() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {3,2,1};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test12IsOrderedTrueAscendingTrue() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {1,2, 3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test13IsOrderedEmptyAscendingTrue()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test14DeleteBeforeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        DoublyListNode nodeDelete = l.search(1);
        Assertions.assertTrue(nodeDelete != null);
        l.delete(nodeDelete);
        Assertions.assertTrue(l.isEmpty());

        
	}
	
	@Test
	public void test15DeleteFirstElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        DoublyListNode nodeDelete = l.search(1);
        int[] listAfterDelete = {3,2};
        l.delete(nodeDelete);
        DoublyListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getValue();
        	Assertions.assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
	}
	
	@Test
	public void test16DeleteLastElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        DoublyListNode nodeDelete = l.search(3);
        int[] listAfterDelete = {2,1};
        l.delete(nodeDelete);
        DoublyListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getValue();
        	Assertions.assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
	}
	
	@Test
	public void test17DeleteMiddleElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        DoublyListNode nodeDelete = l.search(2);
        int[] listAfterDelete = {3,1};
        l.delete(nodeDelete);
        DoublyListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getValue();
        	Assertions.assertEquals(expected, actual);
        	node = node.getPrevious();
        }       
        
	}
	
	@Test
	public void test18DeleteThenEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		
		DoublyListNode nodeDelete;
		nodeDelete = l.search(1);
		l.delete(nodeDelete);
		
		nodeDelete = l.search(2);
		l.delete(nodeDelete);
		
		nodeDelete = l.search(3);
		l.delete(nodeDelete);
		
		
		int size = l.size();
		if(size != 0) {
			Assertions.fail();
		}
		boolean expected = true;
		boolean actual = l.isEmpty();
		Assertions.assertEquals(expected, actual);       
	}
	
	@Test
	public void test19IsPalindromeTrue()
	{
	 	DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1, 5, 5, 1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = Utils.isPalindrome(l);
		Assertions.assertTrue(result);
	}
	
	@Test
	public void test20IsPalindromeFalse()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1, 5, 4, 1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = Utils.isPalindrome(l);
		Assertions.assertTrue(!result);
	}
	
	@Test
	public void test21IsPalindromeUnit()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = Utils.isPalindrome(l);
		Assertions.assertTrue(result);
	}
}
