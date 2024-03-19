import java.util.*;
import java.io.*;

class Main {

    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while(true) {
            int current = q.poll();

            if(current == end) {
                break;
            }

            if((current + 1) < 100001 && visited[current + 1] == 0) {
                visited[current + 1] = visited[current] + 1;
                q.offer(current + 1);
            }

            if((current - 1) >= 0 && visited[current - 1] == 0) {
                visited[current - 1] = visited[current] + 1;
                q.offer(current - 1);
            }

            if((current * 2) < 100001 && visited[current * 2] == 0) {
                visited[current * 2] = visited[current] + 1;
                q.offer(current * 2);
            }
        }

        System.out.println(visited[end] - 1);
    }
}