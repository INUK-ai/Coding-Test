import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static BigInteger n, m;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = new BigInteger(st.nextToken());
        m = new BigInteger(st.nextToken());

        sb.append(n.divide(m)).append("\n").append(n.mod(m));
        System.out.println(sb);
    }
}