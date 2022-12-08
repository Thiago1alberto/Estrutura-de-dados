package br.unicap.ed1.atividade03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMultiplySinglyLinkedList {

  private SinglyLinkedList listDigits;

  @BeforeEach
  public void setUp() {
    this.listDigits = new SinglyLinkedList();

  }

  @Test
  public void test01() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 1;
    Integer[] expected = { 2, 4, 3 };
    testMultiply(times, digits, expected);

  }

  @Test
  public void test02() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 2;
    Integer[] expected = { 4, 8, 6 };
    testMultiply(times, digits, expected);

  }

  @Test
  public void test03() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 3;
    Integer[] expected = { 6, 2, 0, 1 };
    testMultiply(times, digits, expected);

  }

  @Test
  public void test04() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 4;
    Integer[] expected = { 8, 6, 3, 1 };
    testMultiply(times, digits, expected);

  }

  @Test
  public void test05() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 100;
    Integer[] expected = { 0, 0, 2, 4, 3 };
    testMultiply(times, digits, expected);

  }

  @Test
  public void test06() {
    Integer[] digits = { 2, 4, 3 };
    Integer times = 99;
    Integer[] expected = { 8, 5, 8, 3, 3 }; 
    testMultiply(times, digits, expected);
  }

  public void testMultiply(Integer times, Integer[] digits, Integer[] expected) {
    setList(digits);
    SinglyLinkedList listSum = Utils.multiply(times, listDigits);
    Integer[] actual = listSum.toArray();
    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
  }

  public void setList(Integer[] digitsAddendOne) {
    for (Integer digit : digitsAddendOne) {
      this.listDigits.addLast(digit);
    }
  }
}
