package com.vishnu.strings;

public class StrStrImpl {
	public static int strstr(String s, String x)
  {
      if (x.length() == 0){
          return 0;
      }

      //iterating over given string s to search for string x.
      for (int i = 0; i < s.length(); i ++)
      {
          if (i + x.length() > s.length()){
              return -1;
          }

          //checking for string x from current index i in the string s.
          for (int j = 0; j < x.length(); j ++)
          {
              //if any character doesn't match, we break the loop.
              //if string x is found, then we return the starting index.
              if ( s.charAt(i + j) == x.charAt(j) )
              {
                  if (j == (x.length() -1)){
                      return i;
                  }
              }
              else
                  break;
          }
      }
      //returning -1 if string x is not found.
      return -1;
  }
 
    // Driver code
    public static void main(String[] args)
    {
        String str = "GeeksForGeeks";
        String subStr = "For";
       
        // Function call
        int index = strstr(str, subStr);
        System.out.println(index);
    }
}
