class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '.') {
                    continue;
                }
                
                lux = Math.min(lux, i);
                luy = Math.min(luy, j);
                rdx = Math.max(rdx, i + 1);
                rdy = Math.max(rdy, j + 1);
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}