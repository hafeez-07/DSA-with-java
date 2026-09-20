class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; //s pointer
        int j = 0;//t pointer

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}