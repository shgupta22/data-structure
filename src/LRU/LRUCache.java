package LRU;

import java.util.*;

public class LRUCache {
    int capacity;
    Deque<Integer> deque = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key) {
        if (set.contains(key)) {
            deque.remove(key);
        } else {
            if (deque.size() == capacity) {
                Integer last = deque.removeLast();
                set.remove(last);
            }
        }
        deque.addFirst(key);
        set.add(key);
    }

    public int get(int key) {
        if (set.contains(key)) {
            deque.remove(key);
            deque.addFirst(key);
            return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1);
        lruCache.put(2);
        lruCache.put(3);
        System.out.println(lruCache);
        lruCache.put(1);
        System.out.println(lruCache);
        lruCache.put(4);
        System.out.println(lruCache);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", deque=" + deque +
                ", set=" + set +
                '}';
    }
}
