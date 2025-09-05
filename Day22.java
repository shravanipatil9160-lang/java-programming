import java.util.*;

public class FirstElementKTimes {
    public static int findElementWithKOccurrences(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

    
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

    
        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k1 = 2;
        System.out.println(findElementWithKOccurrences(arr1, k1)); 

        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        int k2 = 2;
        System.out.println(findElementWithKOccurrences(arr2, k2)); 

        int[] arr3 = {1, 1, 1, 1};
        int k3 = 1;
        System.out.println(findElementWithKOccurrences(arr3, k3)); 

        int[] arr4 = {10};
        int k4 = 1;
        System.out.println(findElementWithKOccurrences(arr4, k4)); 

        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        int k5 = 3;
        System.out.println(findElementWithKOccurrences(arr5, k5));
    }
}
