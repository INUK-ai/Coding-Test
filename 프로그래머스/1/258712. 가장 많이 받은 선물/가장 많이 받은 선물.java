import java.util.*;

class Solution {
    
    StringTokenizer st;
    
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> send = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>();
        Map<String, Map<String, Integer>> gift_count = new HashMap<>();
        
        for(String friend : friends) {
            send.put(friend, 0);
            receive.put(friend, 0);
            gift_count.put(friend, new HashMap<>());
            for(String otherFriend : friends) {
                gift_count.get(friend).put(otherFriend, 0);
            }
        }
        
        for(String gift : gifts) {
            st = new StringTokenizer(gift);
            String sender = st.nextToken();
            String receiver = st.nextToken();
            
            send.put(sender, send.get(sender) + 1);
            receive.put(receiver, receive.get(receiver) + 1);
            gift_count.get(sender).put(receiver, gift_count.get(sender).get(receiver) + 1);
        }
        
        Map<String, Integer> next_gift = new HashMap<>();
        for(String f : friends) {
            next_gift.put(f, 0);
        }
        
        for(String f1 : friends) {
            for(String f2 : friends) {
                if(!f1.equals(f2)) {
                    int giftsFrom1To2 = gift_count.get(f1).get(f2);
                    int giftsFrom2To1 = gift_count.get(f2).get(f1);
                    
                    if(giftsFrom1To2 > giftsFrom2To1) {
                        next_gift.put(f1, next_gift.get(f1) + 1);
                    } else if(giftsFrom1To2 < giftsFrom2To1) {
                        next_gift.put(f2, next_gift.get(f2) + 1);
                    } else {
                        int gift_point_f1 = send.get(f1) - receive.get(f1);
                        int gift_point_f2 = send.get(f2) - receive.get(f2);
                        
                        if(gift_point_f1 > gift_point_f2) {
                            next_gift.put(f1, next_gift.get(f1) + 1);
                        } else if(gift_point_f1 < gift_point_f2) {
                            next_gift.put(f2, next_gift.get(f2) + 1);
                        }
                    } 
                }
            }
        }
        
        int answer = 0;
        
        for(String f : friends) {
            answer = Math.max(answer, next_gift.get(f));    
        }
        
        return answer / 2;
    }
}