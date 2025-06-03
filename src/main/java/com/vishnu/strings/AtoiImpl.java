package com.vishnu.strings;

public class AtoiImpl {
	public static int atoi(String str)
    {
 
        if (str.length() == 0)
        {
            return -1;
        }
        // Initialize sign as positive
        int sign = 1;
 
        // Initialize result
        int res = 0;
 
        // Initialize index of first digit
        int i = 0;
 
        // If number is negative,
        // then update sign
        if (str.charAt(i) == '-')
        {
            sign = -1;
 
            // Also update index of first digit
            i++;
        }
 
        // Iterate through all digits of input
        // string and update result
        for (; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
            {
                return -1;
            }
            res = res * 10
                  + Character.getNumericValue(
                        str.charAt(i));
        }
 
        return sign * res;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String str = "-134";
       
        // Function call
        int num = atoi(str);
        System.out.println(num);
    }
}
