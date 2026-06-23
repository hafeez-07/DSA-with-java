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
            String word = words[i];
            if(pTOs.containsKey(c)){
                if(!pTOs.get(c).equals(word)){
                    return false;
                }
            }else{
                pTOs.put(c,word);
            }
            if(sTOp.containsKey(word)){
                if(!sTOp.get(word).equals(c)){
                    return false;
                }
            }else{
                sTOp.put(word,c);
            }
        }
        return true;
    }
}