class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set1 = new HashSet<>();
       HashSet<Integer> ans = new HashSet<>();
    
        for(int x : nums1){
            set1.add(x);
        }
        for(int x : nums2){
            if(set1.contains(x)){
                ans.add(x);
            }
        }

           int[] arr = new int[ans.size()];
           int i=0;
           for(int x : ans){
            arr[i++]=x;
           }
           return arr;
    }
}