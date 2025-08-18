public class InPlaceMerge {

    
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }


    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int gap = nextGap(m + n);

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < m + n) {
                
                int val1, val2;
                
        
                if (i < m) val1 = arr1[i];
                else val1 = arr2[i - m];

                
                if (j < m) val2 = arr1[j];
                else val2 = arr2[j - m];

                
                if (val1 > val2) {
                    if (i < m && j < m) {
                
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    } else if (i < m && j >= m) {
        
                        int temp = arr1[i];
                        arr1[i] = arr2[j - m];
                        arr2[j - m] = temp;
                    } else {
                
                        int temp = arr2[i - m];
                        arr2[i - m] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        merge(arr1, arr2);

        System.out.print("arr1 = ");
        for (int num : arr1) System.out.print(num + " ");
        System.out.println();

        System.out.print("arr2 = ");
        for (int num : arr2) System.out.print(num + " ");
    }
}
