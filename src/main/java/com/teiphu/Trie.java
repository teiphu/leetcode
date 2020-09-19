package com.teiphu;

public class Trie {
	
	public Trie() {
		// TODO �Զ����ɵĹ��캯�����
		root = new TrieNode(' ');
	}

	public static void main(String[] args) {
		
	}
	
	private class TrieNode {
		TrieNode[] childrens = new TrieNode[26];
		int frequency;	//���ִ����ظ���Ŀ,Ƶ��
		int prefixNum;	//�Ը��Ӵ�Ϊǰ׺�ĵ�����
		char val;		//����û�У������±����֪��vald��ֵ
		boolean isLeaf;	//�ǲ������һ���ڵ�
		public TrieNode(char val) {
			// TODO �Զ����ɵĹ��캯�����
			this.val = val;
			isLeaf = false;
		}
	}

	private TrieNode root;
	
	public void insert(String word) {
		TrieNode cur = root;
		char[] data = word.toLowerCase().toCharArray();
		int n;
		for (int i = 0; i < data.length; i++) {
			n = data[i] - 'a';
			if (cur.childrens[n] == null) {
				cur.childrens[n] = new TrieNode(data[i]);
			}
			cur = cur.childrens[n];
			cur.prefixNum++;
		}
		cur.isLeaf = true;
		cur.frequency++;
	}
		
	public boolean search(String word) {
		TrieNode cur = root;
		char[] data = word.toLowerCase().toCharArray();
		int n;
		for (int i = 0; i < data.length; i++) {
			n = data[i] - 'a';
			if (cur.childrens[n] == null) {
				return false;
			}
			cur = cur.childrens[n];
		}
		return cur.isLeaf;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		char[] data = prefix.toLowerCase().toCharArray();
		int n;
		for (int i = 0; i < data.length; i++) {
			n = data[i] - 'a';
			if (cur.childrens[n] == null) {
				return false;
			}
			cur = cur.childrens[n];
		}
		return true;
	}

}
