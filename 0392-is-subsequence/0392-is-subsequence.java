class Solution {
    public boolean isSubsequence(String s, String t) {
        int counter = s.length();
        int sLeft = 0;
        int sRight = s.length()-1;
        int tLeft = 0;
        int tRight = t.length()-1;

        while(sLeft <= sRight && tLeft <= tRight){
            //move both left pointers when u find a match
            if(s.charAt(sLeft) == t.charAt(tLeft)){
                sLeft++;
                tLeft++;
                counter--;
                if(counter==0) return true;
            //move both right pointer when u find a match
            }else if(s.charAt(sRight) == t.charAt(tRight)){
                sRight--;
                tRight--;
                counter--;
                if(counter==0) return true;
                //move only t pointer to search matching char in order
            }else{
                tLeft++;
            }
        }
        //check whether u have found the subsequence
        return counter==0;
    }
}