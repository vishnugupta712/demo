package com.vishnu.linkedlist;

public class FlattenLinkedListIterative {
  // Function to merge two sorted linked lists
  private static FlattenNode mergeTwoLists(FlattenNode a, FlattenNode b) {
    FlattenNode dummy = new FlattenNode(0);
    FlattenNode current = dummy;

    while (a != null && b != null) {
      if (a.data <= b.data) {
        current.bottom = a;
        a = a.bottom;
      } else {
        current.bottom = b;
        b = b.bottom;
      }
      current = current.bottom;
    }

    // Attach remaining FlattenNodes
    if (a != null) {
      current.bottom = a;
    }
    if (b != null) {
      current.bottom = b;
    }

    return dummy.bottom;
  }

  // Function to flatten the linked list
  public static FlattenNode flatten(FlattenNode root) {
    if (root == null || root.next == null) {
      return root;
    }

    // Use an iterative approach to merge all linked lists
    FlattenNode current = root;
    FlattenNode merged = null; // Head of the flattened list

    while (current != null) {
      merged = mergeTwoLists(merged, current); // Merge current list into the result
      current = current.next; // Move to the next sub-list
    }

    return merged; // Return the head of the flattened list
  }

  // Utility function to print the flattened list
  public static void printList(FlattenNode head) {
    FlattenNode current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.bottom;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Example Linked List construction
    FlattenNode head = new FlattenNode(5);
    head.bottom = new FlattenNode(7);
    head.bottom.bottom = new FlattenNode(8);
    head.bottom.bottom.bottom = new FlattenNode(30);

    head.next = new FlattenNode(10);
    head.next.bottom = new FlattenNode(20);

    head.next.next = new FlattenNode(19);
    head.next.next.bottom = new FlattenNode(22);
    head.next.next.bottom.bottom = new FlattenNode(50);

    head.next.next.next = new FlattenNode(28);
    head.next.next.next.bottom = new FlattenNode(35);
    head.next.next.next.bottom.bottom = new FlattenNode(40);
    head.next.next.next.bottom.bottom.bottom = new FlattenNode(45);

    // Flatten the list
    FlattenNode flattenedList = flatten(head);

    // Print the flattened list
    printList(flattenedList);
  }
}

class FlattenNode {
  int data;
  FlattenNode next;
  FlattenNode bottom;

  FlattenNode(int data) {
    this.data = data;
    this.next = null;
    this.bottom = null;
  }
}


