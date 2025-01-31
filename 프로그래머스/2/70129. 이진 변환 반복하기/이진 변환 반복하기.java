class Solution {

    public int[] solution(String s) {

        int loops = 0;
        int removed = 0;

        while (!s.equals("1")) {

            int zeros = countZeros(s);
            removed += zeros;

            int s_length = s.length() - zeros;
            s = Integer.toString(s_length, 2);

            loops++;
        }

        return new int[]{loops, removed};
    }

    private int countZeros(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }

        return count;
    }
}