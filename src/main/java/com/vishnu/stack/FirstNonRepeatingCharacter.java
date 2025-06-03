package com.vishnu.stack;

public class FirstNonRepeatingCharacter {
  public static String FirstNonRepeating(String A)
  {
    // code here
    char c[]=A.toCharArray();
    int cnt[][]=new int[26][2];
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<c.length;i++){
      cnt[c[i]-'a'][0]++;
      cnt[c[i]-'a'][1]=i;
      int q=-1;
      int mn=Integer.MAX_VALUE;
      for(int j=0;j<26;j++){
        if(cnt[j][0]==1 && cnt[j][1]<mn){
          mn=cnt[j][1];
          q=j;
        }
      }
      if(q==-1){
        sb.append("#");
      }else{
        sb.append((char)(q+'a'));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String inp = "aabc";
    System.out.println("first non repeating character : "+ FirstNonRepeating(inp));
  }
}
