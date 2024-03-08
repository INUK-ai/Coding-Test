import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeightOnBridge = 0;

        for (int truckWeight : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truckWeight);
                    totalWeightOnBridge += truckWeight;
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    totalWeightOnBridge -= bridge.poll();
                } else {
                    if (totalWeightOnBridge + truckWeight <= weight) {
                        bridge.add(truckWeight);
                        totalWeightOnBridge += truckWeight;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}