package problems.remove_string_duplicates;

class Solution {
    private void removeOneDup(StringBuilder output) {
        if (output.length() > 1) {
            boolean stop = true;
            for (int i=0; i<output.length()-1; i++) {
                if (output.charAt(i) == output.charAt(i+1)) {
                    output.deleteCharAt(i).deleteCharAt(i);
                    stop = false;
                }
            }

            if (!stop) {
                removeOneDup(output);
            }
        }
    }

    public String removeDuplicates(String S) {
        StringBuilder output = new StringBuilder(S);
        removeOneDup(output);
        return output.toString();
    }
}
