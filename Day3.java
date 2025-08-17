public class FindDuplicateNumber {

    public static int findDuplicate(int[] arr) {
    
        int slow = arr[0];
        int fast = arr[0];

    
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

    
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    
    public static void main(String[] args) {
        System.out.println("Duplicate number: " + findDuplicate(new int[]{1, 3, 4, 2, 2})); 
        System.out.println("Duplicate number: " + findDuplicate(new int[]{3, 1, 3, 4, 2})); 
        System.out.println("Duplicate number: " + findDuplicate(new int[]{1, 1}));          
        System.out.println("Duplicate number: " + findDuplicate(new int[]{1, 4, 4, 2, 3})); 
        System.out.println("Duplicate number: " + findDuplicate(generateLargeTest()));     
    }

    
    private static int[] generateLargeTest() {
        int n = 100000;
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        arr[n] = 50000; 
        return arr;
    }
}
