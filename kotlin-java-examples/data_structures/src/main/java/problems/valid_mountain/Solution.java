package problems.valid_mountain;

class Solution {
    public boolean validMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;
        while (right > left) {
            if (arr[left] < arr[left + 1]) {
                left++;
            } else if (arr[right] < arr[right-1]) {
                right--;
            } else {
                break;
            }
        }
        return right == left && right != arr.length-1 && left != 0;
    }
}
