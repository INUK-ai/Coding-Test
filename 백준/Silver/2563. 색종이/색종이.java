import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        boolean[][] paper = new boolean[100][100];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            
            for(int j = X; j < X + 10; j++) {
                for(int k = Y; k < Y + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j]) {
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
}