package br.unicap.ed1.atividade04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJosephusProblem {

	@Test
	public void testJosephusProblem2And7() {
		int n = 7;
		int m = 2;
		Integer[] actual = JosephusProblem.solve(m, n);
		Integer[] expected = { 1, 3, 5, 0, 4, 2, 6 };
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void testJosephusProblem4And7() {
		int n = 7;
		int m = 4;
		Integer[] actual = JosephusProblem.solve(m, n);
		Integer[] expected = { 3, 0, 5, 4, 6, 2, 1 };
		Assertions.assertArrayEquals(expected, actual);
	}
}
