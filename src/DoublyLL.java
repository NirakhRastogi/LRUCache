public class DoublyLL<V> {

    private final ListNode<V> head;
    private final ListNode<V> tail;
    private int size = 0;

    public DoublyLL(V headVal, V tailVal) {
        this.head = new ListNode<V>(headVal).setPrev(null);
        this.tail = new ListNode<V>(tailVal).setNext(null).setPrev(this.head);
        this.head.setNext(this.tail);
        this.size = 0;
    }

    public int addStart(ListNode<V> node) {
        node.setNext(this.head.getNext());
        node.setPrev(this.head);
        this.head.getNext().setPrev(node);
        this.head.setNext(node);
        size++;
        return this.size;
    }

    public int addEnd(ListNode<V> node) {
        node.setNext(this.tail);
        node.setPrev(this.tail.getPrev());
        this.tail.getPrev().setNext(node);
        this.tail.setPrev(node);
        size++;
        return this.size;
    }

    public int updateAndMoveNodeAtStart(ListNode<V> node, V val) {
        node.setVal(val);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--; // Decreasing size by 1, so that when addStart trigger size will not be impacted.
        return addStart(node);
    }

    public ListNode<V> removeLastNode() {
        if (this.tail.getPrev() != null) {
            ListNode<V> removedNode = this.tail.getPrev();
            this.tail.getPrev().getPrev().setNext(this.tail);
            size--;
            return removedNode;
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public ListNode<V> getHead() {
        return head;
    }

    public ListNode<V> getTail() {
        return tail;
    }

    @Override
    public String toString() {
        ListNode<V> temp = this.head;
        StringBuilder output = new StringBuilder("[");
        while (temp != null) {
            output.append(temp.toString()).append("<=>");
            temp = temp.getNext();
        }
        return output.append("]").toString();
    }
}
