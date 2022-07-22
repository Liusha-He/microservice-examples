package problems.arithemetic_progression;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[arr.length-1] - arr[arr.length-2];
        for (int i = arr.length-2; i >= 1; i--) {
            if (arr[i] - arr[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}