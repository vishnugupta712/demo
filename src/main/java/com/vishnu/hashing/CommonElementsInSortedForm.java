package com.vishnu.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CommonElementsInSortedForm {
public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking total count-1 of elements 
		    int n=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-1
		    ArrayList<Integer>v1=new ArrayList<>();
		    
		    //adding elements to the ArrayList-1
		    for(int i=0;i<n;i++)
		    {
		        v1.add(sc.nextInt());
		    }
		    
		    //taking total count-2 of elements 
		    int m=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-2
		    ArrayList<Integer>v2=new ArrayList<>();
		    
		    //adding elements to the ArrayList-2
		    for(int i=0;i<m;i++)
		    {
		        v2.add(sc.nextInt());
		    }
		    
		    //calling the method common_element
		    //and passing ArrayList 1, 2 as arguments
		    //and storing the results in a new ArrayList
		    ArrayList<Integer>ans=common_element(v1, v2);
		    
		    //printing the elements of the new ArrayList
		    for(int i:ans)
		    System.out.print(i+" ");
		    
		    System.out.println();
		}
	}
	

 // } Driver Code Ends


//User function Template for Java

public static ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2)
{
    //Your code here
    ArrayList<Integer> list= new ArrayList<>();
    HashMap<Integer,Integer> map= new HashMap<>();
    
    for(int i=0;i<v1.size();i++){
        if(map.containsKey(v1.get(i))){
            map.put(v1.get(i),map.get(v1.get(i))+1);
        }
        else{
            map.put(v1.get(i),1);
        }
    }
    
    for(int i=0;i<v2.size();i++){
        if(map.containsKey(v2.get(i))){
            int k=map.get(v2.get(i));
            if(k>0){
            list.add(v2.get(i));
            map.put(v2.get(i),k-1);
            }
        }
    }
    Collections.sort(list);
    return list;
}
}
