package problems.array_running_sum;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            output[i] = runningSum;
        }
        return output;
    }
}
