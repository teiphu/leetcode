package com.teiphu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node1 = cache.get(key);
        if (node1 != null) {
            node1.value = value;
            freqInc(node1);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node1) {
        int freq = node1.frequency;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node1);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        node1.frequency++;
        LinkedHashSet<Node> newSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
        newSet.add(node1);
    }

    void addNode(Node node1) {
        LinkedHashSet<Node> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
        set.add(node1);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode1 = set.iterator().next();
        set.remove(deadNode1);
        return deadNode1;
    }
}

/*class Node {
	int key;
	int value;
	int frequency = 1;

	public Node() {}

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}*/
