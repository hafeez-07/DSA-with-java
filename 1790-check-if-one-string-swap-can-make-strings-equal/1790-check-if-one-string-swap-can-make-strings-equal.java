class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] freq = new int[26];
        int diff =0;
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
            if(s1.charAt(i) != s2.charAt(i)) diff++;
        }
        //1. if freq of letters in both string is not same , then we cannot swap and find answer
        for(int x: freq){
            if(x!=0)  return false;  
        }

        //2.if char diff is 0 or 2 , then its true , we can swap 2 letters and make string equal
       if(diff == 0 || diff == 2) return true;

       return false;

    }
}