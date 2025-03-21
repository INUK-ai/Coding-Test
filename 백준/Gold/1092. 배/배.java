import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static Integer[] cranes;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        cranes = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < N && boxIndex < boxes.size()) {
                if (cranes[craneIndex] >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}