package problems.excel_columns;

class Solution {
    public String convertToTitle(int n) {
        String strArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder buf = new StringBuilder();
        int remainder = 0;

        while (n > 0) {
            remainder = n % 26;
            int idx = remainder != 0 ? remainder-1 : 25;
            buf.append(strArr.charAt(idx));

            n = remainder == 0 ? n / 26 - 1 : n/26;
        }
        buf.reverse();
        return buf.toString();
    }
}
