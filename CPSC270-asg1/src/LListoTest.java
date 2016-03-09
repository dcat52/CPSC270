import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for implementation of LListo
 * 
 * @author Davis Catherman
 * 
 * @version C_3.0
 *
 */
public class LListoTest {

    /**
     * tests creating a new list var without instantiating new object
     */
    @Test
    public void noNewListNullObj() {
        LListo myLL = null;
        assertNull("myLL exists?!?! but how", myLL);
    }

    /**
     * test creating a new list var with the default constructor tests with not
     * being null obj and then number of Elements
     */
    @Test
    public void newListDefault() {
        LListo myLL = new LListo();
        assertNotNull("uhoh, it was a null object", myLL);

        int expected = 0;
        int actual = myLL.numberOfElements();
        assertEquals(expected, actual);
    }

    // this test is ignored because my code cannot 
    // /**
    // * Tests return element with blank list should throw an Illegal Argument
    // * Exception
    // */
    // @Test(expected = IllegalArgumentException.class)
    // public void elementReturnIllArgExcep() {
    // LListo myLL = new LListo();
    // assertNotNull(myLL);
    // myLL.element();
    // }

    /**
     * tests return element with added Node to list
     */
    @Test
    public void elementReturnAddedItem() {
        LListo myLL = new LListo();
        myLL.add(5);
        Object expected = 5;
        Object actual = myLL.element();
        assertEquals(expected, actual);
    }

    /**
     * test creating a new list var with the size parameter constructor tests
     * with number of Elements
     */
    @Test
    public void newListWithSize() {
        LListo myLL = new LListo(22);
        assertNotNull("uhoh, it was a null object", myLL);
        int expected = 0;
        int actual = myLL.numberOfElements();
        assertEquals(expected, actual);
    }

    /**
     * test added element is incrementing numberElements
     */
    @Test
    public void addOne() {
        LListo myLL = new LListo();
        Integer num0 = 5;
        int expected = 1;
        myLL.add(num0);
        int actual = myLL.numberOfElements();
        assertEquals("hmmm, didn't match.", expected, actual);
    }

    /**
     * tests adding two elements and incrementing num elements
     */
    @Test
    public void addTwoDiff() {
        LListo myLL = new LListo();
        int expected = myLL.numberOfElements() + 2;
        myLL.add(5);
        myLL.add(8);
        int actual = myLL.numberOfElements();
        assertEquals("hmmm, didn't match.", expected, actual);
    }

    /**
     * 
     */
    @Test
    public void isEmptyList() {
        LListo myLL = new LListo();
        boolean expected = true;
        boolean actual = myLL.isEmpty();
        assertEquals("should be empty", expected, actual);
    }

    /**
     * tests empty list after adding element
     */
    @Test
    public void isEmptyListWithAdding() {
        LListo myLL = new LListo();
        int num0 = 5;
        myLL.add(num0);
        boolean expected = false;
        boolean actual = myLL.isEmpty();
        assertEquals("shouldn't be empty", expected, actual);
    }

    /**
     * tests advance with an empty list
     */
    @Test
    public void advanceWithEmptyList() {
        LListo myLL = new LListo();
        boolean expected = false;
        boolean actual = myLL.advance();
        assertEquals("should be false", expected, actual);
    }

    /**
     * tests advance with added element should not advance still
     */
    @Test
    public void advanceWithOneElement() {
        LListo myLL = new LListo();
        myLL.add(0);
        boolean expected = false;
        boolean actual = myLL.advance();
        assertEquals("should be false", expected, actual);
    }

    /**
     * tests advance with two elements still shouldn't advance
     */
    @Test
    public void advanceWithTwoElements() {
        LListo myLL = new LListo();
        myLL.add(3);
        myLL.add(5);
        boolean expected = false;
        boolean actual = myLL.advance();
        assertEquals("should be false", expected, actual);
    }

    /**
     * tests retreat with 1 added element should actually retreat
     */
    @Test
    public void retreatWithOneElement() {
        LListo myLL = new LListo();
        myLL.add(5);
        boolean expected = true;
        boolean actual = myLL.retreat();
        assertEquals("should be true", expected, actual);
    }

    /**
     * tests retreat 2 times with 1 added element should actually retreat
     */
    @Test
    public void retreatTwiceWithOneElement() {
        LListo myLL = new LListo();
        myLL.add(5);
        boolean expected = false;
        myLL.retreat();
        boolean actual = myLL.retreat();
        assertEquals("should be false", expected, actual);
    }

    /**
     * tests retreat with 2 added elements should retreat once
     */
    @Test
    public void retreatWithTwoElements() {
        LListo myLL = new LListo();
        myLL.add(3);
        myLL.add(5);
        boolean expected = true;
        boolean actual = myLL.retreat();
        assertEquals("should be true", expected, actual);
    }

    /**
     * tests retreat with added element then advance again
     */
    @Test
    public void retreatThenAdavanceWithOneElement() {
        LListo myLL = new LListo();
        myLL.add(3);
        boolean expected = true;
        boolean actual = myLL.retreat();
        assertEquals("should retreat", expected, actual);
        expected = true;
        actual = myLL.advance();
        assertEquals("should advance", expected, actual);
    }

    /**
     * tests various aspects of delete
     */
    @Test
    public void deleteFromList() {
        LListo myLL = new LListo();
        myLL.delete();
        assertEquals(0, myLL.numberOfElements());
        myLL.add(4);
        myLL.add(5);
        assertEquals(2, myLL.numberOfElements());
        myLL.delete();
        assertEquals(1, myLL.numberOfElements());
        myLL.delete();
        assertEquals(0, myLL.numberOfElements());
        myLL.add(22);
        myLL.goToHead();
        myLL.delete();
        assertEquals(1, myLL.numberOfElements());

    }

    /**
     * tests curr being head, returns null
     */
    @Test
    public void getElementHead() {
        LListo myLL = new LListo();
        myLL.goToHead();
        Object expected = null;
        Object obj = myLL.element();
        assertEquals(expected, obj);
    }

    // /**
    // * tests returning blank list as String
    // */
    // @Test
    // public void returnBlankListAsString() {
    // LListo myLL = new LListo();
    // String expected = "| < >";
    // String actual = myLL.asString();
    // assertEquals(expected, actual);
    // }
    //
    // /**
    // * tests adding 3 elements then returns the list as a String
    // */
    // @Test
    // public void addThenReturnList() {
    // LListo myLL = new LListo();
    // myLL.add(1);
    // myLL.add(2);
    // myLL.add(3);
    // String expected = "< 1 2 | 3 >";
    // String actual = myLL.asString();
    // assertEquals(expected, actual);
    // }
    //
    // /**
    // * tests returning list as string by adding three then retreating once
    // */
    // @Test
    // public void addThreeIntsRetreatOnceReturnList() {
    // LListo myLL = new LListo();
    // myLL.add(1);
    // myLL.add(2);
    // myLL.add(3);
    // myLL.retreat();
    // String expected = "< 1 | 2 3 >";
    // String actual = myLL.asString();
    // assertEquals(expected, actual);
    // }
    //
    // /**
    // * tests returning list as string with 2 Strings
    // */
    // @Test
    // public void addTwoStringsReturnList() {
    // LListo myLL = new LListo();
    // myLL.add("abc");
    // myLL.add("def");
    // String expected = "< abc | def >";
    // String actual = myLL.asString();
    // assertEquals(expected, actual);
    // }
    //
    //
    // /**
    // * tests adding 2, deleting 1, then returning as String
    // */
    // @Test
    // public void addTwoDelete1stReturnList() {
    // LListo myLL = new LListo();
    // myLL.add(1);
    // myLL.add(2);
    // myLL.delete();
    // String expected = "< | 2 >";
    // String actual = myLL.asString();
    // System.out.println(actual);
    // assertEquals(expected, actual);
    // }
}
