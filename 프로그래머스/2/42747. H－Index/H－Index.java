import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int length = citations.length;
        for(int i = length; i > 0; i--) {
            if(i <= citations[length - i]) {
                return i;
            }
        }
        
        return 0;
    }
}