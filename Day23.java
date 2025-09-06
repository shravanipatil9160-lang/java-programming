import java.util.*;

public class SlidingWindowMaximum {
    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(); 

        for (int i = 0; i < arr.length; i++) {
            
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }


            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

    
            deque.offerLast(i);

        
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(maxSlidingWindow(arr1, k1)); 

        int[] arr2 = {1, 5, 3, 2, 4, 6};
        int k2 = 3;
        System.out.println(maxSlidingWindow(arr2, k2)); 

        int[] arr3 = {1, 2, 3, 4};
        int k3 = 2;
        System.out.println(maxSlidingWindow(arr3, k3));

        int[] arr4 = {7, 7, 7, 7};
        int k4 = 1;
        System.out.println(maxSlidingWindow(arr4, k4)); 

        int[] arr5 = {42};
        int k5 = 1;
        System.out.println(maxSlidingWindow(arr5, k5)); 
    }
}
