class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int left = 0;
        int right = arr.length - 1;
        
        //move left towards the peak & it should exceed array index (n)
        while ( left < arr.length - 1 && arr[left] < arr[left + 1]) left++;

        //move right towards the peak & it should exceed array index (0)
        while(right > 0 && arr[right] < arr[right-1]) right--;

        //check whether they have reached same peak
        return left == right && left != arr.length - 1 && right != 0; //peak cannot be left end or right end
    }
}