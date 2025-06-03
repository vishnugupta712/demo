package com.vishnu.mathsBitsAndRecursion;
//Some people(n) are standing in a queue.
//  A selection process follows a rule where people standing on even positions are selected.
//  Of the selected people a queue is formed and again out of these only people on even position are selected.
//  This continues until we are left with one person.
//  Find out the position of that person in the original queue.
//logic : find highest power of 2
//TC And SC : O(1)
public class FindingPositionInQueue {
  static long nthPosition(long n){
    if((n&(n-1)) == 0){
      return n;
    }
    return 1 << (Long.toBinaryString(n).length()-1);
  }

  public static void main(String[] args) {
    System.out.println("positon in queue :"+ nthPosition(109));
  }
}
