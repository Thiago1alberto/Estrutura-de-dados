package com.atividade;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Testes {

  @Test
  public void nula(){
    AVL avl = new AVL();
    avl.put(1);
    avl.deletar(1);

    No expected = null;
    No actual = avl.raiz;

    assertEquals(expected, actual);
  }

  @Test
  public void LLsimples(){
    AVL avl = new AVL();
    avl.put(5);
    avl.put(4);
    avl.put(3);

    Integer[] expected = {Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(5)};
    Integer[] actual = {avl.raiz.chave, avl.raiz.esquerda.chave, avl.raiz.direita.chave};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void RRsimples(){
    AVL avl = new AVL();
    avl.put(1);
    avl.put(2);
    avl.put(3);

    Integer[] expected = {Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3)};
    Integer[] actual = {avl.raiz.chave, avl.raiz.esquerda.chave, avl.raiz.direita.chave};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void RLsimples(){
    AVL avl = new AVL();
    avl.put(100);
    avl.put(150);
    avl.put(120);

    Integer[] expected = {Integer.valueOf(120), Integer.valueOf(100), Integer.valueOf(150)};
    Integer[] actual = {avl.raiz.chave, avl.raiz.esquerda.chave, avl.raiz.direita.chave};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void LRsimples(){
    AVL avl = new AVL();
    avl.put(100);
    avl.put(50);
    avl.put(80);

    Integer[] expected = {Integer.valueOf(80), Integer.valueOf(50), Integer.valueOf(100)};
    Integer[] actual = {avl.raiz.chave, avl.raiz.esquerda.chave, avl.raiz.direita.chave};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void altura(){
    AVL avl = new AVL();
    avl.put(63);

    avl.put(27);
    avl.put(85);

    avl.put(15);
    avl.put(34);
    avl.put(81);
    avl.put(97);

    avl.put(5);
    avl.put(19);
    avl.put(30);
    avl.put(45);
    avl.put(90);
    avl.put(99);

    avl.put(3);

    int actual = avl.raiz.altura;
    int expected = 4;

    assertEquals(expected, actual);
  }

  @Test
  public void rotacao01(){
    AVL avl = new AVL();
    avl.put(63);

    avl.put(27);
    avl.put(85);

    avl.put(15);
    avl.put(34);
    avl.put(81);
    avl.put(97);

    avl.put(5);
    avl.put(19);
    avl.put(30);
    avl.put(45);
    avl.put(90);
    avl.put(99);

    avl.deletar(85);

    Integer[] expected = {Integer.valueOf(97), Integer.valueOf(81), Integer.valueOf(99)};
    No no = avl.raiz.direita;
    Integer[] actual = {no.chave, no.esquerda.chave, no.direita.chave};
    assertArrayEquals(expected, actual);
  }

}
