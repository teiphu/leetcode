package com.teiphu;

import java.util.List;

/**
 * 559. N叉树的最大深度
 *
 * @author Zheng Lifu
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        return depth(root, 0);
    }

    private int depth(Node node, int len) {
        if (node == null) {
            return len;
        }
        if (node.children == null) {
            return len + 1;
        }
        List<Node> children = node.children;
        int max = len + 1;
        for (Node child : children) {
            int l = depth(child, len + 1);
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

}
