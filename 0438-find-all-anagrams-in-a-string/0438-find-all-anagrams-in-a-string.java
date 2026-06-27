class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()){
            return ans;
        }
        //window for p
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        int k=p.length();

        for(int i=0;i<k ; i++){
            freqP[p.charAt(i)-'a']++;
        }
        //initial s window
        for(int i=0;i<k;i++){
            freqS[s.charAt(i)-'a']++;
        }

        if(isSame(freqS,freqP)){
            ans.add(0);
        }

        //slide window
        for(int i=k;i<s.length();i++){
            freqS[s.charAt(i)-'a']++;
            freqS[s.charAt(i-k)-'a']--;
            if(isSame(freqS,freqP)){
                ans.add(i-k+1);
            }
        }
        return ans;
        
    }

    public boolean isSame(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}