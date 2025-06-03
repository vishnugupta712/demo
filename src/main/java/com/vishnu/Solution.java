package com.vishnu;

public class Solution {
//  class Node {
//    Node[] children = new Node[26];
//    int count = 0;
//  }
//
//  Node root = new Node();
//
//  // Insert all suffixes of a word into the Trie
//  private void insertSuffixes(String word) {
//    Node node = root;
//    for (char ch : word.toCharArray()) {
//      int index = ch - 'a';
//      if (node.children[index] == null) {
//        node.children[index] = new Node();
//      }
//      node = node.children[index];
//      node.count++;
//    }
//  }
//
//  // Count how many words have a suffix that ends with the given 'suff' string
//  public int suffixCount(String[] words, String suff) {
//    for (String word : words) {
//      insertSuffixes(new StringBuilder(word).reverse().toString()); // insert reversed word
//    }
//    Node node = root;
//    String reversedSuff = new StringBuilder(suff).reverse().toString(); // reverse the suffix
//
//    for (char ch : reversedSuff.toCharArray()) {
//      int index = ch - 'a';
//      if (node.children[index] == null) {
//        return 0;
//      }
//      node = node.children[index];
//    }
//    return node.count;
//  }

  class Node{
    Node[] child = new Node[2];
  }
  Node root = new Node();
  int maxSubarrayXOR(int N, int arr[]) {
    // code here
    insert(0);
    int maxXor = Integer.MIN_VALUE;
    int prefixXor = 0;
    for(int i=0; i<N; i++){
      prefixXor = prefixXor ^ arr[i];
      maxXor = Math.max(maxXor, query(prefixXor));
      insert(prefixXor);
    }
    return maxXor;
  }

  void insert(int num){
    Node node = root;
    for(int i=31; i>=0; i--){
      int bit = (num>>i) &1;
      if(node.child[bit]== null){
        node.child[bit] = new Node();
      }
      node = node.child[bit];
    }
  }

  int query(int num){
    Node node = root;
    int maxXor =0;
    for(int i=31; i>=0; i--){
      int bit = (num>>i) &1;
      int toggledBit = 1 - bit;
      if(node.child[toggledBit]!= null){
        maxXor |= (1<<i);
        node = node.child[toggledBit];
      }
      else{
        node = node.child[bit];
      }
    }
    return maxXor;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    // Test the function with an example
//    String[] words = {"abcabc", "bcabc", "abc", "bc", "c"};
//    String suff = "abc";

    int [] nums = {1,4,3};
    System.out.println(sol.maxSubarrayXOR(nums.length, nums));  // Output: 3
  }
}
