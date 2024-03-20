import java.io.*;
import java.util.*;

public class Main {
    
    static class Person {
        int weight;
        int height;
        
        int rank = 1;
        
        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        List<Person> people = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            
            people.add(new Person(weight, height));
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    Person p1 = people.get(i);
                    Person p2 = people.get(j);
                    
                    if(p1.weight < p2.weight && p1.height < p2.height) {
                        p1.rank++;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Person p : people) {
            sb.append(p.rank).append(" ");
        }
        
        System.out.println(sb);
    }
}