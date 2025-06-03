package com.vishnu.linkedlist;

class ListNode {
  int value; // Value of the node.
  ListNode next; // Reference to the next node.

  // Constructor to create a node with specified value and next node reference.
  ListNode(int val, ListNode next) {
    this.value = val;
    this.next = next;
  }

  // Constructor to create a node with specified value.
  ListNode(int val) {
    this(val, null);
  }
}
public class MyLinkedList {
  private ListNode dummyHead = new ListNode(0);
  private int size; // Number of elements in the linked list.

  // Constructor for initializing the linked list.
  public MyLinkedList() {
  }

  // Method to get the value of the index-th node in the linked list. If the index is invalid, return -1.
  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1; // Index out of bounds.
    }
    ListNode current = dummyHead.next;
    while (index-- > 0) {
      current = current.next;
    }
    return current.value;
  }

  // Method to add a node of value val before the first element of the linked list.
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  // Method to append a node of value val to the last element of the linked list.
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  // Method to add a node of value val before the index-th node in the linked list.
  public void addAtIndex(int index, int val) {
    // If index is greater than the size, the node will not be inserted.
    if (index > size) {
      return;
    }
    ListNode precursor = dummyHead;
    while (index-- > 0) {
      precursor = precursor.next;
    }
    precursor.next = new ListNode(val, precursor.next);
    size++; // Increase list size.
  }

  // Method to delete the index-th node in the linked list, if the index is valid.
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return; // Index out of bounds.
    }
    ListNode precursor = dummyHead;
    while (index-- > 0) {
      precursor = precursor.next;
    }
    ListNode toDelete = precursor.next;
    precursor.next = toDelete.next;
    toDelete.next = null; // Help the garbage collector by removing references.
    size--; // Decrease list size.
  }

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1,2);
    myLinkedList.get(1);
    myLinkedList.deleteAtIndex(1);
    myLinkedList.get(1);
    System.out.println("myLinkedList "+ myLinkedList);
  }
}
