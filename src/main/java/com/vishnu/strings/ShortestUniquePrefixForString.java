package com.vishnu.strings;

public class ShortestUniquePrefixForString {
  class Node {
    Node[] children = new Node[26];
    int count = 0;
  }

  Node root = new Node();

  private void insert(String word) {
    Node node = root;
    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (node.children[index] == null) {
        node.children[index] = new Node();
      }
      node = node.children[index];
      node.count++;
    }
  }

  private String getPrefix(String word) {
    Node node = root;
    StringBuilder prefix = new StringBuilder();

    for (char ch : word.toCharArray()) {
      prefix.append(ch);
      int index = ch - 'a';
      node = node.children[index];

      if (node.count == 1) {
        // Unique path found
        break;
      }
    }

    return prefix.toString();
  }

  public String[] findPrefixes(String[] arr, int n)
  {
    for (String word : arr) {
      insert(word);
    }

    String[] result = new String[n];

    for (int i = 0; i < n; i++) {
      result[i] = getPrefix(arr[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    ShortestUniquePrefixForString sol = new ShortestUniquePrefixForString();
    String[] words = {"zebra", "dog", "duck", "dove"};
    System.out.println(sol.findPrefixes(words, 4));  // Output: 3
  }
}
