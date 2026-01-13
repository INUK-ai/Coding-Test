import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        char[] inputArray = input.toCharArray();

        int answer = 0, bar = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '(') {
                bar++;
            } else {
                bar--;

                if (inputArray[i - 1] == '(') {
                    answer += bar;
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}