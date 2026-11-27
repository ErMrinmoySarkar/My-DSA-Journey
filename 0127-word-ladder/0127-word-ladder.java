class Solution {
    class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        HashSet<String>set = new HashSet<>( wordList ); //add all the words from wrodList Array
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair w = q.remove();

            String curr = w.word;
            int currStep = w.step;

            if(curr.equals(endWord)){
                return currStep;
            }

            for(int i=0;i<curr.length();i++){
                char[] arr = curr.toCharArray();
                for(char ch ='a'; ch<='z'; ch++){
                    arr[i] = ch; // a->z

                    String result = new String (arr); // array to string convert
                    if(set.contains(result)){
                        q.add(new Pair(result, currStep+1));
                        set.remove(result);
                    }
                }
            }
        }
        return 0;
    }
}