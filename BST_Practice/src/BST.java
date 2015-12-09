/**
 * @author Davis Catherman
 * @version Apple
 */
public class BST {
    private Tnode root;
    private int numNodes;

    /**
     * create new BST
     */
    public BST() {
        root = new Tnode();
        numNodes = 0;
    }

    /**
     * Determine if the specified album is in this BST.
     * 
     * @param album
     *            to find
     * @return if found
     */
    public boolean find(Album album) {
        return findHelper(root, album);
    }

    /**
     * private find helper
     * 
     * @param curr
     *            curr node
     * @param toFindAlbum
     *            album to find
     * @return if found
     */
    private boolean findHelper(Tnode curr, Album toFindAlbum) {
        if (curr.item == null) {
            return false;
        }

        Album currAlbum = curr.item;
        int cmpAlbums = toFindAlbum.compareTo(currAlbum);

        if (cmpAlbums < 0) {
            findHelper(curr.left, toFindAlbum);
        }
        else if (cmpAlbums > 0) {
            findHelper(curr.right, toFindAlbum);
        }

        return true;
    }

    /**
     * The inorder traversal consists of the keys of each node delimited by the
     * pipe (|) symbol.
     * 
     * @return String of BST in order
     */
    public String inOrder() {
        // TODO: implement
        return null;
    }

    /**
     * Insert the specified value into this BST.
     * 
     * @param value
     *            album to insert
     */
    public void insert(Album value) {
        insertHelper(root, value);
    }

    /**
     * private insertHelper
     * 
     * @param curr
     *            Tnode to process
     * @param toInsertAlbum
     *            album being inserted
     */
    private void insertHelper(Tnode curr, Album toInsertAlbum) {
        // TODO Auto-generated method stub
        if (curr.item == null) {
            Tnode toInsert = new Tnode();

            toInsert.item = toInsertAlbum;
            curr = toInsert;

            numNodes++;
        }
        else {

            Album currAlbum = curr.item;
            int cmpAlbums = toInsertAlbum.compareTo(currAlbum);

            if (cmpAlbums < 0) {
                insertHelper(curr.left, toInsertAlbum);
            }
            else if (cmpAlbums > 0) {
                insertHelper(curr.right, toInsertAlbum);
            }
            else {
                // duplicate album, do nothing
            }

        }

    }

    /**
     * Determine if this BST is empty.
     * 
     * @return if empty
     */
    public boolean isEmpty() {
        return (numNodes == 0);
    }

    /**
     * Remove the specified album from this tree.
     * 
     * @param a
     *            album to remove
     */
    public void remove(Album a) {
        // TODO: implement
    }

    /**
     * Retrieve the album with the given artist and album title.
     * 
     * @param artist
     *            of album
     * @param title
     *            of album
     * @return album found
     */
    public Album retrieve(String artist, String title) {
        // TODO: implement
        return null;
    }
}
