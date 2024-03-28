import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];

            String test_case = br.readLine();
            int index = 0;
            test_case = test_case.replace("[", "");
            test_case = test_case.replace("]", "");
            st = new StringTokenizer(test_case, ",");

            for(int j = 0; j < n; j++) {
                array[index++] = Integer.parseInt(st.nextToken());
            }

            String answer = getCommandResult(command, array);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static String getCommandResult(String command, int[] array) {
        int start = 0;
        int end = array.length - 1;
        boolean reverse = false;

        for (int i = 0; i < command.length(); i++) {
            char currentCommand = command.charAt(i);

            if (currentCommand == 'R') {
                reverse = !reverse;
            } else if (currentCommand == 'D') {
                if (start > end) {
                    return "error";
                }
                if (reverse) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");
        if (start <= end) {
            if (reverse) {
                for (int i = end; i > start; i--) {
                    sb.append(array[i]).append(",");
                }
                sb.append(array[start]);
            } else {
                for (int i = start; i < end; i++) {
                    sb.append(array[i]).append(",");
                }
                sb.append(array[end]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}