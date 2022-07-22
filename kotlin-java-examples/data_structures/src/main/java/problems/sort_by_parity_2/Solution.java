package problems.sort_by_parity_2;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int even = 0, odd = 1;

        for (int a: A) {
            if (a%2 == 0) {
                ans[even] = a;
                even += 2;
            } else {
                ans[odd] = a;
                odd += 2;
            }
        }

        return ans;
    }
}
