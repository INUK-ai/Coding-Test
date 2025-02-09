class Solution {

    public int solution(int n, int k) {

        String[] tokens = Long.toString(n, k).split("0+");

        int count = 0;

        for (String token : tokens) {
            if (isPrime(Long.parseLong(token))) count++;
        }
        return count;
    }

    private boolean isPrime(long v) {

        if (v <= 1) return false;
        if (v == 2) return true;
        if (v % 2 == 0) return false;

        for (int i = 3; i  <= Math.sqrt(v); i += 2) {
            if (v % i == 0) return false;
        }

        return true;
    }
}