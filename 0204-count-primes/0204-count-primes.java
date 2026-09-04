class Solution {
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        //assume all nums are prime
        for(int i = 2 ; i< n ; i++){
            isPrime[i] = true;
        }

        for(int i = 2 ; i*i < n ;i++){
            if(isPrime[i]){
                for(int j = i * i ; j < n ; j += i ){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for(boolean x : isPrime){
            if(x){
                count++;
            }
        }

        return count;

    }
}