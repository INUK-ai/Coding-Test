import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> play_sum = new HashMap<>();
        Map<String, List<int[]>> play_num = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            play_sum.put(genre, play_sum.getOrDefault(genre, 0) + plays[i]);
            List<int[]> song = play_num.computeIfAbsent(genre, k -> new ArrayList<>());
            song.add(new int[]{i, plays[i]});
        }
        
        List<String> sortedGenres = new ArrayList<>(play_sum.keySet());
        sortedGenres.sort((g1, g2) -> play_sum.get(g2).compareTo(play_sum.get(g1)));
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = play_num.get(genre);
            
            Collections.sort(songs, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                answer.add(songs.get(i)[0]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}