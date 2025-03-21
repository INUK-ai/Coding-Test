import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static Course[] courseList;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        courseList = new Course[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            courseList[i] = new Course(start, end);
        }

        Arrays.sort(courseList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(courseList[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= courseList[i].start) {
                pq.poll();
            }

            pq.add(courseList[i].end);
        }

        System.out.println(pq.size());
    }

    public static class Course implements Comparable<Course> {

        int start;
        int end;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
            return this.start - o.start;
        }
    }
}