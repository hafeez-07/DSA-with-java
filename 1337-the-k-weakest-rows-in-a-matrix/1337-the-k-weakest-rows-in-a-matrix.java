class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]){   //if count is same , sort by index -> place larger value at top
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(b[0],a[0]); // sort by count -> place larger value at top
        });
        int[] result = new int[k];

        for(int i=0 ; i < mat.length ; i++){
            int count = 0;
            for(int j=0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1){
                    count++;
                }else{
                    break;
                }
            }
            maxHeap.offer(new int[]{count,i}); //if all rows are 1
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        for(int i= k-1 ; i >=0 ; i--){
            result[i] = maxHeap.poll()[1];
        }

        return result;

    }

  
}