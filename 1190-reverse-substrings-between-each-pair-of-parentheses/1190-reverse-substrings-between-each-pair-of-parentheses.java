class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder reversed = new StringBuilder();

        //push to stack
        for(char c : s.toCharArray()){
            if(c != ')'){ //push to stack
                stack.push(c);
            }else{  //when u encounter ) reverse the string upto (
                while(stack.peek() != '('){  //pop and store in reversed
                    reversed.append(stack.pop());
                }
                stack.pop();  //remove the (
                while(reversed.length() != 0){  //push the reversed string back to stack
                    for(int i = 0 ; i <reversed.length() ; i++){
                        stack.push(reversed.charAt(i));
                    }
                    reversed.setLength(0); //clear reversed string
                }
            }
        } //this function already returns the reversed string

        //when you pop , it's reversed again
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        //reverse once again to get the actal answer
        return reversed.reverse().toString(); 
        
       
    }
}