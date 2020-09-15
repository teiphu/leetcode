package org.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = {1, 4, 5, 9};
		int[] nums1 = {1, 3, 4};
		int[] nums2 = {2, 6, 7};
		ListNode node = buildList(nums);
		ListNode node2 = buildList(nums1);
		ListNode node3 = buildList(nums2);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = node;
		lists[1] = node2;
		lists[2] = node3;
		
		for (int i = 0; i < lists.length; i++) {
			ListNode no = lists[i];
			while (no != null) {
				System.out.println(no.val);
				no = no.next;
			}
			
		}
		
		
		System.out.println();
		ListNode listNode = mergeKLists1(lists);
		
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
		
//		while (node != null) {
//			System.out.println(node.val);
//			node = node.next;
//		}
//		
//		while (node2 != null) {
//			System.out.println(node2.val);
//			node2 = node2.next;
//		}
//		
//		while (node3 != null) {
//			System.out.println(node3.val);
//			node3 = node3.next;
//		}
	}
	
	public static ListNode mergeKLists1(ListNode[] lists) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node != null) {
				while (node != null) {
					nums.add(node.val);
					node = node.next;
				}
			} 
		}
		
		Integer[] ints = nums.toArray(new Integer[nums.size()]);
		Arrays.sort(ints);
		ListNode root = buildList(ints);
		return root;
		
	}
	
	private static ListNode buildList(Integer[] ints) {
		// TODO �Զ����ɵķ������
		MergeKLists mergeKLists = new MergeKLists();
		ListNode root = mergeKLists.new ListNode(0);
		ListNode node = root;
		for (int i : ints) {
			ListNode node2 = mergeKLists.new ListNode(i);
			node.next = node2;
			node = node.next;
		}
		root = root.next;
		return root;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int j = 0;
		ListNode root = null;
		for (; j < lists.length; j++) {
			if (lists[j] != null) {
				root = lists[j];
				break;
			}
		}
		
//		ListNode tail = lists[j];
		ListNode node;
		ListNode pointer = root;
		ListNode record;
		for (int i = j + 1; i < lists.length; i++) {
			node = lists[i];
			pointer = root;
			while (node != null) {
//				System.out.println(node.val);
				
				while (true) {
//					System.out.println(pointer.val);
					if (node.val <= root.val) {
//						System.out.println(root.val);
//						System.out.println(node.val);
//						System.out.println("Enter first judge");
						record = node;
						node = node.next;
						record.next = pointer;
						root = record;
//						System.out.println(record.next.val);
						break;
					} else if (pointer.next != null && pointer.val <= node.val 
							&& pointer.next.val >= node.val) {
//						System.out.println("Enter second judge");
						record = node;
						node = node.next;
						record.next = pointer.next;
						pointer.next = record;
//						System.out.println(record.next.val);
						break;
					} else if (pointer.next == null && pointer.val < node.val) {
//						System.out.println("Enter third judge");
						record = node;
						node = node.next;
						pointer.next = record;
						break;
					}
					pointer = pointer.next;
				}
//				pointer = pointer.next;
//				node = node.next;
			}
		}
		return root;
	}
	
	private static ListNode buildList(int[] nums) {
		MergeKLists mergeKLists = new MergeKLists();
		ListNode root = mergeKLists.new ListNode(0);
		ListNode node = root;
		for (int i : nums) {
			ListNode node2 = mergeKLists.new ListNode(i);
			node.next = node2;
			node = node.next;
		}
		root = root.next;
		return root;
		
		
	}
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			// TODO �Զ����ɵĹ��캯�����
			val = x;
		}
	}

}
