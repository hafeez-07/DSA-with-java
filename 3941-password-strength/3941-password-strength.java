class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set = new HashSet<>();
        for(char c : password.toCharArray()){
            set.add(c);
        }
        int strength = 0;
        for(char c : set){
            //if lowercase
            if(Character.isLowerCase(c)){
                strength += 1;
            }else if (Character.isUpperCase(c)){
                strength += 2;
            }else if(Character.isDigit(c)){
                strength += 3;
            }else{
                strength += 5;
            }
        }
        return strength;
    }
}