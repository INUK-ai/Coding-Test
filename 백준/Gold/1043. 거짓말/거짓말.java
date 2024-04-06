import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truth_count = Integer.parseInt(st.nextToken());
        int first_truth = 0;
        for(int i = 0; i < truth_count; i++) {
            int person = Integer.parseInt(st.nextToken());

            if(i ==0) {
                first_truth = person;
            } else {
                union(first_truth, person);
            }
        }

        int[][] parties = new int[M][];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people_count = Integer.parseInt(st.nextToken());
            parties[i] = new int[people_count];

            for(int j = 0; j < people_count; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());

                if(j > 0) {
                    union(parties[i][0], parties[i][j]);
                }
            }
        }

        int answer = M;
        for(int i = 0; i < M; i++) {
            for(int person : parties[i]) {
                if(find(person) == find(first_truth)) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }

    private static int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}