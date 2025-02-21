import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, maxCount;
    private static Egg[] eggList;

    private static class Egg {

        int durability, weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public boolean isBroken() {
            return this.durability <= 0;
        }

        public void hit(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        public void restore(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        eggList = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggList[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        System.out.println(maxCount);
    }

    private static void dfs(int index, int count) {

        if (index == N) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        if (eggList[index].isBroken()) {
            dfs(index + 1, count);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == index || eggList[i].isBroken()) continue;

            eggList[index].hit(eggList[i]);
            int newCount = count + (eggList[index].isBroken() ? 1 : 0) + (eggList[i].isBroken() ? 1 : 0);
            hit = true;
            dfs(index + 1, newCount);

            eggList[index].restore(eggList[i]);
        }

        if (!hit) dfs(index + 1, count);
    }
}
