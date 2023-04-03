package br.unicap.ed1.atividade04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCircularLinkedList {

	@Test
	public void test01EmptyTrue()
	{
		CircularLinkedList l = new CircularLinkedList();
		Assertions.assertTrue(l.isEmpty());
	}

	@Test
	public void testEmptyFalse()
	{
		CircularLinkedList l = new CircularLinkedList();
		l.addFirst(0);
		Assertions.assertTrue(!l.isEmpty());
	}

	@Test
	public void test02AddFirst()
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_expected = {1,2,3};
		for (int i: list_expected ) {
			l.addFirst(i);
		}

		CircularListNode node = l.getTail();
		int size = l.size();
		if(size != 3) {
			Assertions.fail();
		}
		for (int expected: list_expected  ) {
			int actual = node.getValue();
			Assertions.assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
	public void test03AddLast()
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_expected = {1,2,3};
		for (int i: list_expected ) {
			l.addLast(i);
		}

		int[] list_expected_reversed = {3,2,1};
		int size = l.size();
		if(size != 3) {
			Assertions.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: list_expected_reversed  ) {
			int actual = node.getValue();
			Assertions.assertEquals(expected, actual);
			node = node.getPrevious();
		}       
	}

	@Test
	public void test04Reverse()
	{
		CircularLinkedList l = new CircularLinkedList();

		int[] listOriginal = {1,2,3};
		for (int i: listOriginal ) {
			l.addLast(i);
		}

		l.reverse();
		int[] listReversed = {3,2,1};
		CircularListNode nodeHead = l.getHead();
		CircularListNode nodeTail = l.getTail();

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
	public void test05IsOrderedFalseAscendingTrue() 
	{
		CircularLinkedList l = new CircularLinkedList();
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
	public void test06IsOrderedFalseAscendingFalse() 
	{
		CircularLinkedList l = new CircularLinkedList();
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
	public void test07IsOrderedTrueAscendingFalse() 
	{
		CircularLinkedList l = new CircularLinkedList();
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
	public void test08IsOrderedTrueAscendingTrue() 
	{
		CircularLinkedList l = new CircularLinkedList();
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
	public void test09IsOrderedEmptyAscendingTrue()
	{
		CircularLinkedList l = new CircularLinkedList();

		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test10deleteBeforeEmpty() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(1);
		Assertions.assertTrue(nodeDelete != null);
		l.delete(nodeDelete);
		Assertions.assertTrue(l.isEmpty()); 
	}

	@Test
	public void test11DeleteThenEmpty() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}

		CircularListNode nodeDelete;
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
	public void test12DeleteFirstElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(1);
		int[] listAfterDelete = {3,2};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assertions.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			Assertions.assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
	public void test13DeleteLastElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(3);
		int[] listAfterDelete = {2,1};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assertions.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			Assertions.assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
	public void test14DeleteMiddleElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(2);
		int[] listAfterDelete = {3,1};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assertions.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			Assertions.assertEquals(expected, actual);
			node = node.getPrevious();
		}       
	}

	@Test
	public void test15EqualsTrue()
	{
		CircularLinkedList l1 = new CircularLinkedList();
		CircularLinkedList l2 = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			l1.addFirst(i);
			l2.addFirst(i);
		}

		boolean isEquals = l1.isEquals(l2);
		Assertions.assertTrue(isEquals);
	}

	@Test
	public void test16EqualsFalse()
	{
		CircularLinkedList l1 = new CircularLinkedList();
		CircularLinkedList l2 = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			l1.addFirst(i);
			l2.addLast(i);
		}

		boolean isEquals = l1.isEquals(l2);
		Assertions.assertFalse(isEquals);
	}

	@Test
	public void test17CopyEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();

		CircularLinkedList listCopy = listOriginal.copy();
		Assertions.assertFalse(listOriginal == listCopy);
		Assertions.assertTrue(listCopy.isEmpty());
	}


	@Test
	public void test18CopyNotEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			listOriginal.addLast(i);
		}
		CircularLinkedList listCopy = listOriginal.copy();
		Assertions.assertTrue(listOriginal != listCopy);
		CircularListNode nodeOriginal = listOriginal.getHead();
		CircularListNode nodeCopy = listCopy.getHead();
		int i =0;
		int size = listOriginal.size();

		if(size != 3) {
			Assertions.fail();
		}
		while (i < size) {
			Assertions.assertEquals(nodeOriginal.getValue(), nodeCopy.getValue());
			nodeOriginal = nodeOriginal.getNext();
			nodeCopy = nodeCopy.getNext();
			i++;
		} 
	}

	@Test
	public void test19GetEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();

		try {
			listOriginal.get(0);
			Assertions.fail("List is empty");
		} catch (Exception e) {
			Assertions.assertTrue(true);
		}

	}

	@Test
	public void test20GetNotEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			listOriginal.addLast(i);
		}

		try {
			Assertions.assertEquals(1, listOriginal.get(0));
			Assertions.assertEquals(2, listOriginal.get(1));
			Assertions.assertEquals(3, listOriginal.get(2));
			Assertions.assertEquals(1, listOriginal.get(3));
			Assertions.assertEquals(2, listOriginal.get(4));
			Assertions.assertEquals(3, listOriginal.get(5));
			Assertions.assertEquals(1, listOriginal.get(6));
			Assertions.assertEquals(2, listOriginal.get(7));
			Assertions.assertEquals(3, listOriginal.get(8));
		} catch (Exception e) {
			Assertions.fail("List not empty");
		}
	}
	
	@Test
	public void test21SuccessorNotSentinel() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3};
		for (int i: listElements ) {
			list.addLast(i);
		}
		CircularListNode currentNode = list.search(2);
		CircularListNode sucessorExpected = list.search(3);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assertions.assertEquals(sucessorExpected, sucessorActual);	
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void test22SuccessorSentinel() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3};
		for (int i: listElements ) {
			list.addLast(i);
		}
		
		CircularListNode currentNode = list.search(3);
		CircularListNode sucessorExpected = list.search(1);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assertions.assertEquals(sucessorExpected, sucessorActual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void test23SuccessorEmpty() {
		CircularLinkedList list = new CircularLinkedList();
		
		CircularListNode anyNode = new CircularListNode(0, null, null);
		try {
			 list.getSuccessor(anyNode);
			 Assertions.fail("Circular list is empty");
		} catch (Exception e) {
			
		}
	}

	@Test
	public void test24SuccessorSentinelBigList() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3,4,5,6,7,8,9,10,11};
		for (int i: listElements ) {
			list.addLast(i);
		}
		
		CircularListNode currentNode = list.search(11);
		CircularListNode sucessorExpected = list.search(1);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assertions.assertEquals(sucessorExpected, sucessorActual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}
		
	}
}
