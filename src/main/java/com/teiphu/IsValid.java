package com.teiphu;

import java.util.LinkedList;

/**
 * 20. 有效的括号
 *
 * @author Zheng Lifu
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "(]";
        IsValid iv = new IsValid();
        System.out.println(iv.isValid(s));
    }

    public boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')' && ch != ']' && ch != '}') {
                linkedList.push(ch);
            } else {
                if (linkedList.isEmpty()) {
                    return false;
                }
                char t = linkedList.pop();
                if (ch == ')' && t != '(') {
                    return false;
                } else if (ch == ']' && t != '[') {
                    return false;
                } else if (ch == '}' && t != '{') {
                    return false;
                }
            }
        }
        return linkedList.isEmpty();
    }

}
