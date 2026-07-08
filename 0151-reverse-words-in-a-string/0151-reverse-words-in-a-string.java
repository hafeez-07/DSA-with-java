class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        int left =0;
        int right = arr.length-1;
        while(left < right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int i=0; i<arr.length; i++){
            if(i>0) sb.append(" ");
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}