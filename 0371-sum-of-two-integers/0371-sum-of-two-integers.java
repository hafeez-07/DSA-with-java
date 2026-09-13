class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1; //find carry
            a = a ^ b;  //add without carry
            b = carry;  //move carry to b
        }
        return a;
    }
}