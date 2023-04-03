package com.atividade;

public class AVL {
    No raiz;

    public AVL() {
        this.setRaiz(null);
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void put(int chave) {
        this.setRaiz(put(this.getRaiz(), chave));
    }

    public void deletar(int chave) {
        this.setRaiz(deletar(this.getRaiz(), chave));
    }

    public int getAltura() {
        return altura(this.getRaiz());
    }

    private No put(No no, int chave) {
        if (no == null) {
            return new No(chave);
        }

        if (chave < no.getChave()) {
            no.setEsquerda(put(no.getEsquerda(), chave));
        } else if (chave > no.getChave()) {
            no.setDireita(put(no.getDireita(), chave));
        } else {
            no.setChave(chave);
        }

        return balancear(no);
    }

    private No deletar(No no, int chave) {
        if (no == null) {
            return null;
        }

        if (chave < no.getChave()) {
            no.setEsquerda(deletar(no.getEsquerda(), chave));
        } else if (chave > no.getChave()) {
            no.setDireita(deletar(no.getDireita(), chave));
        } else {
            if (no.getEsquerda() == null) {
                return no.getDireita();
            } else if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            No maxEsquerda = getMax(no.getEsquerda());
            no.setChave(maxEsquerda.getChave());
            no.setEsquerda(deletar(no.getEsquerda(), maxEsquerda.getChave()));
        }

        return balancear(no);
    }

    private No getMax(No no) {
        while (no.getDireita() != null) {
            no = no.getDireita();
        }

        return no;
    }

    private No balancear(No no) {
        if (no == null) {
            return null;
        }

        int fatorBalanceamento = altura(no.getDireita()) - altura(no.getEsquerda());

        if (fatorBalanceamento > 1) {
            if (altura(no.getDireita().getDireita()) < altura(no.getDireita().getEsquerda())) {
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento < -1) {
            if (altura(no.getEsquerda().getEsquerda()) < altura(no.getEsquerda().getDireita())) {
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            return rotacaoDireita(no);
        }

        return no;
    }

    private No rotacaoEsquerda(No no) {
        No noDireita = no.getDireita();
        No noEsquerdaDireita = noDireita.getEsquerda();
        noDireita.setEsquerda(no);
        no.setDireita(noEsquerdaDireita);
        return noDireita;
    }

    private No rotacaoDireita(No no) {
        No noEsquerda = no.getEsquerda();
        No noDireitaEsquerda = noEsquerda.getDireita();
    
        noEsquerda.setDireita(no);
        no.setEsquerda(noDireitaEsquerda);
    
        return noEsquerda;
    }
    
    public int altura(No no) {
        if (no == null) {
            return -1;
        }
    
        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());
    
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    
    
    
}
