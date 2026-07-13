class Solution {
    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder rev = new StringBuilder(words[i]);
            ans.append(rev.reverse());

            if (i != words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}