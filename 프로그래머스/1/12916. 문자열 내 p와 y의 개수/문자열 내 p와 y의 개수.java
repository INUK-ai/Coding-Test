class Solution {
    
    boolean solution(String s) {
        
        int np = 0;
        int ny = 0;
        
        for (char c : s.toCharArray()) {
            switch (c) {
                    case 'p', 'P' -> np++;
                    case 'y', 'Y' -> ny++;
            }
        }

        return np == ny;
    }
}