import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Map<K, ListNode<V>> seqMap;
    private final DoublyLL<V> cache;

    private final int cacheCapacity;

    public LRUCache(int cacheCapacity, V headVal, V tailVal) {
        seqMap = new HashMap<>();
        cache = new DoublyLL<>(headVal, tailVal);
        this.cacheCapacity = cacheCapacity;
    }

    public LRUCache<K, V> put(K key, V value) {
        if (seqMap.containsKey(key)) {
            cache.updateAndMoveNodeAtStart(seqMap.get(key), value);
        } else {
            ListNode<V> valueNode = new ListNode<>(value);
            int currentSize = cache.addStart(valueNode);
            seqMap.put(key, valueNode);
            if (currentSize > cacheCapacity) {
                ListNode<V> removedNode = this.cache.removeLastNode();
            }
        }
        return this;
    }

    public V get(K key) {
        if (this.seqMap.containsKey(key)) {
            ListNode<V> node = this.seqMap.get(key);
            this.cache.updateAndMoveNodeAtStart(node, node.getVal());
            return node.getVal();
        }
        return null;
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
