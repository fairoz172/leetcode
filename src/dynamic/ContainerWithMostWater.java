package dynamic;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{}));
//        System.out.println(maxArea(new int[]{1, 5, 3, 2, 5, 2, 4}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            System.out.println("i = " + i);
            for (int j = i + 1; j < height.length; j++) {
                int h = height[i] < height[j] ? height[i] : height[j];
                int w = j - i;
                max = Math.max(max, h * w);
            }
        }
        return max;
    }
}
