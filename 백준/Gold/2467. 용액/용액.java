import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int[] liquid;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        liquid = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(liquid);
        
        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        
        int resultLeft = 0, resultRight = 0;
        while (left < right) {
            int sum = liquid[left] + liquid[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                resultLeft = liquid[left];
                resultRight = liquid[right];
            }
            
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break; 
            }
        }
        
        System.out.println(resultLeft + " " + resultRight);
    }
}