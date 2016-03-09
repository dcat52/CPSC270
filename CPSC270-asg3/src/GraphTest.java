import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Davis
 * @version Release
 */
public class GraphTest {

    /**
     * Test method for {@link Graph#Graph()}.
     */
    @Test
    public final void testGraph() {
        Graph myGraph = null;
        Assert.assertNull(myGraph);
        myGraph = new Graph();
        Assert.assertNotNull(myGraph);
    }

    /**
     * Test method for {@link Graph#depthFirstTraversal(java.lang.String)}.
     */
    @Test
    public final void testDepthFirstTraversal() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        myGraph.insertNode("C");
        myGraph.insertEdge("A", "B");
        myGraph.insertEdge("A", "C");
        String[] expecteds = { "A", "B", "C" };
        String[] actuals = myGraph.depthFirstTraversal("A");
        Assert.assertArrayEquals(expecteds, actuals);
    }

    /**
     * Test method for deftFirstTranversal with Repeat
     */
    @Test
    public final void testDepthFirstTraversalWithRepeat() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        myGraph.insertNode("C");
        myGraph.insertEdge("A", "B");
        myGraph.insertEdge("A", "C");
        myGraph.insertEdge("B", "C");
        String[] expecteds = { "A", "B", "C" };
        String[] actuals = myGraph.depthFirstTraversal("A");
        Assert.assertArrayEquals(expecteds, actuals);
    }

    /**
     * Test method for deftFirstTranversal with Island
     */
    @Test
    public final void testDepthFirstTraversalWithIsland() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        myGraph.insertNode("C");
        myGraph.insertEdge("A", "B");
        String[] expecteds = { "A", "B" };
        String[] actuals = myGraph.depthFirstTraversal("A");
        Assert.assertArrayEquals(expecteds, actuals);
    }

    /**
     * Test method for {@link Graph#hasEdge(java.lang.String, java.lang.String)}
     * .
     */
    @Test
    public final void testHasEdge() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        myGraph.insertEdge("A", "B");
        boolean actual = myGraph.hasEdge("A", "B");
        Assert.assertTrue(actual);

        actual = myGraph.hasEdge("B", "A");
        Assert.assertFalse(actual);

        actual = myGraph.hasEdge("C", "random");
        Assert.assertFalse(actual);
        actual = myGraph.hasEdge("A", "random");
        Assert.assertFalse(actual);
    }

    /**
     * Test method for {@link Graph#hasNode(java.lang.String)}.
     */
    @Test
    public final void testHasNode() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        boolean actual = myGraph.hasNode("A");
        Assert.assertTrue(actual);
        actual = myGraph.hasNode("B");
        Assert.assertFalse(actual);
    }

    /**
     * Test method for
     * {@link Graph#insertEdge(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testInsertEdge() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        int actual = myGraph.numOfEdges();
        Assert.assertEquals(0, actual);
        myGraph.insertEdge("A", "B");
        actual = myGraph.numOfEdges();
        Assert.assertEquals(1, actual);
    }

    /**
     * Test method for insertEdge with illegalArgumentException Thrown.
     */
    @Test
    public final void testInsertEdgeIllegalArgumentException() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        myGraph.insertNode("B");
        myGraph.insertEdge("A", "B");
        try {
            myGraph.insertEdge("A", "B");
        }
        catch (IllegalArgumentException e) {
            Assert.assertNotNull(e);
        }
        Assert.assertNotNull(myGraph);
    }

    /**
     * Test method for {@link Graph#insertNode(java.lang.String)}.
     */
    @Test
    public final void testInsertNode() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        boolean actual = myGraph.isEmpty();
        Assert.assertFalse(actual);

        myGraph.insertNode("B");
        myGraph.insertNode("C");
        myGraph.insertNode("D");
        myGraph.insertNode("E");
        myGraph.insertNode("F");
        myGraph.insertNode("G");
        myGraph.insertNode("H");
        myGraph.insertNode("I");
        myGraph.insertNode("J");

        int actual1 = myGraph.numOfNodes();
        Assert.assertEquals(10, actual1);
        myGraph.insertNode("K");
        actual1 = myGraph.numOfNodes();
        Assert.assertEquals(10, actual1);
    }

    /**
     * Test method for insertNode with illegalArgumentException Thrown.
     */
    @Test
    public final void testInsertNodeIllegalArgumentException() {
        Graph myGraph = new Graph();
        myGraph.insertNode("A");
        try {
            myGraph.insertNode("A");
        }
        catch (IllegalArgumentException e) {
            Assert.assertNotNull(e);
        }
        Assert.assertNotNull(myGraph);
    }

    /**
     * Test method for {@link Graph#isEmpty()}.
     */
    @Test
    public final void testIsEmpty() {
        Graph myGraph = new Graph();
        boolean actual = myGraph.isEmpty();
        Assert.assertTrue(actual);
    }

    /**
     * Test method for {@link Graph#numOfEdges()}.
     */
    @Test
    public final void testNumOfEdges() {
        Graph myGraph = new Graph();
        int actual = myGraph.numOfEdges();
        Assert.assertEquals(0, actual);
    }

    /**
     * Test method for {@link Graph#numOfNodes()}.
     */
    @Test
    public final void testNumOfNodes() {
        Graph myGraph = new Graph();
        int actual = myGraph.numOfNodes();
        Assert.assertEquals(0, actual);
    }

}
