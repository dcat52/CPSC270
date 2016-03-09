/**
 * @author Davis
 * @version Banana
 */
class Tnode {
    /**
     * @item Album the spot of the BST is holding
     */
    Album item;
    /**
     * @left link to the left child from the current Tnode
     */
    Tnode left;
    /**
     * @right link to the right child from the current Tnode
     */
    Tnode right;

    /**
     * intialized all values of the Tnode to null
     */
    Tnode() {
        item = null;
        left = null;
        right = null;
    }
}
