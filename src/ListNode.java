import java.util.Objects;

public class ListNode<V> {

    private V val;
    private ListNode<V> next;
    private ListNode<V> prev;

    public ListNode(V val) {
        this.val = val;
    }

    public V getVal() {
        return val;
    }

    public ListNode<V> setVal(V val) {
        this.val = val;
        return this;
    }

    public ListNode<V> getNext() {
        return next;
    }

    public ListNode<V> setNext(ListNode<V> next) {
        this.next = next;
        return this;
    }

    public ListNode<V> getPrev() {
        return prev;
    }

    public ListNode<V> setPrev(ListNode<V> prev) {
        this.prev = prev;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(val, listNode.val) &&
                Objects.equals(next, listNode.next) &&
                Objects.equals(prev, listNode.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, prev);
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
