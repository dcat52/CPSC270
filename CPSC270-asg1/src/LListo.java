/**
 * LListo class implementation of Listo
 * 
 * @author Davis Catherman
 * 
 * @version C_3.0
 */
public class LListo implements Listo {

    /**
     * Node<Object> head Node<Object> tail Node<Object> curr
     */
    private Node<Object> head;
    private Node<Object> tail;
    private Node<Object> curr;
    private int numNodes;

    /**
     * default constructor
     */
    public LListo() {
        head = new Node<Object>();
        tail = new Node<Object>();
        curr = head;
        numNodes = 0;
        erase();
    }

    /**
     * default constructor with size ignored
     * 
     * @param size
     *            to be ignored
     */
    public LListo(int size) {
        head = new Node<Object>();
        tail = new Node<Object>();
        curr = head;
        numNodes = 0;
        erase();
    }

    @Override
    public boolean isEmpty() {
        return (numNodes == 0);
    }

    @Override
    public void erase() {
        head.setNext(tail);
        tail.setPrev(head);
        curr = head;
        numNodes = 0;
    }

    @Override
    public void add(Object element) {

        if (isEmpty()) {
            curr = head;
        }
        Node<Object> tNode = new Node<Object>();
        tNode.setItem(element);
        tNode.setNext(curr.next());
        tNode.setPrev(curr);
        curr.setNext(tNode);
        tNode.next().setPrev(tNode);
        advance();
        numNodes++;
    }

    @Override
    public void delete() {

        if (isEmpty() || curr == head) {

            System.out.println("could not delete");

            System.out.println(numNodes);
        }
        else if (head == curr.prev()) {
            head.setNext(curr.next());
            curr.next().setPrev(head);
            curr = head.next();
            numNodes--;
            System.out.println(numNodes);
        }
        else {

            curr.setPrev(curr.prev().prev());
            curr.prev().setNext(curr);

            numNodes--;
            System.out.println(numNodes);
        }
    }

    @Override
    public void goToHead() {
        curr = head;
    }

    @Override
    public boolean retreat() {
        if (curr == head) {
            return false;
        }
        curr = curr.prev();
        return true;

    }

    @Override
    public boolean advance() {
        if (curr.next() == tail) {
            return false;
        }

        curr = curr.next();
        return true;
    }

    @Override
    public int numberOfElements() {
        return numNodes;
    }

    @Override
    public Object element() {

        if (curr == head) {
            return null;
        }

        return curr.item();
    }

    @Override
    public String asString() {
        //
        // LListo tempList = this;
        // Node<Object> tCurN = curr;
        // tempList.goToHead();
        // String str = "";
        // if (tCurN == head) {
        // str += "| ";
        // }
        // str += "< ";
        // for (int i = 1; i <= tempList.numNodes; i++) {
        // tempList.curr = tempList.curr.next();
        // if (tempList.curr == tCurN) {
        // str += "| ";
        // }
        //
        // try {
        // str += tempList.element().toString();
        // str += " ";
        // }
        // catch (Exception e) {
        //
        // }
        // }
        // str += ">";
        // return str;

        // TODO: Implement
        return "not yet implemented";
    }
}
