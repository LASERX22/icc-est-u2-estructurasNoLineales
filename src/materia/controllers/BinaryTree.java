package materia.controllers;

import java.util.LinkedList;
import materia.models.Node;

public class BinaryTree {
    private Node raiz;
    private int peso;
    private LinkedList<Node> desiquilibrados;

    public BinaryTree() {
        this.raiz = null;
        this.peso=0;
        this.desiquilibrados=new LinkedList<Node>();
    }

    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
        peso++;
    }
    public int getPeso(){
        return peso;
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
    public boolean findvalue(int valor){
        return findvalueRec(raiz,valor);
    }
    public int factorEquilibro(){
        return factorEquilibroRec(raiz);
    }
    public void printInOrderh(){
        printInOrderRech(raiz);
    }
    public void printInOrderFe(){
        printInOrderRecFe(raiz);
    }
    public int getHeightTree(){
        return getHeightTreeRec(raiz);
    }
    public boolean getEquilibrado(){
        return getEquilibradoRec(raiz);
    }
    public void getDesiquilibrados(){
        for (Node nodos : desiquilibrados) {
            System.out.print(nodos.getValor()+" ");
        }
    }
    // Recursivos
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
    private void printInOrderRech(Node raiz) {
        if (raiz != null) {
            // Primero imprimir el hijo izquierdo
            printInOrderRech(raiz.getLeft());

            // Imprimir el valor del nodo actual
            System.out.print(raiz.getValor() + " (h= " + getHeightTreeRec(raiz)+ ") ");

            // Finalmente imprimir el hijo derecho
            printInOrderRech(raiz.getRight());
        }
    }
    private void printInOrderRecFe(Node raiz) {
        if (raiz != null) {
            // Primero imprimir el hijo izquierdo
            printInOrderRecFe(raiz.getLeft());

            // Imprimir el valor del nodo actual
            System.out.print(raiz.getValor() + " (bf= " + factorEquilibroRec(raiz)+ ") ");
            if (factorEquilibroRec(raiz)<-1 || factorEquilibroRec(raiz)>1) {
                desiquilibrados.add(raiz);
            }
            // Finalmente imprimir el hijo derecho
            printInOrderRecFe(raiz.getRight());
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
    private boolean findvalueRec(Node raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getValor() == valor) {
            return true; 
        }
        if (valor < raiz.getValor()) {
            return findvalueRec(raiz.getLeft(), valor);
        } else{
            return findvalueRec(raiz.getRight(), valor);
        }
    }
    private int getHeightTreeRec(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight=getHeightTreeRec(node.getLeft());
        int RightHeight=getHeightTreeRec(node.getRight());
        return (leftHeight>RightHeight)? leftHeight +1: RightHeight+1; //O Math.max(izq, der)+1
    }
    private int factorEquilibroRec(Node node){
        if(node==null){
            return 0;
        }
        return getHeightTreeRec(node.getLeft())-getHeightTreeRec(node.getRight());
    }
    private boolean getEquilibradoRec(Node node){
        if (node==null) {
            return true;
        }
        int bf=getHeightTreeRec(node.getLeft())-getHeightTreeRec(node.getRight());
        return !(bf<-1 || bf>1);
    }
}