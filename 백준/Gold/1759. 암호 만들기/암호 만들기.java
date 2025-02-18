import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int L, C;
    private static char[] alphabet, password;

    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        backtrace(0, 0);

        System.out.println(sb);
    }

    private static void backtrace(int depth, int start) {

        if (depth == L) {
            if (isValid()) {
                sb.append(password).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = alphabet[i];
            backtrace(depth + 1, i + 1);
        }
    }

    private static boolean isValid() {

        int vowelCount = 0, consonantCount = 0;

        for (char c : password) {
            if (isVowel(c)) vowelCount++;
            else consonantCount++;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

    private static boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) return true;
        }
        return false;
    }
}
