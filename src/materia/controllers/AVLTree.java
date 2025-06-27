package materia.controllers;

import java.util.LinkedList;

import materia.models.Node;

public class AVLTree {
    private Node raiz;
    private int peso;
    private LinkedList<Node> desiquilibrados;

    public AVLTree() {
        this.raiz = null;
        this.peso = 0;
        this.desiquilibrados = new LinkedList<Node>();
    }

    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
        peso++;
    }

    private Node insertRec(Node node, int valor) {
        if (node == null) {
            Node newNode = new Node(valor);
            newNode.setHeight(1);
            System.out.println("Nodo insertado ->" + valor + " con balance " + getBalance(newNode));
            return newNode; // node sera el nuevo nodo
        }
        if (valor < node.getValor()) {
            // Me voy a la izquierda si es menor
            node.setLeft(insertRec(node.getLeft(), valor));
        } else if (valor > node.getValor()) {
            // Me voy a la derecha si es mayor
            node.setRight(insertRec(node.getRight(), valor));
        } else {
            // Si el valor ya existe, no se inserta
            return node;
        }
        System.out.println("Nodo actual ->" + node.getValor());
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("Altura ->" + altura);

        int balance = getBalance(node);
        System.out.println("Balance ->" + balance);
        // IZQ-IZQ
        if (balance > 1 && valor < node.getLeft().getValor()) {
            System.out.println("Cambio");
            System.out.println("Rotacion Simple derecha");
            return rightRotation(node);
        }
        // DER-DER
        if (balance < -1 && valor > node.getRight().getValor()) {
            System.out.println("Cambio");
            System.out.println("Rotacion Simple Izquierda");
            return leftRotation(node);
        }
        // IZQ-DER
        if (balance > 1 && valor > node.getLeft().getValor()) {
            System.out.println("Cambio");
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Rotacion Simple Derecha");

            return rightRotation(node);
        }
        // DER-IZQ
        if (balance < -1 && valor < node.getRight().getValor()) {
            System.out.println("Cambio");
            node.setRight(rightRotation(node.getRight()));
            System.out.println("Rotacion izquierda");
            return leftRotation(node);
        }
        return node;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node leftRotation(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        // Print informacion pre rotacion
        System.out.println("Rotacion Izquierda en nodo: " + x.getValor() + ", con balance= " + getBalance(x));

        // Rotar
        y.setLeft(x);
        x.setRight(temp);

        // Actualizar
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Print informacion post rotacion
        System.out.println("Nueva raiza pos rotacion " + y.getValor());

        // Devolver la nueva raiz
        return y;
    }

    private Node rightRotation(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        // Print informacion pre rotacion
        System.out.println("Rotacion Derecha en nodo: " + y.getValor() + ", con balance= " + getBalance(y));

        // Rotar
        x.setRight(y);
        y.setLeft(temp);

        // Actualizar
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Print informacion post rotacion
        System.out.println("Nueva raiza pos rotacion " + x.getValor());

        // Devolver la nueva raiz
        return x;
    }

}