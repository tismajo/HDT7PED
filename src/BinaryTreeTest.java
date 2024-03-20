import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    @Test
    public void testInsert() {
        BinaryTree<String, String> binaryTree = new BinaryTree<>();
        binaryTree.insert(new Association<>("apple", "manzana"));
        assertEquals("manzana", binaryTree.getRoot().data.getValue());
        binaryTree.insert(new Association<>("banana", "banano"));
        if(binaryTree.getRoot().right != null)
            assertEquals("banano", binaryTree.getRoot().right.data.getValue());
        binaryTree.insert(new Association<>("cherry", "cereza"));
        if(binaryTree.getRoot().right != null && binaryTree.getRoot().right.right != null)
            assertEquals("cereza", binaryTree.getRoot().right.right.data.getValue());
    }

    @Test
    public void testSearchExisting() {
        BinaryTree<String, String> binaryTree = new BinaryTree<>();
        binaryTree.insert(new Association<>("apple", "manzana"));
        binaryTree.insert(new Association<>("banana", "banano"));
        binaryTree.insert(new Association<>("cherry", "cereza"));
        assertEquals("manzana", binaryTree.search("apple"));
        assertEquals("banano", binaryTree.search("banana"));
        assertEquals("cereza", binaryTree.search("cherry"));
    }
}
