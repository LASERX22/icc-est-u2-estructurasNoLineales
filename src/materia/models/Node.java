package materia.models;

public class Node {
    private int valor; //Valor
    private Node left; //Nodo hijo izquierdo
    private Node right; //Nodo hijo derecho
    public Node(int valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;
    }
    public int getValor() {
        return valor;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
}