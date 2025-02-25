import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        System.out.println(A - B);
    }
}