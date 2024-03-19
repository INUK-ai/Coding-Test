import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bf.readLine());
        
        int step = 0;
        int count = 0;
        
        while(count < X) {
            step++;
            count = (step * (step + 1)) / 2;
        }
        
        int diff = count - X;
        int child, parent;
        
        if(step % 2 == 0) {
            child = step - diff;
            parent = diff + 1;
        } else {
            child = diff + 1;
            parent = step - diff;
        }

        System.out.println(child + "/" + parent);
    }
}
