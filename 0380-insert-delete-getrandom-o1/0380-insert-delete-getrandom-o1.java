class RandomizedSet {

    HashMap<Integer,Integer> map;  //store array element index
    ArrayList<Integer> list ;  //store array

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        //if item is present
        if(map.containsKey(val)) return false;
        
        list.add(val);  //add val to array
        map.put(val,list.size()-1); //store val index ( value is added to end)

        return true;
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        //catch : when removing if the element is in the middle , it causes shifting -> so swap to end
        int valIndex = map.get(val); 
        int lastIndex = list.size()-1;
        if(valIndex != lastIndex){  //swap
            int lastIndexItem = list.get(lastIndex);
            list.set(valIndex,lastIndexItem); //place the last item in val's position

            //now last index gets deleted

            //update key of swapped item
            map.put(lastIndexItem,valIndex);
        }
      
        list.remove(lastIndex); //now removing is O(1)

        //remove key from map
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int idx = (int)(Math.random()*list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */