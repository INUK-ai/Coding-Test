import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    private static class DoublyPriorityQueue {

        private int size = 0;
        private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        private final Map<Integer, Integer> deleteMap = new HashMap<>();

        public void add(int value) {
            size++;
            minPq.add(value);
            maxPq.add(value);
            deleteMap.put(value, deleteMap.getOrDefault(value, 0) + 1);
        }

        private void sync(PriorityQueue<Integer> pq) {
            while (!pq.isEmpty() && deleteMap.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }
        }

        public void removeMax() {
            if (size == 0) return;

            sync(maxPq);

            if (!maxPq.isEmpty()) {
                int maxValue = maxPq.poll();
                deleteMap.put(maxValue, deleteMap.get(maxValue) - 1);
                size--;
            }

            if (size == 0) {
                maxPq.clear();
                minPq.clear();
                deleteMap.clear();
            }
        }

        public void removeMin() {
            if (size == 0) return;

            sync(minPq);

            if (!minPq.isEmpty()) {
                int minValue = minPq.poll();
                deleteMap.put(minValue, deleteMap.get(minValue) - 1);
                size--;
            }

            if (size == 0) {
                maxPq.clear();
                minPq.clear();
                deleteMap.clear();
            }
        }

        public int max() {
            if (size == 0) return 0;
            sync(maxPq);
            return maxPq.isEmpty() ? 0 : maxPq.peek();
        }

        public int min() {
            if (size == 0) return 0;
            sync(minPq);
            return minPq.isEmpty() ? 0 : minPq.peek();
        }
    }

    public int[] solution(String[] operations) {

        DoublyPriorityQueue queue = new DoublyPriorityQueue();

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];

            switch (command) {
                case "I" -> queue.add(Integer.parseInt(value));
                case "D" -> {
                    if (value.equals("1")) {
                        queue.removeMax();
                    } else {
                        queue.removeMin();
                    }
                }
            }
        }

        return new int[]{queue.max(), queue.min()};
    }
}