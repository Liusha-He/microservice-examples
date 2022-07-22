package problems.weakest_rows;

import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] weakest = new int[mat.length][];
        int i = 0;

        for (int[] row : mat) {
            int sum = binarySearch(row);
            weakest[i] = new int[]{sum, i};
            i++;
        }

        Arrays.sort(weakest, (a,b) -> a[0] - b[0]);
        int[] res = new int[k];
        for (int j=0; j<k; j++) {
            res[j] = weakest[j][1];
        }
        return res;
    }

    private int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
