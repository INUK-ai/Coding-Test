import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, K;
    private static int[] characterLevelList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        characterLevelList = new int[N];

        int minLevel = Integer.MAX_VALUE, maxLevel = 0;
        for (int i = 0; i < N; i++) {
            characterLevelList[i] = Integer.parseInt(br.readLine());
            minLevel = Math.min(minLevel, characterLevelList[i]);
            maxLevel = Math.max(maxLevel, characterLevelList[i]);
        }

        int low = minLevel, high = maxLevel + K, result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isValid(int level) {

        int requiredLevel = 0;
        for (int characterLevel : characterLevelList) {
            if (characterLevel >= level) continue;

            requiredLevel += (level - characterLevel);
            if (requiredLevel > K) return false;
        }

        return true;
    }
}