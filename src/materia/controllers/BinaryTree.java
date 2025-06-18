package materia.controllers;

import materia.models.Node;

public class BinaryTree {
    private Node raiz;

    public BinaryTree() {
        this.raiz = null;
    }

    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
    }

    private Node insertRec(Node padre, int valor) {
        if (padre == null) {
            return new Node(valor); // padre sera el nuevo nodo
        }

        if (valor < padre.getValor()) {
            // Me voy a la izquierda si es menor
            padre.setLeft(insertRec(padre.getLeft(), valor));
        } else if (valor > padre.getValor()) {
            // Me voy a la derecha si es mayor
            padre.setRight(insertRec(padre.getRight(), valor));
        } else {
            // Si el valor ya existe, no se inserta
            return padre;
        }
        return padre;
    }

    public void printPreOrder() {
        printPreOrderRec(raiz);
    }
    public void printInOrder() {
        printInOrderRec(raiz);
    }
    public void printPostOrder() {
        printPostOrderRec(raiz);
    }

    private void printPreOrderRec(Node raiz) {
        if (raiz != null) {
            // Imprimir el valor del nodo actual
            System.out.print(raiz.getValor() + " ");

            // Primero imprimir el hijo izquierdo
            printPreOrderRec(raiz.getLeft());

            // Finalmente imprimir el hijo derecho
            printPreOrderRec(raiz.getRight());
        }
    }

    private void printInOrderRec(Node raiz) {
        if (raiz != null) {
            // Primero imprimir el hijo izquierdo
            printInOrderRec(raiz.getLeft());

            // Imprimir el valor del nodo actual
            System.out.print(raiz.getValor() + " ");

            // Finalmente imprimir el hijo derecho
            printInOrderRec(raiz.getRight());
        }
    }

    private void printPostOrderRec(Node raiz) {
        if (raiz != null) {
            // Primero imprimir el hijo izquierdo
            printPostOrderRec(raiz.getLeft());

            // Luego imprimir el hijo derecho
            printPostOrderRec(raiz.getRight());

            // Finalmente imprimir el valor del nodo actual
            System.out.print(raiz.getValor() + " ");
        }
    }
}