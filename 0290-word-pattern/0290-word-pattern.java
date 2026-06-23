class Solution {
    public boolean wordPattern(String pattern, String s) {
       
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }

        HashMap<Character,String> pTOs = new HashMap<>();
        HashMap<String , Character> sTOp = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(pTOs.containsKey(c)){
                if(!pTOs.get(c).equals(words[i])){
                    return false;
                }
            }else{
                pTOs.put(c,words[i]);
            }
            if(sTOp.containsKey(words[i])){
                if(!sTOp.get(words[i]).equals(c)){
                    return false;
                }
            }else{
                sTOp.put(words[i],c);
            }
        }
        return true;
    }
}