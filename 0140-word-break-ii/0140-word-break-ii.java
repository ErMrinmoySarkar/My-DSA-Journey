class Solution {

    private void solver(String s,Set<String>wordSet, StringBuilder currStr,List<String>result,int stIdx){
        if(stIdx == s.length()){
            result.add(currStr.toString().trim());
            return;
        }

        for(int endIdx = stIdx+1; endIdx<=s.length(); endIdx++){
            String word = s.substring(stIdx, endIdx);

            if(wordSet.contains(word)){
                int currLength = currStr.length();

                currStr.append(word).append(" ");
                solver(s, wordSet, currStr, result, endIdx);

                currStr.setLength(currLength);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String>wordSet = new HashSet<>(wordDict);
        List<String>result = new ArrayList<>();
        solver(s, wordSet, new StringBuilder(),result, 0);
        return result;
    }
}