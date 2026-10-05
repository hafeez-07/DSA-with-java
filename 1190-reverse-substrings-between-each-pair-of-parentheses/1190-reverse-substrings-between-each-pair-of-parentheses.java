class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();  //to store ( index
        StringBuilder result = new StringBuilder();  //to store result
        int[] pair = new int[n];  //store pairs like 0 -> 13 , 13 -> 0  i.e (-index 0  )- index 13
        
        //construct pairs   
        for(int i = 0 ; i <n ; i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int open = stack.pop(); //get recent open paranthesis - pair for current ) closing 
                pair[open] = i;
                pair[i] =open;
            }
        }

        int direction = 1; //we change direction to traverse the string in reverse and correct path when encountering paranthesis

        //construct result 
        for(int i = 0 ; i < n ; i += direction){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = pair[i];
                direction = -direction;
            }else{
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}