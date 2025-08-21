public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int[] height3 = {1, 1, 1};
        int[] height4 = {5};
        int[] height5 = {2, 0, 2};
        int[] height6 = {0, 0, 0}; 
        int[] height7 = {1, 2, 3}; 
        int[] height8 = {3, 2, 1}; 

        System.out.println(trap(height1)); 
        System.out.println(trap(height2)); 
        System.out.println(trap(height3)); 
        System.out.println(trap(height4)); 
        System.out.println(trap(height5)); 
        System.out.println(trap(height6)); 
        System.out.println(trap(height7)); 
        System.out.println(trap(height8)); 
    }
}
