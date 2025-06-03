package com.vishnu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode437 {

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(10);
    treeNode.left = new TreeNode(5);
    treeNode.right = new TreeNode(-3);
    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(2);
    treeNode.right.right = new TreeNode(11);
    treeNode.left.left.left = new TreeNode(3);
    treeNode.left.left.right = new TreeNode(-2);
    treeNode.left.right.right = new TreeNode(1);
    int targetSum = 8;

    Result result = iterativePathSum(treeNode, targetSum);
    System.out.println("Total Paths: " + result.count);
    System.out.println("Matching Paths: " + result.paths);
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
