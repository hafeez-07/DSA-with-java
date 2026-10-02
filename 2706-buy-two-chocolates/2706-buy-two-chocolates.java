class Solution {
    public int buyChoco(int[] prices, int money) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int result = money;
        
        //first find the 2 cheapest choclates to buy - to minimize the sum of choclates
        for(int x : prices){
            if(x < smallest){
                secondSmallest = smallest;
                smallest = x ;
            }else if(x >= smallest && x < secondSmallest){
                secondSmallest = x;
            }
        }

        result = money - smallest - secondSmallest;

        return ( result >= 0 ? result : money);

    }
}