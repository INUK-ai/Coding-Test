import java.util.*;

class Process {
    int index;
    int priority;
    
    public Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        
        while(!queue.isEmpty()) {
            Process current = queue.poll();
            boolean isHighest = true;
            
            for(Process proc : queue) {
                if(current.priority < proc.priority) {
                    isHighest = false;
                    break;
                }
            }
            
            if(isHighest) {
                answer++;
                
                if(current.index == location) {
                    break;
                }
            } else {
                queue.add(current);
            }
        }
    
        return answer;
    }
}