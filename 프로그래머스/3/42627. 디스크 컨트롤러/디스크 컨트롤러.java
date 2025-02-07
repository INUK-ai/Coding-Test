import java.util.*;

class Solution {

    private static class Job {

        public final int start;
        public final int duration;

        public Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public int solution(int[][] jobs) {

        Job[] jobArray = new Job[jobs.length];

        for (int i = 0; i < jobs.length; i++) {
            jobArray[i] = new Job(jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(jobArray, Comparator.comparingInt(job -> job.start));

        Queue<Job> queue = new LinkedList<>(Arrays.asList(jobArray));
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

        int exec = 0;
        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            
            while (!queue.isEmpty() && queue.peek().start <= time) {
                pq.offer(queue.poll());
            }

            if (pq.isEmpty()) {
                time = queue.peek().start;
                continue;
            }

            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }

        return exec / jobArray.length;
    }
}