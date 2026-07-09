class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
      int first = -1 ; //first mismatched index
      int second = -1; // second mismatched index

      for(int i=0; i<s1.length(); i++){
        if(s1.charAt(i) != s2.charAt(i)){
            if(first == -1){
                first=i;
            }else if(second == -1){
                second=i;
            }else{
                return false;  //more than 2 mismatch
            }
        }
      }

      if(first == -1) return true; //no mismatch

      if(second == -1) return false; //only 1 mismatch

      return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);

    }
}