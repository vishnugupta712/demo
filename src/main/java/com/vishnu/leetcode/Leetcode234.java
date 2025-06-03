package com.vishnu.leetcode;

public class Leetcode234 {
  public static void main(String[] args) {
    // Test case 1: Palindrome list
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(2);
    head1.next.next.next.next = new ListNode(1);
    System.out.println("Is the list palindrome? " + isPalindrome(head1)); // Expected: true

    // Test case 2: Non-palindrome list
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    System.out.println("Is the list palindrome? " + isPalindrome(head2)); // Expected: false
  }

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true; // An empty or single-node list is always a palindrome
    }

    // Step 1: Find the middle of the linked list using slow and fast pointers
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the list
    ListNode secondHalf = reverseList(slow);

    // Step 3: Compare the first half and the second half
    ListNode firstHalf = head;
    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) {
        return false; // Mismatch found
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }

    return true; // All nodes matched
  }

  // Helper method to reverse the linked list
  private static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode nextNode = head.next;
      head.next = prev;
      prev = head;
      head = nextNode;
    }
    return prev;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

