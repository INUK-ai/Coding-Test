import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphaCount = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char firstChar = name.charAt(0);
            alphaCount[firstChar - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}