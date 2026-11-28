class Solution {
    public int lengthOfLongestSubstring(String s) {
        //slide window approach
        Set<Character>uniqueChar = new HashSet<>();
        int left = 0, longestLength = 0;

        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            while(uniqueChar.contains(ch)){
                uniqueChar.remove(s.charAt(left));
                left++;
            }

            uniqueChar.add(ch);
            longestLength = Math.max(longestLength, (right - left) + 1);
        }

        return longestLength;
    }
}