import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Davis
 * @version Fermium
 */
public class BSTTest {

    /**
     * 
     * @param c
     *            new album to create
     * @return newly created album
     */
    private Album newAlbum(int c) {
        switch (c) {
            case 1:
                String artist = "Davis";
                String title = "mySymphony";
                String[] songs = { "ComputerScience", "Engineering" };
                Album myAlbum = new Album(artist, title, songs);
                return myAlbum;
            case 2:
                String artist2 = "Bob";
                String title2 = "Humanities";
                String[] songs2 = { "History", "AmericanStudies" };
                Album hisAlbum = new Album(artist2, title2, songs2);
                return hisAlbum;
            case 3:
                String artist3 = "Jane";
                String title3 = "Language";
                String[] songs3 = { "English", "Spanish" };
                Album herAlbum = new Album(artist3, title3, songs3);
                return herAlbum;
            case 4:
                String artist4 = "AA";
                String title4 = "AA";
                String[] songs4 = { "AA", "AA" };
                Album finalAlbum = new Album(artist4, title4, songs4);
                return finalAlbum;
            default:
                // do nothing
        }
        return null;

    }

    /**
     * Test method for {@link BST#BST()}.
     * 
     * tests creation of new BST() and whether it is null or not.
     */
    @Test
    public final void testBST() {
        BST myBST;
        myBST = null;
        assertNull(myBST);
        myBST = new BST();
        assertNotNull(myBST);
    }

    /**
     * Test method for {@link BST#isEmpty()}.
     */
    @Test
    public final void testIsEmpty() {
        BST myBST = new BST();
        boolean actual = myBST.isEmpty();
        assertTrue(actual);
    }

    /**
     * Test method for {@link BST#insert(Album)}.
     */
    @Test
    public final void testInsert() {
        BST myBST = new BST();

        newAlbum(0);

        Album myAlbum = newAlbum(1);
        myBST.insert(myAlbum);

        boolean actual = myBST.isEmpty();
        assertFalse(actual);

        Album hisAlbum = newAlbum(2);
        myBST.insert(hisAlbum);
    }

    /**
     * Test method for {@link BST#inOrder()}.
     */
    @Test
    public final void testInOrder() {
        BST myBST = new BST();
        String actual = myBST.inOrder();
        String expected = "";
        assertEquals(expected, actual);
        Album myAlbum = newAlbum(1);
        myBST.insert(myAlbum);
        actual = myBST.inOrder();
        expected = "|DavismySymphony|";
        assertEquals(expected, actual);
        Album hisAlbum = newAlbum(2);
        myBST.insert(hisAlbum);
        actual = myBST.inOrder();
        expected = "|BobHumanities||DavismySymphony|";
        assertEquals(expected, actual);
        Album herAlbum = newAlbum(3);
        myBST.insert(herAlbum);
        actual = myBST.inOrder();
        expected = "|BobHumanities||DavismySymphony||JaneLanguage|";
        assertEquals(expected, actual);
        myBST.insert(herAlbum);
        actual = myBST.inOrder();
        expected = "|BobHumanities||DavismySymphony||JaneLanguage|";
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link BST#find(Album)}.
     */
    @Test
    public final void testFind() {
        BST myBST = new BST();
        Album myAlbum = newAlbum(1);
        assertFalse(myBST.find(myAlbum));

        myBST.insert(myAlbum);
        assertTrue(myBST.find(myAlbum));

        Album hisAlbum = newAlbum(2);
        assertFalse(myBST.find(hisAlbum));

        myBST.insert(hisAlbum);
        assertTrue(myBST.find(hisAlbum));

        Album herAlbum = newAlbum(3);
        myBST.insert(herAlbum);
        assertTrue(myBST.find(herAlbum));
    }

    /**
     * Test method for {@link BST#retrieve(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testRetrieve() {
        BST myBST = new BST();
        Album myAlbum = newAlbum(1);
        myBST.insert(myAlbum);
        Album hisAlbum = newAlbum(2);
        Album expected = hisAlbum;
        Album actual = myBST.retrieve(hisAlbum.artist(), hisAlbum.title());
        assertNotEquals(expected, actual);

        myBST.insert(hisAlbum);
        expected = hisAlbum;
        actual = myBST.retrieve(hisAlbum.artist(), hisAlbum.title());
        assertEquals(expected, actual);

        Album herAlbum = newAlbum(3);
        expected = herAlbum;
        actual = myBST.retrieve(herAlbum.artist(), herAlbum.title());
        assertNotEquals(expected, actual);
        myBST.insert(herAlbum);
        actual = myBST.retrieve(herAlbum.artist(), herAlbum.title());
        assertEquals(expected, actual);
    }

    @Test
    public final void testRemove_redone() {
        Album myAlbum = newAlbum(1);
        Album hisAlbum = newAlbum(2);
        Album herAlbum = newAlbum(3);
        Album finalAlbum = newAlbum(4);
        
        BST bst1 = new BST();
        bst1.insert(hisAlbum);
        bst1.insert(myAlbum);
        
        System.out.println(bst1.inOrder());
        bst1.remove(hisAlbum);
        System.out.println(bst1.inOrder());
        
        Assert.assertEquals("|DavismySymphony|", bst1.inOrder());
        System.out.println("---");
        
        BST bst2 = new BST();
        bst2.insert(hisAlbum);
        bst2.insert(myAlbum);
        bst2.insert(herAlbum);
        
        System.out.println(bst2.inOrder());
        bst2.remove(hisAlbum);
        System.out.println(bst2.inOrder());
        
        Assert.assertEquals("|DavismySymphony||JaneLanguage|", bst2.inOrder());
        System.out.println("---");
        
        BST bst3 = new BST();
        bst3.insert(hisAlbum);
        bst3.insert(myAlbum);
        bst3.insert(herAlbum);
        bst3.insert(finalAlbum);
        
        System.out.println(bst3.inOrder());
        bst3.remove(hisAlbum);
        System.out.println(bst3.inOrder());
        
        Assert.assertEquals("|AAAA||DavismySymphony||JaneLanguage|", bst3.inOrder());
        System.out.println("---");
        
        String[] s = {""};
        Album a1 = new Album("1", "", s);
        Album a2 = new Album("2", "", s);
        Album a3 = new Album("3", "", s);
        Album a4 = new Album("4", "", s);
        Album a5 = new Album("5", "", s);
        
        BST bst4 = new BST();
        bst4.insert(a1);
        bst4.insert(a3);
        bst4.insert(a2);
        bst4.insert(a4);
        bst4.insert(a5);
        System.out.println(bst4.inOrder());
        bst4.remove(a1);
        System.out.println(bst4.inOrder());
        System.out.println("---");
    }
    
    /**
     * Test method for {@link BST#remove(Album)}.
     */
    @Test
    public final void testRemove() {
        BST myBST = new BST();
        Album myAlbum = newAlbum(1);
        assertFalse(myBST.find(myAlbum));

        myBST.remove(myAlbum);
        assertFalse(myBST.find(myAlbum));

        myBST.insert(myAlbum);
        assertTrue(myBST.find(myAlbum));

        myBST.remove(myAlbum);
        assertFalse(myBST.find(myAlbum));

        myBST.insert(myAlbum);
        Album hisAlbum = newAlbum(2);
        myBST.insert(hisAlbum);
        assertTrue(myBST.find(hisAlbum));

        myBST.remove(myAlbum);
        //System.out.println("myBST: " + myBST.inOrder());
        assertFalse(myBST.find(myAlbum));

        myBST.remove(hisAlbum);
        assertFalse(myBST.find(hisAlbum));

        Album herAlbum = newAlbum(3);
        myBST.insert(myAlbum);
        myBST.insert(herAlbum);
        myBST.remove(myAlbum);
        assertFalse(myBST.find(myAlbum));
        
        BST bst2 = new BST();
        bst2.insert(hisAlbum);
        bst2.insert(herAlbum);
        bst2.insert(myAlbum);
        Album finalAlbum = newAlbum(4);
        bst2.insert(finalAlbum);
        bst2.remove(hisAlbum);
        assertFalse(bst2.find(hisAlbum));
        
        BST bst3 = new BST();
        bst3.insert(hisAlbum);
        bst3.insert(myAlbum);
        bst3.insert(herAlbum);
        
        bst3.remove(hisAlbum);
        //System.out.println(bst3.inOrder());
        assertFalse(bst3.find(hisAlbum));
    }

}
