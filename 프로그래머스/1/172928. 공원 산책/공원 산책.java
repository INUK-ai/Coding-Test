import java.util.*;

class Solution {
    
    StringTokenizer st;
    
    int H, W;
    char[][] p;
    
    public int[] solution(String[] park, String[] routes) {
        
        H = park.length;
        W = park[0].length();
        
        p = new char[H][W];
        
        int[] position = new int[2];
        
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                p[i][j] = park[i].charAt(j);
                if(p[i][j] == 'S') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        
        for(String route : routes) {
            st = new StringTokenizer(route);
            String direction = st.nextToken();
            int size = Integer.parseInt(st.nextToken());
            
            move(direction, size, position);
        }
        
        return position;
    }
    
    public void move(String direction, int size, int[] position) {
        
        int[] newPosition = {position[0], position[1]};
        
        for (int i = 0; i < size; i++) {
            if (direction.equals("E")) {
                newPosition[1]++;
            } else if (direction.equals("W")) {
                newPosition[1]--;
            } else if (direction.equals("S")) {
                newPosition[0]++;
            } else if (direction.equals("N")) {
                newPosition[0]--;
            }
            
            if (newPosition[0] < 0 || newPosition[0] >= H || newPosition[1] < 0 || newPosition[1] >= W || p[newPosition[0]][newPosition[1]] == 'X') {
                return;
            }
        }
        
        position[0] = newPosition[0];
        position[1] = newPosition[1];
    }
}