import java.util.*;

class Solution {
    boolean solution(String s) {
        int complete = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                complete++;
            } else {
                complete--;
            }
            
            if(complete < 0) {
                return false;
            }
        }
        
        if(complete != 0) {
            return false;
        }

        return true;
    }
}