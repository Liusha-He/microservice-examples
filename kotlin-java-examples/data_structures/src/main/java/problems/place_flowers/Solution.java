package problems.place_flowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0; i<flowerbed.length; i++) {
            int left = i >= 1 ? flowerbed[i-1] : 0;
            int right = i < flowerbed.length-1 ? flowerbed[i+1] : 0;
            if (flowerbed[i] == 0 && (left == 0 && right == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
