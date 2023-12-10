
package arbolbinario;


public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insertar nodos en el árbol
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Imprimir el árbol
        System.out.println("Árbol binario de búsqueda:");
        tree.printTree();

        // Buscar un nodo
        int keyToSearch = 40;
        TreeNode searchResult = tree.search(keyToSearch);
        if (searchResult != null) {
            System.out.println("Nodo " + keyToSearch + " encontrado en el árbol.");
        } else {
            System.out.println("Nodo " + keyToSearch + " no encontrado en el árbol.");
        }

        // Recorrer el árbol en preorden
        System.out.println("Recorrido en preorden:");
        tree.preOrder();
        System.out.println();

        // Recorrer el árbol en inorden
        System.out.println("Recorrido en inorden:");
        tree.inOrder();
        System.out.println();

        // Recorrer el árbol en postorden
        System.out.println("Recorrido en postorden:");
        tree.postOrder();
        System.out.println();

        // Eliminar un nodo
        int keyToDelete = 30;
        tree.delete(keyToDelete);
        System.out.println("Árbol después de eliminar el nodo " + keyToDelete + ":");
        tree.printTree();
    }
}
