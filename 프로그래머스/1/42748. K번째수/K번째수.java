import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int[] command : commands) {
            
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2];
            
            List<Integer> list = new ArrayList<>();
            
            for(int n = i; n < j; n++) {
                list.add(array[n]);
            }
            
            Collections.sort(list);
            
            answer.add(list.get(k - 1));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}