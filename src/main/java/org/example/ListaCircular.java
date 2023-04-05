package org.example;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;


    public void remove(int index){
        if(index >= this.tamanhoLista){
            throw new IndexOutOfBoundsException("Indíce maior que o tamanho da lista!");
        }
        No<T> noAauxiliar = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            for(int i = 0; i < index; i++){
                noAauxiliar = noAauxiliar.getNoProximo();
            }
            noAauxiliar.setNoProximo(noAauxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;

    }

    public T get(int index){
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
