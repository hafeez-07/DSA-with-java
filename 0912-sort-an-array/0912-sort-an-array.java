class Solution {
    public int[] sortArray(int[] nums) {

        int n = nums.length;
        
        //build heap
        for(int i = n/2-1; i>=0 ; i--){
            heapify(nums, n ,i);
        }

        //sort
        for(int i=n-1 ; i>0 ; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums,i,0);
        }

        return nums;
    }

    public static void heapify(int[] arr, int n , int i){
        int largest = i ;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr , n , largest);
        }
    }
}