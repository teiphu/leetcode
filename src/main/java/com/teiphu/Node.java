package com.teiphu;

import java.util.List;

/**
 * @author Zheng Lifu
 */
public class Node {
    public int val;

    public int key;

    public int value;

    public int frequency = 1;

    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
