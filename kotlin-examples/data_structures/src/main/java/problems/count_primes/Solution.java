package problems.count_primes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean isPrime(int n, List<Integer> list) {
        int s = 0, i = 0;

        while (s < Math.sqrt(n)) {
            s = list.get(i);
            if (n % s == 0 && n != s) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);

        for (int i = 3; i<n; i+=2) {
            if (isPrime(i, primeList)) {
                primeList.add(i);
            }
        }
        return primeList.size();
    }
}
