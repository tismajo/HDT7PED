class BinaryTree<K extends Comparable<K>, V> {
    public class Node {
        Association<K, V> data;
        Node left;
        Node right;

        Node(Association<K, V> data) {
            this.data = data;
            left = right = null;
        }
    }

    public Node root;

    BinaryTree() {
        root = null;
    }

    public Node insertRec(Node root, Association<K, V> data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void insert(Association<K, V> data) {
        root = insertRec(root, data);
    }

    public void inOrderRec(Node root, StringBuilder output) {
        if (root != null) {
            inOrderRec(root.left, output);
            output.append(root.data.getKey()).append(": ").append(root.data.getValue()).append(" ");
            inOrderRec(root.right, output);
        }
    }
    
    public String inOrder() {
        StringBuilder output = new StringBuilder();
        inOrderRec(root, output);
        return output.toString();
    }

    public V search(K key) {
        return searchRec(root, key);
    }

    private V searchRec(Node root, K key) {
        if (root == null || key == null) {
            return null;
        }

        int compare = key.compareTo(root.data.getKey());

        if (compare == 0) {
            return root.data.getValue();
        } else if (compare < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public String translate(K key) {
        V translation = search(key);
        if (translation != null) {
            return translation.toString(); // Convertir el valor a String
        } else {
            return null;
        }
    }

    public Node getRoot() {
        return root;
    }
}