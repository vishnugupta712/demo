package com.vishnu.strings;

import java.util.Scanner;

public class ReverseWords {
	public static void main (String[] args) {
		//code
//	   Scanner sc=new Scanner(System.in);
//		int test=sc.nextInt();
//		while(test-- >0){
//		    String s=sc.next();
//		    System.out.println(reverseString(s));
//
//		}
		System.out.println(reverseString("i.like.this.program.very.much"));
	}
		static String reverseString(String s){
		    String[] strs = s.split("\\.");
		    for(int i = 0, j= strs.length-1 ; i < j; i++,j--) {
		        String temp = strs[j];
		        strs[j] = strs[i];
		        strs[i] = temp;
		    }
		    StringBuilder sb = new StringBuilder();
		    System.out.println(String.join(".", strs));
		    for(int i = 0 ; i < strs.length ; i++){
		        if(i<strs.length-1)
		            sb.append(strs[i]).append(".");
		        else 
		            sb.append(strs[i]);
		        
		    }
		    return sb.toString();
		}
}
