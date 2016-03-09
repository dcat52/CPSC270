/**
 * class Node<T> is my custom node class for Linked List implemented with a
 * bidirectional traversing list
 * 
 * @author Davis Catherman
 * @version D_3.0
 * 
 * @param <T>
 *            type of Node Object
 */
class Node<T> {
    private T item;
    private Node<T> next;
    private Node<T> prev;

    /**
     * default constructor for blank Node<T>
     */
    Node() {
        this.item = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * @return the next Node<T> address
     */
    Node<T> next() {
        return this.next;
    }

    /**
     * @param nxt
     *            set next Node<T> address
     */
    void setNext(Node<T> nxt) {
        this.next = nxt;
    }

    /**
     * @return the previous Node<T> address
     */
    Node<T> prev() {
        return this.prev;
    }

    /**
     * @param prv
     *            set the previous Node<T> address
     */
    void setPrev(Node<T> prv) {
        this.prev = prv;
    }

    /**
     * @return item of the current Node<T>
     */
    T item() {
        return this.item;
    }

    /**
     * @param itm
     *            set the item in the current Node<T>
     */
    void setItem(T itm) {
        this.item = itm;
    }
}
