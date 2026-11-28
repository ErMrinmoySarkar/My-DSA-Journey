class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer>freq = new HashMap<>();
        for(int val:arr){
            freq.put(val,freq.getOrDefault(val,0)+1);
        }

        int luckyInt = -1;
        for(int key : freq.keySet()){
            if(freq.get(key) == key) luckyInt = key;
        }
        return luckyInt;
    }
}