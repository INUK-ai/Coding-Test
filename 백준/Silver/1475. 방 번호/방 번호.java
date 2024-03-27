import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String num = bf.readLine();

        int[] array = new int[10];

        for (int i = 0; i < num.length(); i++) {
            int current = num.charAt(i) - '0';
            if (current == 9) {
                array[6]++;
            } else {
                array[current]++;
            }
        }

        array[6] = (array[6] + 1) / 2;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, array[i]);
        }

        System.out.println(max);
    }
}
