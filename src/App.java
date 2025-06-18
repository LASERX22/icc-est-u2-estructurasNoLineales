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
        System.out.println();
        if(arbol.findvalue(23)){
            System.out.println("El valor 23 se encuentra en el árbol.");
        }else {
            System.out.println("El valor 23 no se encuentra en el árbol.");
        }

        if(arbol.findvalue(77)){
            System.out.println("El valor 77 se encuentra en el árbol.");
        }else {
            System.out.println("El valor 77 no se encuentra en el árbol.");
        }
    }
}
