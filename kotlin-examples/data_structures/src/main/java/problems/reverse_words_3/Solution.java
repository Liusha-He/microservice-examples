package problems.reverse_words_3;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder newString = new StringBuilder();
        for (String word: words) {
            newString.append(new StringBuilder().append(word).reverse().toString()).append(" ");
        }
        return newString.toString().trim();
    }
}
