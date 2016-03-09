/**
 * @author Davis
 * @version GingerAle
 */
public class BST {
    private Tnode root;
    private int numItems;

    /**
     * creates blanks BST
     */
    public BST() {
        root = new Tnode();
        numItems = 0;
    }

    /**
     * @return boolean true -> if numItems is 0
     */
    public boolean isEmpty() {
        return (numItems == 0);
    }

    /**
     * 
     * @param value
     *            Album to be inserted
     */
    public void insert(Album value) {
        Tnode insertMe = new Tnode();
        insertMe.item = value;

        root = insertTn(root, insertMe);
        numItems++;
    }

    /**
     * This private method checks if the tmpCurr or the tmpCurr.item is null as
     * a base case for where to insert the new album. if not, checks whether it
     * needs to be to the left or the right of tmpCurr. This function then
     * recursively calls itself till at the correct position in the BST with a
     * null node (base case). Since I don't do anything if equal, duplicates
     * will not be inserted.
     * 
     * @param tmpCurr
     *            current node being manipulated and checked against
     * @param nsrtMe
     *            node being inserted
     * @return node inserting at
     */
    private Tnode insertTn(Tnode tmpCurr, Tnode nsrtMe) {
        if (tmpCurr == null || tmpCurr.item == null) {
            tmpCurr = nsrtMe;
        }
        else {
            int cmp = nsrtMe.item.compareTo(tmpCurr.item);
            if (cmp < 0) {
                tmpCurr.left = insertTn(tmpCurr.left, nsrtMe);
            }
            else if (cmp > 0) {
                tmpCurr.right = insertTn(tmpCurr.right, nsrtMe);
            }
        }
        return tmpCurr;
    }

    /**
     * Calls inTnodeOrder passing the root node to properly recursively traverse
     * the array and put into a string that is returned per the key format.
     * 
     * @return String of BST in order by calling inTnodeOrder(root)
     */
    public String inOrder() {
        return inTnodeOrder(root);
    }

    /**
     * Recursively traverses the array in inOrder to put it into String format.
     * Begins with the base case of a null node/item and adds nothing in such
     * scenario. The return calls the following (tmpCurr.left recursively)
     * tmpCurr.item and (tmpCurr.right recursively)
     * 
     * @param tmpCurr
     *            node that is being manipulated in this call
     * @return inTnodeOrder BST Recursively
     */
    private String inTnodeOrder(Tnode tmpCurr) {
        if (tmpCurr == null || tmpCurr.item == null) {
            return "";
        }
        return inTnodeOrder(tmpCurr.left) + "|" + tmpCurr.item.key() + "|"
                + inTnodeOrder(tmpCurr.right);
    }

    /**
     * utilizes the dynamic findRetrieve function by calling it, passing the
     * root and the key of the album. Comparing this to null to see if it
     * exists. Alternatively, could call inOrder and see if the String contains
     * the key, but that would be to lazy of a method.
     * 
     * @param album
     *            Album to find
     * @return boolean if exists
     */
    public boolean find(Album album) {
        return (findRetrieve(root, album.key()) != null);
    }

    /**
     * This method also utilizes the findRetrieve method (making it slightly
     * messier but less overall code). A "fake" key is created with the artist
     * and title. that is then passed into findRetrieve. The returned node is
     * checked for if it is null to prevent error thrown on return of tmp.item.
     * Previously, this code received the Album which was passed straight back.
     * 
     * @param artist
     *            name of Album artist
     * @param title
     *            name of Album
     * @return Album matching criteria above
     */
    public Album retrieve(String artist, String title) {
        String tmpKey = artist + title;
        Tnode tmp = findRetrieve(root, tmpKey);

        if (tmp != null) {
            return tmp.item;
        }
        return null;

    }

    /**
     * The ever-loved findRetrieve (also used for remove). Base case checks for
     * null items. Originally the Albums were compared; to make this work for
     * both find and retrieve I used the String version of compareTo since I
     * couldn't create an album with null songs (nor did I wish to make up songs
     * here). Recursively traces through the BST to find the node containing the
     * album. the else on the end works for if equal to and therefore found it.
     * Return null handles non-existent for find()
     * 
     * @param tmpCurr
     *            current node being manipulated
     * @param tmpKey
     *            key of the album to find
     * @return Tnode containing the album found or null
     */
    private Tnode findRetrieve(Tnode tmpCurr, String tmpKey) {
        if (tmpCurr == null || tmpCurr.item == null) {
            return null;
        }

        int cmp = tmpKey.compareTo(tmpCurr.item.key());
        if (cmp < 0) {
            return findRetrieve(tmpCurr.left, tmpKey);
        }
        else if (cmp > 0) {
            return findRetrieve(tmpCurr.right, tmpKey);
        }
        else {
            return tmpCurr;
        }
    }

    /**
     * The recursive parts of remove are accomplished via findRetrieve (to find
     * the node to start with) and getMin from certain start node. if node is
     * not null, then actually can be removed. Three main cases exist within: 1.
     * node as no children -> get rid of it, make it null 2. node has 1 child ->
     * simple bypass of node to the proper child 3. node has 2 children -> copy
     * min value to the node, remove said min
     * 
     * @param a
     *            Album to be removed
     */
    public void remove(Album a) {
        Tnode rmvMe = findRetrieve(root, a.key());

        if (rmvMe != null) {
            if (rmvMe.left == null && rmvMe.right == null) {
                System.out.println("Case #1");

                rmvMe.item = null;
                rmvMe = null;

                numItems--;
            }
            else if (rmvMe.left == null) {
                System.out.println("Case #2-1");

                rmvMe.item = rmvMe.right.item;
                rmvMe.left = rmvMe.right.left;
                rmvMe.right = rmvMe.right.right;
            }
            else if (rmvMe.right == null) {
                System.out.println("Case #2-2");

                rmvMe.item = rmvMe.left.item;
                rmvMe.right = rmvMe.left.right;
                rmvMe.left = rmvMe.left.left;
            }
            else {
                System.out.println("Case #3");

                Tnode minOfRight = getMin(rmvMe.right);
                Album tmp = minOfRight.item;

                remove(minOfRight.item);

                rmvMe.item = tmp;
            }
        }
    }

    /**
     * getMin Tnode from specified branch. Base case: check if curr.left is null
     * (if so then that's the min). Else, recursively call down the leftmost
     * branch till reaching null.
     * 
     * @param tmpTnode
     *            Tnode from which to start finding min
     * @return minTnode from the initial Tnode provided
     */
    private Tnode getMin(Tnode tmpTnode) {
        if (tmpTnode.left == null) {
            return tmpTnode;
        }
        else {
            return getMin(tmpTnode.left);
        }
    }
}
