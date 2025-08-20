import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> prefixSumMap = new HashMap<>();

        long sum = 0;
        prefixSumMap.put(0L, new ArrayList<>());
        prefixSumMap.get(0L).add(-1); 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (prefixSumMap.containsKey(sum)) {
                for (int startIdx : prefixSumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            prefixSumMap.putIfAbsent(sum, new ArrayList<>());
            prefixSumMap.get(sum).add(i);
        }

        return result;
    }


    public static void printResult(List<int[]> result) {
        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }

    
    public static void main(String[] args) {
        int[] input = {1, 2, -3, 3, -1, 2};
        List<int[]> result = findZeroSumSubarrays(input);
        printResult(result);
    }
}
