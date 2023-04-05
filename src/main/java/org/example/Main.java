package org.example;

public class Main {
    public static void main(String[] args) {

        ListaCircular<String> minhaLista = new ListaCircular<>();

        minhaLista.add("c0");
        minhaLista.add("c1");
        minhaLista.add("c2");
        minhaLista.add("c3");
        minhaLista.add("c4");

        System.out.println(minhaLista);

        System.out.println(minhaLista.get(0));
        System.out.println(minhaLista.get(1));
        System.out.println(minhaLista.get(10));

        minhaLista.add(4, "ci");

        for(int i = 0; i < 10; i++){
            System.out.println(minhaLista.get(i));
        }
    }
}