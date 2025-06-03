package com.vishnu;
import java.time.LocalDate;
import java.util.*;
public class Main2 {
  static Map<String, String> parent = new HashMap<>();
  public static void main(String[] args) {
    LocalDate ld = LocalDate.now();
    System.out.println(String.valueOf(ld));
    //System.out.println(knightProbability(3,2,0,0));
//    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Arrays.asList(
//        new ArrayList<>(Arrays.asList(2,3,1)),
//        new ArrayList<>(Arrays.asList(0)),
//        new ArrayList<>(Arrays.asList(0,4)),
//        new ArrayList<>(Arrays.asList(0)),
//        new ArrayList<>(Arrays.asList(2))
//    ));
//    int[] dist = new int[5];
//    for(int i=0; i<5; i++){
//      dist[i] = (int)1e9;
//    }
//    ArrayList<Integer> ans = new ArrayList<Integer>();
//    boolean[] visited = new boolean[adj.size()];
//    Queue<Integer> queue = new LinkedList<>();
//    queue.add(0);
//    visited[0] = true;
//    while(!queue.isEmpty()){
//      Integer temp = queue.poll();
//      ans.add(temp);
//      for(Integer it : adj.get(temp)){
//        if(!visited[it]){
//          queue.add(it);
//          visited[it] = true;
//        }
//      }
//    }
//    System.out.println(ans);
//    List<List<String>> accounts = new ArrayList<>();
//    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
//    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
//    accounts.add(Arrays.asList("Mary", "mary@mail.com"));
//    accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
//    List<List<String>> merged = accountsMerge(accounts);
//
//    for (List<String> acc : merged) {
//      System.out.println(acc);
//    }
  }

  public static List<List<String>> accountsMerge(List<List<String>> accounts){
    Map<String, String> emailToName = new HashMap<>();
    for(List<String> account: accounts){
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        parent.putIfAbsent(email,email);
        emailToName.put(email, name);
        if(i>1){
          union(account.get(1),email);
        }
      }
    }
    Map<String, List<String>> rootGroups = new HashMap<>();
    for(String email: parent.keySet()){
      String root = find(email);
      rootGroups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
    }
    List<List<String>> result = new ArrayList<>();
    for(List<String> group: rootGroups.values()){
      Collections.sort(group);
      String name = emailToName.get(group.get(0));
      List<String> merged = new ArrayList<>();
      merged.add(name);
      merged.addAll(group);
      result.add(merged);
    }
    return result;
  }
  private static String find(String x){
    if(!parent.get(x).equals(x)){
      parent.put(x, find(parent.get(x)));
    }
    return parent.get(x);
  }

  private static void union(String x, String y){
    String px = find(x);
    String py = find(y);
    if(!px.equals(py)){
      parent.put(py, px);
    }
  }

  public static double knightProbability(int N, int K, int row, int col) {
    double[][][] dp = new double[K + 1][N][N];
    dp[0][row][col] = 1;

    int[][] dirs = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    for (int k = 1; k <= K; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
              dp[k][i][j] += dp[k - 1][ni][nj] / 8.0;
            }
          }
        }
      }
    }

    double result = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        result += dp[K][i][j];

    return result;
  }
}
