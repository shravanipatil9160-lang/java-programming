import java.util.Scanner;

public class DivisorCounter {

    public static int countDivisors(int N) {
        int count = 0;
        int sqrt = (int)Math.sqrt(N);

        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    // i is the square root of N, count only once
                    count++;
                } else {
                    // count both i and N/i
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int result = countDivisors(N);
        System.out.println(result);
    }
}
