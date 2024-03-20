import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            
            for(int j = 0; j < N; j++) {
                int place = Integer.parseInt(st.nextToken());
                
                if(place == 1) {
                    houses.add(new int[]{i, j});
                }
                
                if(place == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        
        selectChicken(new ArrayList<int[]>(), 0);
        
        System.out.println(answer);
    }
    
    public static void selectChicken(ArrayList<int[]> selected, int start) {
        if(selected.size() == M) {
            int distance = calculateDistance(selected);
            answer = Math.min(answer, distance);
            return;
        }
        
        for(int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            selectChicken(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
    
    public static int calculateDistance(ArrayList<int[]> selected) {
        int sum = 0;
        
        for(int[] house : houses) {
            int houseDistance = Integer.MAX_VALUE;
            
            for(int[] chicken : selected) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                houseDistance = Math.min(houseDistance, distance);
            }
            
            sum += houseDistance;
        }
        
        return sum;
    }
}