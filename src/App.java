import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree arbol = new BinaryTree();
        arbol.insert(50);
        arbol.insert(17);
        arbol.insert(76);
        arbol.insert(9);
        arbol.insert(23);
        arbol.insert(54);
        arbol.insert(14);
        arbol.insert(19);

        arbol.printPreOrder();
        System.out.println();
        arbol.printInOrder();
        System.out.println();
        arbol.printPostOrder();
    }
}
