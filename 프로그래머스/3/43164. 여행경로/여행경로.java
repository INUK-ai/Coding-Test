import java.util.*;

public class Solution {
    
    Map<String, List<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        
        for(List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }
        
        dfs("ICN");
        
        return result.toArray(new String[0]);
    }
    
    public void dfs(String departure) {
        while(graph.containsKey(departure) && !graph.get(departure).isEmpty()) {
            String next = graph.get(departure).remove(0);
            dfs(next);
        }
        
        result.add(0, departure);
    }
}