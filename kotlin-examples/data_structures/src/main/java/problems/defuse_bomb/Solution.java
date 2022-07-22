package problems.defuse_bomb;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k < 0) {
                for (int j=i-1; j>=i+k; j--) {
                    int index = j>=0 ? j : (code.length+j)%code.length;
                    sum += code[index];
                }

            } else if (k > 0) {
                for (int j=i+1; j<=i+k; j++) {
                    int index = j<code.length ? j : (j-code.length)%code.length;
                    sum += code[index];
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
