import java.util.Scanner;

public class LCMFinder {


    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        long N = scanner.nextLong();
        long M = scanner.nextLong();

        
        System.out.println(lcm(N, M));

        scanner.close();
    }
}
