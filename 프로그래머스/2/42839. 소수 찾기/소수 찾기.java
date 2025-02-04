import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String numbers) {

        Set<Integer> primes = new HashSet<>();
        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        getPrimes(0, nums, new boolean[nums.length], primes);

        return primes.size();
    }

    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {

            if (isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    private boolean isPrime(int number) {

        if (number <= 1) return false;
        if (number == 2) return true;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}