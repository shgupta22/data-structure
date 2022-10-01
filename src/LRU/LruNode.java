package LRU;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruNode {
    public LruNode(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "LruNode{" +
                "capacity=" + capacity +
                ", deque=" + deque +
                ", map=" + map +
                '}';
    }

    class Node {
        int key;
        String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    int capacity;
    Deque<Node> deque = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();

    public void put(int key, String value) {
        if (map.containsKey(key)) {
            deque.remove(map.get(key));
        } else {
            if (deque.size() == capacity) {
                Node last = deque.removeLast();
                map.remove(last.key);
            }
        }
        Node newNode = new Node(key, value);
        deque.addFirst(newNode);
        map.put(key, newNode);
    }

    public String get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deque.remove(node);
            deque.addFirst(node);
            return node.value;
        }
        return "NOT_FOUND";
    }

    public static void main(String[] args) {
        LruNode lruNode = new LruNode(3);

        System.out.println(lruNode);
        lruNode.put(1, "val1");
        System.out.println(lruNode);
        lruNode.put(2, "val2");
        System.out.println(lruNode);
        System.out.println(lruNode.get(1));
        System.out.println(lruNode);
        System.out.println(lruNode.get(3));
        lruNode.put(3, "val3");
        System.out.println(lruNode);
        System.out.println(lruNode.get(2));
        System.out.println(lruNode);
        lruNode.put(4, "val4");
        System.out.println(lruNode);
    }
}
