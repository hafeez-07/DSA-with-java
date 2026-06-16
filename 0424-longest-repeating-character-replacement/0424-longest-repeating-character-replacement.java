class Solution {
    public int characterReplacement(String s, int k) {
        //store freq
        int[] freq = new int[26];
        //max freq
        int maxFreq = 0 ;
        //result
        int maxLength = 0;
        //left index of window
        int l=0;
        //start window traversing
        for(int r=0; r<s.length(); r++){
            freq[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r)-'A']);

            //shorten the window size from left
            if(r-l+1 - maxFreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxLength = Math.max(maxLength,r-l+1);

        }
        return maxLength;
        
    }
}