import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String word = bf.readLine();
        String bomb = bf.readLine();

        Stack<Character> s = new Stack<>();

        for(int i = 0; i < word.length(); i++) {
            s.push(word.charAt(i));

            if(s.size() >= bomb.length()) {
                boolean isBomb = true;

                for(int j = 0; j < bomb.length(); j++) {
                    if(s.get(s.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb) {
                    for(int j = 0; j < bomb.length(); j++) {
                        s.pop();
                    }
                }
            }
        }

        for(char c : s) {
            sb.append(c);
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}