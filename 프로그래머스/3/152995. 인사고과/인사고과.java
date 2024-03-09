import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        int wanho_score = wanho[0] + wanho[1];
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        int max = 0;
        for(int[] score : scores) {
            if(score[1] < max) {
                if(score.equals(wanho)) {
                    return -1;
                }
            } else if(score[0] + score[1] > wanho_score) {
                answer++;
                max = Math.max(max, score[1]);
            }
        }
        
        return answer + 1;
    }
}