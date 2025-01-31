class Solution {

    public int solution(int n) {

        String string_n = Integer.toString(n, 3);
        String reverse_str = new StringBuilder(string_n).reverse().toString();

        return Integer.parseInt(reverse_str, 3);
    }
}