package problems.delete_columns;

class Solution {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); c++) {
            for (int r = 1; r < A.length; r++) {
                if (A[r-1].charAt(c) > A[r].charAt(c)) {
                    ans += 1;
                    break;
                }
            }
        }
        return ans;
    }
}
