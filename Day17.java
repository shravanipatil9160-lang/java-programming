import java.util.*;

public class PrimeFactorization {

    public static List<Integer> primeFactors(int N) {
        List<Integer> factors = new ArrayList<>();

        // Divide by 2 until it's odd
        while (N % 2 == 0) {
            factors.add(2);
            N /= 2;
        }

        // Now N must be odd, so check only odd numbers
        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                factors.add(i);
                N /= i;
            }
        }

        // If N is still greater than 2, then it's prime
        if (N > 2) {
            factors.add(N);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number N (2 ≤ N ≤ 10^9): ");
        int N = scanner.nextInt();

        List<Integer> result = primeFactors(N);
        System.out.println("Prime Factors: " + result);
    }
}
