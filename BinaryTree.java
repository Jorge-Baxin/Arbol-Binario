
package arbolbinario;

public class BinaryTree {
        TreeNode root;

    public BinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void printTree() {
        printTreeRec(root, 0);
    }

    void printTreeRec(TreeNode root, int level) {
        if (root != null) {
            printTreeRec(root.right, level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("\t");
            System.out.println(root.key);
            printTreeRec(root.left, level + 1);
        }
    }

    TreeNode search(int key) {
        return searchRec(root, key);
    }

    TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    TreeNode deleteRec(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(TreeNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}
