package com.teiphu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 146. LRU 缓存机制
 * 面试题 16.25. LRU缓存
 *
 * @author Zheng Lifu
 */
public class LRUCache {

	private Map<Integer, Integer> cache;

	private Queue<Integer> keys;

	private int capacity;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>();
		this.keys = new LinkedList<>();
		this.capacity = capacity;
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(1, 1);
		lru.put(2, 2);

	}

	public int get(int key) {
		Integer value = cache.get(key);
		if (value != null) {
			keys.remove(key);
			keys.add(key);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		Integer val = cache.get(key);
		if (val != null) {
			cache.put(key, value);
			keys.remove(key);
			keys.add(key);
		} else {
			if (keys.size() < capacity) {
				cache.put(key, value);
				keys.add(key);
			} else {
				Integer head = keys.poll();
				cache.remove(head);
				cache.put(key, value);
				keys.add(key);
			}
		}
	}
}
