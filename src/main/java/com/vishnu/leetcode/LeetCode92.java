package com.vishnu.leetcode;

public class LeetCode92 {
  public static void main(String[] args) {
    // Test case 1: Palindrome list
    ListNode92 head1 = new ListNode92(1);
    head1.next = new ListNode92(2);
    head1.next.next = new ListNode92(3);
    head1.next.next.next = new ListNode92(4);
    head1.next.next.next.next = new ListNode92(5);
    System.out.println("Is the list palindrome? " + reverseBetween(head1, 2, 4)); // Expected: true
  }
  private static ListNode92 reverseBetween(ListNode92 head, int m, int n) {
    // Edge case: If head is null, return null
    if (head == null) return null;

    // Create a dummy node that points to the head
    ListNode92 dummy = new ListNode92(0);
    dummy.next = head;
    ListNode92 prev = dummy;

    // Step 1: Move prev to the node just before the m-th node
    for (int i = 1; i < m; i++) {
      prev = prev.next;
    }

    // Step 2: Reverse the sublist between m and n
    ListNode92 start = prev.next;  // m-th node
    ListNode92 then = start.next;  // (m+1)-th node

    for (int i = 0; i < n - m; i++) {
      start.next = then.next;  // Remove 'then' from the list
      then.next = prev.next;   // Insert 'then' at the beginning of the list
      prev.next = then;        // Move prev to 'then'
      then = start.next;       // Move 'then' to the next node
    }

    return dummy.next;
  }
}
class ListNode92 {
  int val;
  ListNode92 next;
  ListNode92(int x) { val = x; }
}

