import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    static int[] arr;
    static boolean[][] visited;
    static int N;
    
	public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int T = Integer.parseInt(br.readLine());
	
		  for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            arr = new int[N];
            int sum = 0;
            
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(input[i]);
                sum += arr[i];
            }
            visited = new boolean[N+1][sum+1];
            dfs(0, 0);
            int ans = 0;
            for(int i=0; i<=sum; i++) {
                if(visited[N][i])
                    ans++;
            }
            System.out.println("#"+test_case+" "+ans);
		  }
	  }
    
    public static void dfs(int idx, int sum) {
        if(visited[idx][sum]) return;  
        visited[idx][sum] = true;
        if(idx>=N) return;
        
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}