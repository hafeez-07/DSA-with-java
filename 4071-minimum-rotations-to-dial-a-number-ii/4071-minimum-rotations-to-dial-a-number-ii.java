class Solution {
    public int minRotations(int n, String s) {
        char[] arr = s.toCharArray();
        int minCount = Integer.MAX_VALUE;

        int count = getDialCount(arr);
        minCount = Math.min(count,minCount);

        //for each value k , remove old boundary and add new boundary
        //when k =0 , its complate reverse array - seperate condition 

        for(int k = 1; k < n ; k++ ){
            int before = arr[k-1] - '0';
            int current = arr[k] - '0';
            int last = arr[n - 1] - '0';

            int oldBoundary = Math.min(Math.abs(before-current), 10-Math.abs(before-current));
            int newBoundary = Math.min(Math.abs(before-last),10-Math.abs(before-last));

            int newCount = count - oldBoundary + newBoundary;
            minCount = Math.min(minCount , newCount);

        }

        //special case when k = 0
        int before = 0;
        int current = arr[0] - '0';
        int last = arr[n-1] - '0';

        int oldBoundary = Math.min(Math.abs(before-current),10-Math.abs(before-current));
        int newBoundary = Math.min(Math.abs(before-last),10-Math.abs(before-last));

        int newCount = count - oldBoundary + newBoundary;
        minCount = Math.min(minCount , newCount);

        return minCount;
    }

    

    public int getDialCount(char[] arr){
        int first = 0;
        int result = 0;
        for(int i = 0 ; i <  arr.length ; i++){
            int second = arr[i] - '0';
            int diff = Math.abs(first - second) ;
            result += Math.min(diff, 10-diff);
            first = second;
        }
        return result;
    }
}