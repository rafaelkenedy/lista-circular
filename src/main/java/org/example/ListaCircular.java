package org.example;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (isEmpty()) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void add(int index, T conteudo) {
        if (index < 0 || index > tamanhoLista)
            throw new IndexOutOfBoundsException("Índice inválido");

        No<T> novoNo = new No<>(conteudo);

        if (isEmpty()) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
        } else if (index == 0) {
            novoNo.setNoProximo(this.cabeca);
            this.cabeca = novoNo;
        } else if (index == tamanhoLista) {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        } else {
            No<T> noAuxiliar = this.cabeca;
            for (int i = 0; i < index - 1; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            novoNo.setNoProximo(noAuxiliar.getNoProximo());
            noAuxiliar.setNoProximo(novoNo);
        }

        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("Indíce maior que o tamanho da lista!");
        }
        No<T> noAauxiliar = this.cauda;
        if (index == 0) {
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        } else if (index == 1) {
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        } else {
            for (int i = 0; i < index; i++) {
                noAauxiliar = noAauxiliar.getNoProximo();
            }
            noAauxiliar.setNoProximo(noAauxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;

    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("A lista está vazia!");
        }

        if (index == 0) {
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < index; i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size() {
        return this.tamanhoLista;
    }


}
