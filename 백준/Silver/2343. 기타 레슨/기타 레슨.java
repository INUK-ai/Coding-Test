import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] lelctures;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lelctures = new int[N];
        int maxLecture = 0, totalLength = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lelctures[i] = Integer.parseInt(st.nextToken());
            maxLecture = Math.max(maxLecture, lelctures[i]);
            totalLength += lelctures[i];
        }

        int low = maxLecture, high = totalLength, result = high;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isValid(int size) {

        int count = 1, sum = 0;
        for (int lecture : lelctures) {
            if (sum + lecture > size) {
                count++;
                sum = lecture;
            } else {
                sum += lecture;
            }
        }

        return count <= M;
    }
}