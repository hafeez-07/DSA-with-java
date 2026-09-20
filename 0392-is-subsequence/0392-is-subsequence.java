class Solution {
    public boolean isSubsequence(String s, String t) {
        int counter = s.length();
        int sLeft = 0;
        int sRight = s.length()-1;
        int tLeft = 0;
        int tRight = t.length()-1;

        while(sLeft <= sRight && tLeft <= tRight){
            if(s.charAt(sLeft) == t.charAt(tLeft)){
                sLeft++;
                tLeft++;
                counter--;
                if(counter==0) return true;
            }else if(s.charAt(sRight) == t.charAt(tRight)){
                sRight--;
                tRight--;
                counter--;
                if(counter==0) return true;
            }else if(s.charAt(sLeft) != t.charAt(tLeft)){
                tLeft++;
            }else if(s.charAt(sRight) != t.charAt(tRight)){
                tRight--;
            }
        }
        return counter==0;
    }
}