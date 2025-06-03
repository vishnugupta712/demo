package com.vishnu.array;

public class ElmentsGreaterAfterLesserBefore {
  //T.C O(n)
  //S.C O(n)
	static int findElement(int[] a, int n)
    {
      int max = a[0], ans = a[1];                 //Assigning the max and ans as zeroth and first subscript respectively
      boolean reviseAns = false;                  //flag to set when we find a smaller element on right side of our max
      for(int i = 1; i<a.length; i++){
        if(a[i] >= max){
          max = a[i];                          //keep updating the max element when a[i] is greater or equal
          if(reviseAns && i != n-1){    //Note, the last element cannot be the answer so check i != a.length-1
            ans = a[i];         //our answer is the first occurring element, check array example {5,1,7,9,19}
            reviseAns = false;
          }
        }
        else {
          reviseAns = true;
          ans = -1;     // ans is set to -1 when there is a smaller element found on right side of max
        }
      }
      return ans;
    }
	public static void main(String[] args) {
		int[]arr= {10, 6, 3, 1, 5, 11, 6, 1, 11, 12};
		System.out.println(findElement(arr,arr.length));;
	}
}
