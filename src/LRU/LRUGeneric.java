package LRU;

import java.util.*;

public class LRUGeneric<K,V> {
    public LRUGeneric(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "LRUGeneric{" +
                "capacity=" + capacity +
                ", deque=" + deque +
                ", map=" + map +
                '}';
    }

    static class Node<K,V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    int capacity;
    Deque<Node<K,V>> deque = new LinkedList<>();
    Map<K, Node<K,V>> map = new HashMap<>();

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            deque.remove(map.get(key));
        } else {
            if (deque.size() == capacity) {
                Node<K, V> last = deque.removeLast();
                map.remove(last.key);
            }
        }
        Node<K,V> newNode = new Node<>(key, value);
        deque.addFirst(newNode);
        map.put(key, newNode);
    }

    public Optional<V> get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            deque.remove(node);
            deque.addFirst(node);
            return Optional.of(node.value);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        LRUGeneric<Integer, String> lruGeneric = new LRUGeneric<>(3);

        System.out.println(lruGeneric);
        lruGeneric.put(1, "val1");
        System.out.println(lruGeneric);
        lruGeneric.put(2, "val2");
        System.out.println(lruGeneric);
        System.out.println(lruGeneric.get(1));
        System.out.println(lruGeneric);
        System.out.println(lruGeneric.get(3));
        lruGeneric.put(3, "val3");
        System.out.println(lruGeneric);
        System.out.println(lruGeneric.get(2));
        System.out.println(lruGeneric);
        lruGeneric.put(4, "val4");
        System.out.println(lruGeneric);

        System.out.println("**********************");
        LRUGeneric<String, String> lruGeneric2 = new LRUGeneric<>(3);

        System.out.println(lruGeneric2);
        lruGeneric2.put("1", "val1");
        System.out.println(lruGeneric2);
        lruGeneric2.put("2", "val2");
        System.out.println(lruGeneric2);
        System.out.println(lruGeneric2.get("1"));
        System.out.println(lruGeneric2);
        System.out.println(lruGeneric2.get("3"));
        lruGeneric2.put("3", "val3");
        System.out.println(lruGeneric2);
        System.out.println(lruGeneric2.get("2"));
        System.out.println(lruGeneric2);
        lruGeneric2.put("4", "val4");
        System.out.println(lruGeneric2);
    }
}
