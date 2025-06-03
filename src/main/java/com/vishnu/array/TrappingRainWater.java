package com.vishnu.array;

public class TrappingRainWater {
  /*
    time complexity : O[n]
    space complexity : O[n]
   */
  private static int trap(int[] height) {
    int len = height.length;
    int []lMax = new int[len];
    int []rMax = new int[len];
    int res = 0;
    lMax[0] = height[0];
    for(int i = 1 ; i < len ; i++){
      lMax[i] = Math.max(height[i], lMax[i-1]);
    }
    rMax[len-1] = height[len-1];
    for(int i = len-2 ; i >= 0 ; i--){
      rMax[i] = Math.max(height[i], rMax[i+1]);
    }
    for(int i = 0 ; i < len ; i++){
      res = res + (Math.min(lMax[i], rMax[i])-height[i]);
    }
    return res;
  }

  /*
    time complexity : O[n]
    space complexity : O[1]
   */
  private static int trapWithConstantSpace(int[] h) {
    int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
    while (l < r) {
      lmax = Math.max(lmax, h[l]);
      rmax = Math.max(rmax, h[r]);
      ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
    }
    return ans;
  }

  public static void main(String[] args) {
    int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    int result = trap(height);
    System.out.println("Trapped rain water units are "+ result);
    result = trapWithConstantSpace(height);
    System.out.println("Trapped rain water units with constant space are "+ result);
  }
}
