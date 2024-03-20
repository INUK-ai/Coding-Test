import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    
        Map<String, String> password = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            
            String site = st.nextToken();
            String pw = st.nextToken();
            
            password.put(site, pw);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            String current = bf.readLine();
            String pw = password.get(current);
            
            sb.append(pw).append("\n");
        }
        
        System.out.println(sb);
    }
}