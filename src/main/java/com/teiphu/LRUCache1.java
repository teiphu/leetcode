package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zheng Lifu
 */
public class LRUCache1 {

    private Map<Object, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            int res = (int) node.value;
            removeNode(node);
            addNodeToHead(node);
            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            removeNode(oldNode);
            addNodeToHead(node);
            cache.put(key, node);
        } else {
            if (cache.size() >= capacity) {
                cache.remove(tail.pre.key);
                removeTailNode();
            }
            addNodeToHead(node);
            cache.put(key, node);

        }
    }

    private void removeNode(Node oldNode) {
    }

    private void addNodeToHead(Node node) {

    }

    private void removeTailNode() {
    }

    class Node {
        Node pre;
        Node next;
        Object key;
        Object value;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
