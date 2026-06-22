class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sTOt = new HashMap<>();
        HashMap<Character,Character> tTOs = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sTOt.containsKey(c1)){
                if(sTOt.get(c1) != c2){
                    return false;
                }
            }else{
                sTOt.put(c1,c2);
            }

            if(tTOs.containsKey(c2)){
                if(tTOs.get(c2) != c1){
                    return false;
                }

            }else{
                tTOs.put(c2,c1);
            }
        }
    return true;
    }
}