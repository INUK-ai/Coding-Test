import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    static int N, M;
    static int T;

    public static class Employee implements Comparable<Employee> {

        int paper;
        int meeting;

        public Employee(int paper, int meeting) {
            this.paper = paper;
            this.meeting = meeting;
        }

        @Override
        public int compareTo(Employee o) {
            return (o.paper == this.paper) ? this.meeting - o.meeting : this.paper - o.paper;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Employee[] employees = new Employee[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int meeting = Integer.parseInt(st.nextToken());

                employees[j] = new Employee(paper, meeting);
            }

            Arrays.sort(employees);

            int count = 1;
            int min = employees[0].meeting;

            for(int j = 1; j < N; j++) {
                Employee current = employees[j];

                if(current.meeting < min) {
                    count++;
                    min = current.meeting;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}