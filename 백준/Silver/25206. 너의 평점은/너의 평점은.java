import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        double total_grade = 0;
        double sum_grade = 0;

        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            switch (grade) {
                case "A+":
                    total_grade += score * 4.5;
                    sum_grade += score;
                    break;
                case "A0":
                    total_grade += score * 4.0;
                    sum_grade += score;
                    break;
                case "B+":
                    total_grade += score * 3.5;
                    sum_grade += score;
                    break;
                case "B0":
                    total_grade += score * 3.0;
                    sum_grade += score;
                    break;
                case "C+":
                    total_grade += score * 2.5;
                    sum_grade += score;
                    break;
                case "C0":
                    total_grade += score * 2.0;
                    sum_grade += score;
                    break;
                case "D+":
                    total_grade += score * 1.5;
                    sum_grade += score;
                    break;
                case "D0":
                    total_grade += score * 1.0;
                    sum_grade += score;
                    break;
                case "F":
                    total_grade += score * 0.0;
                    sum_grade += score;
                    break;
                case "P":
                    break;
            }
        }

        sb.append(total_grade / sum_grade);

        System.out.println(sb);
    }
}