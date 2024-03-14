import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, Eunjin, answer = 0;
    static int[] guilty;
    static int[][] murder;
    static boolean[] dead;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        guilty = new int[N];
        murder = new int[N][N];
        dead = new boolean[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            guilty[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j = 0; j < N; j++) {
                murder[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Eunjin = Integer.parseInt(bf.readLine());

        int day = 0;

        play(N, day);

        System.out.println(answer);
    }

    private static void play(int num, int day) {

        if(dead[Eunjin] || num == 1) {
            answer = Math.max(answer, day);
            return;
        }

        if(num % 2 == 0) {
            for(int i = 0; i < N; i++) {
                if(dead[i] || i == Eunjin) {
                    continue;
                }

                for(int j = 0; j < N; j++) {
                    if(dead[j]) {
                        continue;
                    }

                    guilty[j] += murder[i][j];
                }

                dead[i] = true;
                play(num - 1, day + 1);
                dead[i] = false;

                for(int j = 0; j < N; j++) {
                    if(dead[j]) {
                        continue;
                    }

                    guilty[j] -= murder[i][j];
                }
            }
        } else {
            int max = 0;
            int idx = 0;

            for(int i = N - 1; i >= 0; i--) {
                if(!dead[i] && max <= guilty[i]) {
                    max = guilty[i];
                    idx = i;
                }
            }

            dead[idx] = true;
            play(num - 1, day);
            dead[idx] = false;
        }
    }
}
