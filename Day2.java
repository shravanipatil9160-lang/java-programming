public class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum);
    }

    
    public static void main(String[] args) {
        System.out.println("Missing number: " + findMissingNumber(new int[]{1, 2, 4, 5})); 
        System.out.println("Missing number: " + findMissingNumber(new int[]{2, 3, 4, 5})); 
        System.out.println("Missing number: " + findMissingNumber(new int[]{1, 2, 3, 4}));
        System.out.println("Missing number: " + findMissingNumber(new int[]{1}));

    
        int n = 1000000;
        int[] largeArr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            largeArr[i] = i + 1;
        }
    
        largeArr[n - 2] = n - 1; 
        System.out.println("Missing number: " + findMissingNumber(largeArr)); 
    }
}
