package problems.find_positive_solution;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> output = new ArrayList<>();
        int x = 1, y = z;

        while (x <= z && y > 0) {
            int res = customfunction.f(x, y);
            if (res == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                output.add(list);
                x+=1; y-=1;
            } else if (res > z) {
                y -= 1;
            } else {
                x += 1;
            }
        }
        return output;
    }
}
