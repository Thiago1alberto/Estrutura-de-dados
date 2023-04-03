package com.atividade;

public class No {
    int chave;
    No esquerda;
    No direita;
    int altura;

    public No(int chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
        this.altura = altura;
    }

    public int getChave() {
        return this.chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public No getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return this.direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

