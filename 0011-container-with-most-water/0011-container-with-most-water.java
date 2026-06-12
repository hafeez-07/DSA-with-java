class Solution {
    public int maxArea(int[] height) {
          int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            int h = (height[left] < height[right]) ? height[left] : height[right];
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }
}