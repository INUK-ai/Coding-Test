import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int answer;

    public static void main(String[] args) throws Exception {

        boolean[] is_prime = new boolean[1000001];
        Arrays.fill(is_prime, true);

        is_prime[0] = false;
        is_prime[1] = false;

        int end = (int) Math.sqrt(1000000);
        for(int i = 2; i <= end; i++) {
            if(is_prime[i]) {
                for(int j = i * i; j <= 1000000; j += i) {
                    is_prime[j] = false;
                }
            }
        }

        for(int i = 2; i <= 1000000; i++) {
            if(is_prime[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}