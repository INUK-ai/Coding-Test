import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(bf.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            String word = bf.readLine();
            Map<Character, Integer> keyword = new HashMap<>();
            boolean isValid = true;
            int lastChangeIndex = 0;

            for(int j = 1; j < word.length(); j++) {
                if(word.charAt(j - 1) != word.charAt(j)) {
                    keyword.put(word.charAt(j - 1), keyword.getOrDefault(word.charAt(j - 1), 0) + 1);
                    lastChangeIndex = j - 1;
                }
                
                if(j == word.length() - 1) {
                    if(word.charAt(lastChangeIndex) != word.charAt(j)) {
                        keyword.put(word.charAt(j), keyword.getOrDefault(word.charAt(j), 0) + 1);
                    }
                }
            }

            for(char c : keyword.keySet()) {
                if(keyword.get(c) > 1) {
                    isValid = false;
                }
            }

            if(isValid) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}