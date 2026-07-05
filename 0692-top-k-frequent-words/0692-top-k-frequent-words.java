class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        //map words to frequency
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        //store map entries in priority queue
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> {
            //if freq is same , compare with lexical order and put greater(worst) at top , to remove when size exceeds
            if(a.getValue().equals(b.getValue())) return  b.getKey().compareTo(a.getKey());
            //else remove worst ( less freq)
            else return Integer.compare(a.getValue(),b.getValue());
        });

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        
        //stores in worst to best
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        // reverse to best to worst
        Collections.reverse(ans);

        return ans;

    }
   
}