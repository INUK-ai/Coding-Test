import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static Meeting[] meetingList;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        meetingList = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingList[i] = new Meeting(start, end);
        }

        Arrays.sort(meetingList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetingList[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= meetingList[i].start) {
                pq.poll();
            }

            pq.add(meetingList[i].end);
        }

        System.out.println(pq.size());
    }

    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}