package com.vishnu.stack;

import java.util.Stack;

public class ParenthesisChecker {
  //Function to check if opening and closing brackets are of same type.
  static boolean cmp(char b, char c)
  {
    if(b=='{' && c=='}')
      return true;
    else if(b=='[' && c==']')
      return true;
    else if(b=='(' && c==')')
      return true;
    return false;
  }

  //Function to check if brackets are balanced or not.
  static boolean ispar(String x)
  {
    Stack<Character> s = new Stack<>();

    //iterating over the string.
    for(int i=0;i<x.length();i++)
    {
      //if opening bracket is encountered, we push it into stack.
      if(x.charAt(i)=='[' || x.charAt(i)=='{' || x.charAt(i)=='(')
        s.push(x.charAt(i));

        //if closing bracket is encountered, we compare it with top of stack.
      else if(x.charAt(i)==']' || x.charAt(i)=='}' || x.charAt(i)==')')
      {
        //if top of stack has opening bracket of different
        //type, we return false.
        if(s.isEmpty() == true || !cmp(s.peek(),x.charAt(i)))
          return false;

          //else we pop the top element from stack.
        else
          s.pop();
      }
    }

    //if stack becomes empty, we return true else false.
    if(s.isEmpty() == true)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    String inpStr = "[{()}]";
    boolean res = ispar(inpStr);
    if(res){
      System.out.println("balanced parenthesis");
    }
    else{
      System.out.println("Unbalanced parenthesis");
    }
  }
}
