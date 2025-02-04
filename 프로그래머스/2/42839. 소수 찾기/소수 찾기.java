import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int solution(String numbers) {

        List<Integer> nums = numbers.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());

        Set<Integer> primes = new HashSet<>();
        getPrimes(0, nums, primes);

        return primes.size();
    }

    private Set<Integer> getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);
        if (numbers.isEmpty()) return primes;

        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = (acc * 10) + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers, primes));
        }

        return primes;
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