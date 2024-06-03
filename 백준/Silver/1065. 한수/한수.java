import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(countHansu(N));
    }

    public static int countHansu(int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isHansu(int num) {
        if (num < 100) {
            return true; // 1부터 99까지는 모두 한수
        }

        String strNum = String.valueOf(num);
        int diff = strNum.charAt(1) - strNum.charAt(0);

        for (int i = 1; i < strNum.length() - 1; i++) {
            int currentDiff = strNum.charAt(i + 1) - strNum.charAt(i);
            if (currentDiff != diff) {
                return false;
            }
        }

        return true;
    }
}