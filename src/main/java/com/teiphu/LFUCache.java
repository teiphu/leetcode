package com.teiphu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

	Map<Integer, Node1> cache;
	Map<Integer, LinkedHashSet<Node1>> freqMap;
	int size;
	int capacity;
	int min;

	public LFUCache(int capacity) {
		cache = new HashMap<>(capacity);
		freqMap = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Node1 node1 = cache.get(key);
		if (node1 == null) {
			return -1;
		}
		freqInc(node1);
		return node1.value;
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		Node1 node1 = cache.get(key);
		if (node1 != null) {
			node1.value = value;
			freqInc(node1);
		} else {
			if (size == capacity) {
				Node1 deadNode1 = removeNode();
				cache.remove(deadNode1.key);
				size--;
			}
			Node1 newNode1 = new Node1(key, value);
			cache.put(key, newNode1);
			addNode(newNode1);
			size++;
		}
	}

	void freqInc(Node1 node1) {
		int freq = node1.frequency;
		LinkedHashSet<Node1> set = freqMap.get(freq);
		set.remove(node1);
		if (freq == min && set.size() == 0) {
			min = freq + 1;
		}
		node1.frequency++;
		LinkedHashSet<Node1> newSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
		newSet.add(node1);
	}

	void addNode(Node1 node1) {
		LinkedHashSet<Node1> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
		set.add(node1);
		min = 1;
	}

	Node1 removeNode() {
		LinkedHashSet<Node1> set = freqMap.get(min);
		Node1 deadNode1 = set.iterator().next();
		set.remove(deadNode1);
		return deadNode1;
	}
}

class Node1 {
	int key;
	int value;
	int frequency = 1;

	public Node1() {}

	public Node1(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
