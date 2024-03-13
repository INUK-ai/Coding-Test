import java.util.*;

public class Solution {

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10;
        t1 += 10;
        t2 += 10;

        int time = onboard.length;
        int lowest = Math.min(temperature, t1);
        int highest = Math.max(temperature, t2);

        int[][] dp = new int[time + 1][highest + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 1000000);
        }
        dp[0][temperature] = 0;

        for (int i = 0; i < time; i++) {
            int from, to;
            if (onboard[i] == 1) {
                from = t1;
                to = t2;
            } else {
                from = lowest;
                to = highest;
            }

            for (int j = from; j <= to; j++) {
                if (j + 1 <= highest) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j + 1] + a);
                }
                if (j - 1 >= lowest) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j - 1] + a);
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);

                if (j + 1 > temperature && j + 1 <= highest) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                if (j - 1 < temperature && j - 1 >= lowest) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
                if (j == temperature) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                }
            }
        }

        int answer = Arrays.stream(dp[time]).min().getAsInt();
        return answer;
    }
}