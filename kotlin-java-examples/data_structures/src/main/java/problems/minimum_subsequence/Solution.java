package problems.minimum_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> resList = new ArrayList<>();

        switch (nums.length) {
            case 1:
                resList.add(nums[0]);
                return resList;
            case 2:
                if (nums[0] == nums[1]) {
                    resList.add(nums[0]);
                    resList.add(nums[1]);
                } else resList.add(Math.max(nums[0], nums[1]));
                return resList;
            default:
                boolean stop = false;
                int i = nums.length-1;
                while (!stop) {
                    int[] firstHalf = Arrays.copyOfRange(nums, i, nums.length);
                    int[] secondHalf = Arrays.copyOfRange(nums, 0, i);
                    resList.add(nums[i]);
                    stop = Arrays.stream(firstHalf).sum() > Arrays.stream(secondHalf).sum();
                    i -= 1;
                }
                return resList;
        }
    }
}
