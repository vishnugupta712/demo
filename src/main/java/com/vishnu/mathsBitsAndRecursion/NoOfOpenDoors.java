package com.vishnu.mathsBitsAndRecursion;
//Consider a long alley with a N number of doors on one side. All the doors are closed initially. You move to and fro in the alley changing the states of the doors as follows: you open a door that is already closed and you close a door that is already opened. You start at one end go on altering the state of the doors till you reach the other end and then you come back and start altering the states of the doors again.
//  In the first go, you alter the states of doors numbered 1, 2, 3, , n.
//  In the second go, you alter the states of doors numbered 2, 4, 6
//  In the third go, you alter the states of doors numbered 3, 6, 9
//  You continue this till the Nth go in which you alter the state of the door numbered N.
//  You have to find the number of open doors at the end of the procedure.
//Input:
//  N = 2
//  Output:
//  1
//  Explanation:
//  Initially all doors are closed.
//  After 1st go, all doors will be opened.
//  After 2nd go second door will be closed.
//  So, Only 1st door will remain Open.
//open door logic : if there are odd number of divisors for provided door, respective door will end up as open And if
// it has even no of divisors , it will be closed at the end
//as for perfect sqaure , there are always odd no of divisors , for all other case, number has even no of divisors
public class NoOfOpenDoors {

  public static void main(String[] args) {
    int n= 101; //no of doors in ally
    System.out.println((int)Math.sqrt(n));
  }
}
