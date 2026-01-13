import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int[] points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        points = new int[N];
        int[] sortedPoints = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
            sortedPoints[i] = points[i];
        }

        Arrays.sort(sortedPoints);

        int[] unique =  new int[N];
        int uniqueIndex = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || sortedPoints[i] != sortedPoints[i - 1]) {
                unique[uniqueIndex++] = sortedPoints[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(unique, 0, uniqueIndex, points[i]);
            sb.append(index).append(" ");
        }

        System.out.println(sb);
    }
}