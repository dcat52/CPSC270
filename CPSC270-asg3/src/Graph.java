/**
 * @author Davis
 * @version Release
 */
public class Graph {

    private boolean[][] matrix;
    private Object[] nodes;
    private int numEdges;

    /**
     * Create a graph with a default capacity of 10 nodes.
     */
    public Graph() {
        matrix = new boolean[10][10];
        nodes = new Object[10];
        numEdges = 0;
    }

    /**
     * Depth first traversal of this graph from the given node.
     * 
     * @param myName
     *            given node
     * @return depth of graph traversal
     */
    public String[] depthFirstTraversal(String myName) {
        int numNodes = numOfNodes();
        int startLocation = 0;

        boolean[] visited = new boolean[numNodes];
        String[] tempDFT = new String[numOfNodes()];
        int[] n = { 0 };

        Object[] transporter = new Object[3];
        transporter[0] = tempDFT;
        transporter[1] = visited;
        transporter[2] = n;

        for (int i = 0; i < numNodes; i++) {
            if (nodes[i].equals(myName)) {
                startLocation = i;
                visited[startLocation] = true;
            }
        }
        dftRecursive(myName, startLocation, transporter);
        String[] dft = new String[n[0]];
        for (int i = 0; i < n[0]; i++) {
            dft[i] = tempDFT[i];
        }
        return dft;
    }

    /**
     * dft helper method for recursion
     * 
     * @param curr
     *            current node being processed
     * @param currLoc
     *            location of current node in matrix
     */
    private void dftRecursive(Object curr, int currLoc, Object[] transporter) {
        String[] tempDFT = (String[]) transporter[0];
        boolean[] visited = (boolean[]) transporter[1];
        int[] n = (int[]) transporter[2];

        tempDFT[n[0]++] = curr.toString();
        visited[currLoc] = true;

        for (int i = 0; i < numOfNodes(); i++) {
            if (matrix[currLoc][i] && !visited[i]) {
                dftRecursive(nodes[i], i, transporter);
            }
        }
    }

    /**
     * Report if there is an edge from first specified node to second specified
     * node.
     * 
     * @param name1
     *            1st node
     * @param name2
     *            2nd node
     * @return edge exists true/false
     */
    public boolean hasEdge(String name1, String name2) {
        int ndxV = -1;
        int ndxW = -1;
        for (int i = 0; i < numOfNodes(); i++) {
            if (nodes[i].equals(name1)) {
                ndxV = i;
            }

            if (nodes[i].equals(name2)) {
                ndxW = i;
            }
        }

        if (ndxV == -1 || ndxW == -1) {
            return false;
        }
        return matrix[ndxV][ndxW];
    }

    /**
     * Report if the given node is in the graph.
     * 
     * @param node
     *            given node
     * @return in graph true/false
     */
    public boolean hasNode(String node) {
        for (int i = 0; i < numOfNodes(); i++) {
            if (nodes[i].equals(node)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Insert edge from first specified node to second specified node.
     * 
     * @param name1
     *            1st node
     * @param name2
     *            2nd node
     */
    public void insertEdge(String name1, String name2) {
        int ndxV = -1;
        int ndxW = -1;
        for (int i = 0; i < numOfNodes(); i++) {
            if (nodes[i].equals(name1)) {
                ndxV = i;
            }
            // NOTE: can we make an edge to itself?
            if (nodes[i].equals(name2)) {
                ndxW = i;
            }
        }
        if (matrix[ndxV][ndxW]) {
            throw new IllegalArgumentException();
        }
        matrix[ndxV][ndxW] = true;
        numEdges++;
    }

    /**
     * Insert a node into the graph.
     * 
     * @param myName
     *            node to insert
     */
    public void insertNode(String myName) {
        int numNodes = numOfNodes();
        if (numNodes != nodes.length) {
            if (hasNode(myName)) {
                throw new IllegalArgumentException();
            }

            nodes[numNodes] = myName;
        }
    }

    /**
     * Reports if this graph has no nodes.
     * 
     * @return graph is empty true/false
     */
    public boolean isEmpty() {
        return (numOfNodes() == 0);

    }

    /**
     * Report the number of edges.
     * 
     * @return number of edges
     */
    public int numOfEdges() {
        return numEdges;

    }

    /**
     * Report the number of nodes in the graph.
     * 
     * @return number of nodes
     */
    public int numOfNodes() {
        int numNodes = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                numNodes++;
            }
        }
        return numNodes;

    }
}
