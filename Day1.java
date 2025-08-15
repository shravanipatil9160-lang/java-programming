public class Sortarray {

    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                
                    mid++;
                    break;

                case 2:
                    
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {

        int[] arr1 = {0, 1, 2, 1, 0, 2, 1, 0};
        sort012(arr1);
        printArray(arr1);  

        int[] arr2 = {2, 2, 2, 2};
        sort012(arr2);
        printArray(arr2);  

        
        int[] arr3 = {0, 0, 0, 0};
        sort012(arr3);
        printArray(arr3);  

    
        int[] arr4 = {1, 1, 1, 1};
        sort012(arr4);
        printArray(arr4);  

        
        int[] arr5 = {2, 0, 1};
        sort012(arr5);
        printArray(arr5); 

        
        int[] arr6 = {};
        sort012(arr6);
        printArray(arr6);
    }
}
