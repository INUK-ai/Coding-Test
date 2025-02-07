import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> queue = new LinkedList<>();
        for (int l : lost) queue.add(l);

        int get = 0;
        for (int r : reserve) {
            if (owns.contains(r)) continue;

            while (!queue.isEmpty() && (queue.peek() < r - 1 || owns.contains(queue.peek()))) {
                queue.poll();
            }

            if (queue.isEmpty()) break;

            if (queue.peek() <= r + 1) {
                queue.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get;
    }
}