import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Davis Catherman
 *
 */
public class BSTTest {

    /**
     * Test method for {@link BST#inOrder()}.
     */
    @Test
    public final void testInOrder() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for isEmpty & insert & find
     */
    @Test
    public final void testIsEmptyAndInsertAndFind() {
        BST bst = new BST();
        boolean actual = bst.isEmpty();
        assertTrue(actual);
        
        String[] s = { "" };
        Album a = new Album("a", "", s);
        actual = bst.find(a);
        assertFalse(actual);
        
        bst.insert(a);
        actual = bst.isEmpty();
        assertFalse(actual);

        actual = bst.find(a);
        assertFalse(actual);
    }

    /**
     * Test method for {@link BST#remove(Album)}.
     */
    @Test
    public final void testRemove() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link BST#retrieve(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testRetrieve() {
        fail("Not yet implemented"); // TODO
    }

}
