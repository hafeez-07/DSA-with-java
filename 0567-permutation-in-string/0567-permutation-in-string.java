class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        //use 2 freq array
        int[] freqStr = new int[26];
        int[] freqWindow= new int[26];

        //add freq of s1
        for(int i=0;i<s1.length();i++){
            freqStr[s1.charAt(i)-'a']++;
        }

        //add initial window freq
        for(int i=0;i<s1.length();i++){
            freqWindow[s2.charAt(i)-'a']++;
        }

        //compare 2 arrays
        if(checkFreq(freqStr,freqWindow)){
            return true;
        }

        //side window
        for(int i=s1.length();i<s2.length();i++){
            char c = s2.charAt(i);
            freqWindow[s2.charAt(i)-'a']++;
            freqWindow[s2.charAt(i-s1.length())-'a']--;
            if(checkFreq(freqStr,freqWindow)){
                return true;
            }
        }

        return false;
    }

    public boolean checkFreq(int[] arr1 , int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}