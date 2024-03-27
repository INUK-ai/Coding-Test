import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> no_hear_no_see = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String no_hear = bf.readLine();
            no_hear_no_see.put(no_hear, no_hear_no_see.getOrDefault(no_hear, 0) + 1);
        }

        for(int i = 0; i < M; i++) {
            String no_see = bf.readLine();
            no_hear_no_see.put(no_see, no_hear_no_see.getOrDefault(no_see, 0) + 1);
        }

        ArrayList<String> answer = new ArrayList<>();
        for(String key : no_hear_no_see.keySet()) {
            if(no_hear_no_see.get(key) == 2) {
                answer.add(key);
            }
        }
        
        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}