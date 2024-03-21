import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<Integer, Integer> frequency = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            frequency.put(numbers[i], frequency.getOrDefault(numbers[i], 0) + 1);
        }

        Arrays.sort(numbers);

        int average = (int) Math.round((double) sum / N);
        int median = numbers[N / 2];
        int many = getMany();
        int range = numbers[N - 1] - numbers[0];

        StringBuilder sb = new StringBuilder();
        sb.append(average).append("\n")
                .append(median).append("\n")
                .append(many).append("\n")
                .append(range).append("\n");

        System.out.println(sb);
    }

    public static int getMany() {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequency.entrySet());
        list.sort((e1, e2) ->
                e2.getValue().equals(e1.getValue()) ? e1.getKey().compareTo(e2.getKey()) : e2.getValue().compareTo(e1.getValue())
        );

        if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            return list.get(1).getKey();
        } else {
            return list.get(0).getKey();
        }
    }
}
