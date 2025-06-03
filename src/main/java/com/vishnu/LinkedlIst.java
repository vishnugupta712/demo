package com.vishnu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.w3c.dom.Node;

public class LinkedlIst {

  static int height(Node node) {
    if (node == null)
      return 0;
    else {

      // compute the height of each subtree
      int lheight = height(node.left);
      int rheight = height(node.right);

      // use the larger one
      return Math.max(lheight, rheight) + 1;
    }
  }

  static void printGivenLevel(Node root, int level,
                              List<Integer> levelNodes) {
    if (root == null)
      return;
    if (level == 1)
      levelNodes.add(root.data);
    else if (level > 1) {
      printGivenLevel(root.left, level - 1, levelNodes);
      printGivenLevel(root.right, level - 1, levelNodes);
    }
  }

  // Function to return level order traversal as a list of
  // lists
  static List<List<Integer> > levelOrder(Node root) {
    List<List<Integer> > result = new ArrayList<>();
    int h = height(root);
    for (int i = 1; i <= h; i++) {
      List<Integer> levelNodes = new ArrayList<>();
      printGivenLevel(root, i, levelNodes);
      result.add(levelNodes);
    }
    return result;
  }

  public static int countNodes(Node root) {
    if(root==null){
      return 0;
    }
    int height = getHeight(root);
    if(height==0){
      return 1;
    }
    int left=0, right = (int)Math.pow(2, height)-1;
    while(left <= right){
      int mid = left + (right-left)/2;
      if(isExists(root, height, mid)){
        left = mid+1;
      }
      else{
        right = mid-1;
      }
    }
    return (int)Math.pow(2, height)-1 + left;
  }

  private static boolean isExists(Node node, int height, int index){
    int left=0, right = (int)Math.pow(2, height)-1;
    for(int i=0; i< height ; i++){
      int mid = left + (right-left)/2;
      if(index <= mid){
        node = node.left;
        right = mid;
      }
      else{
        node = node.right;
        left = mid+1;
      }
    }
    return node != null;
  }

  private static int getHeight(Node node){
    int height=0;
    while(node.left != null){
      height++;
      node =node.left;
    }
    return height;
  }

  private static List<TreeNode> buildTrees(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftSubtree = buildTrees(start, i - 1);
      List<TreeNode> rightSubtree = buildTrees(i + 1, end);
      for (TreeNode left : leftSubtree) {
        for (TreeNode right : rightSubtree) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          result.add(root);
        }
      }
    }

    return result;
  }

  private static String treeToString(TreeNode root) {
    if (root == null) return "null";
    return root.val + " (" + treeToString(root.left) + ", " + treeToString(root.right) + ")";
  }

  // Function to print List<TreeNode>
  public static void printTreeList(List<TreeNode> trees) {
    int count = 1;
    for (TreeNode root : trees) {
      System.out.println("Tree " + count + ": " + treeToString(root));
      count++;
    }
  }

  public static void main(String[] args) {

    // Binary Tree Representation
    //
    //       1
    //     /   \
    //    2     3
    //   / \
    //  4   5

//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//    root.right.left = new Node(6);
//
////    List<List<Integer> > result = levelOrder(root);
////
////    for (List<Integer> level : result) {
////      for (int val : level) {
////        System.out.print(val + " ");
////      }
////      System.out.println();
////    }
//
////    System.out.println(countNodes(root));
//    int [] nums= {-10, -3, 0, 5, 9};
//    System.out.println(sortedArrayToBST(nums));

    List<TreeNode> treeNodes = buildTrees(1, 3);
    System.out.println(treeNodes);
//    TreeNode treeNode = new TreeNode(10);
//    treeNode.left = new TreeNode(5);
//    treeNode.right = new TreeNode(-3);
//    treeNode.left.left = new TreeNode(3);
//    treeNode.left.right = new TreeNode(2);
//    treeNode.right.right = new TreeNode(11);
//    treeNode.left.left.left = new TreeNode(3);
//    treeNode.left.left.right = new TreeNode(-2);
//    treeNode.left.right.right = new TreeNode(1);
//    int targetSum = 8;
//
//    Result result = iterativePathSum(treeNode, targetSum);
//    System.out.println("Total Paths: " + result.count);
//    System.out.println("Matching Paths: " + result.paths);
  }

  public static Node sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private static Node helper(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }

    // Instead of mid, we take the first element (left) as the root of the subtree
    Node root = new Node(nums[left]);

    // Recursively build the right and left subtrees
    root.left = helper(nums, left + 1, right); // Left subtree
    root.right = helper(nums, left + 1, right); // Right subtree

    return root;
  }


  static class Node {
    int data;
    Node left, right;

    Node(int key) {
      data = key;
      left = null;
      right = null;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int key) {
      val = key;
      left = null;
      right = null;
    }
  }

  static class Result {
    int count;
    List<List<Integer>> paths;

    Result() {
      this.count = 0;
      this.paths = new ArrayList<>();
    }
  }

  public static Result iterativePathSum(TreeNode root, int targetSum) {
    Result result = new Result();
    if (root == null) return result;

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Long> sumQueue = new LinkedList<>();
    Queue<Map<Long, Integer>> mapQueue = new LinkedList<>();
    Queue<List<Integer>> pathQueue = new LinkedList<>();

    nodeQueue.offer(root);
    sumQueue.offer(0L);

    Map<Long, Integer> initialMap = new HashMap<>();
    initialMap.put(0L, 1);
    mapQueue.offer(initialMap);

    pathQueue.offer(new ArrayList<>());

    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      long currSum = sumQueue.poll() + node.val;
      Map<Long, Integer> currPrefixMap = mapQueue.poll();
      List<Integer> currentPath = new ArrayList<>(pathQueue.poll());

      // Add current node to path
      currentPath.add(node.val);

      // Count valid paths
      int count = currPrefixMap.getOrDefault(currSum - targetSum, 0);
      result.count += count;

      // Store exact valid paths
      if (currPrefixMap.containsKey(currSum - targetSum)) {
        List<Integer> validPath = new ArrayList<>();
        long sum = currSum;
        for (int i = currentPath.size() - 1; i >= 0; i--) {
          validPath.add(0, currentPath.get(i));
          sum -= currentPath.get(i);
          if (sum == currSum - targetSum) {
            result.paths.add(new ArrayList<>(validPath));
          }
        }
      }

      // Create a new map for children (avoid modifying parent's map)
      Map<Long, Integer> newMap = new HashMap<>(currPrefixMap);
      newMap.put(currSum, newMap.getOrDefault(currSum, 0) + 1);

      // Process children
      if (node.left != null) {
        nodeQueue.offer(node.left);
        sumQueue.offer(currSum);
        mapQueue.offer(newMap);
        pathQueue.offer(new ArrayList<>(currentPath));
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        sumQueue.offer(currSum);
        mapQueue.offer(newMap);
        pathQueue.offer(new ArrayList<>(currentPath));
      }
    }

    return result;
  }


}
