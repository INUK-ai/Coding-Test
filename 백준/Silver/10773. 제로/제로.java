import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(bf.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < K; i++) {
            int N = Integer.parseInt(bf.readLine());
            
            if(N == 0) {
                stack.pop();
            } else {
                stack.push(N);
            }
        }
        
        int answer = 0;
        
        for(int num : stack) {
            answer += num;
        }
        
        System.out.println(answer);
    }
}