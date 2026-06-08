class Solution {

    public int findKthLargest(int[] nums, int k) {

        int targetIndex = nums.length - k ;
        int low =0;
        int high = nums.length-1;
        return quickSelect(nums,low,high,targetIndex);
        
    }

    public int quickSelect ( int[] nums , int low , int high , int targetIndex){
        if(low == high){
            return nums[low];
        }
       
        int sortedIndex = partition(nums,low,high);
        if(targetIndex==sortedIndex){
            return nums[sortedIndex];
        }else if (targetIndex<sortedIndex){
            return quickSelect(nums,low,sortedIndex-1,targetIndex);
        }else{
            return quickSelect(nums,sortedIndex+1 , high , targetIndex);
        }

    }

    public int partition(int[] nums , int low , int high){
         int i = low-1;
        int pivot = nums[high];
        for(int j =low; j<high ; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}