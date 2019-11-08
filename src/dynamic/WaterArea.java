package dynamic;

public class WaterArea {

    public static void main(String[] args) {
        int[] pillerHeights = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(pillerHeights));
    }

    public static int waterArea(int[] heights) {
        int waterArea = 0;
        int[] leftMaxArray = new int[heights.length];
        int[] rightMaxArray = new int[heights.length];

        int leftMax = 0;
        for (int i=0; i<heights.length; i++){
            leftMaxArray[i] = leftMax;
            if (heights[i] > leftMax){
                leftMax = heights[i];
            }
        }
        int rightMax = 0;
        for (int i=heights.length-1; i>=0; i--){
            rightMaxArray[i] = rightMax;
            if (heights[i] > rightMax){
                rightMax = heights[i];
            }
        }
        int minHeight = 0;
        for(int i =0; i< heights.length; i++){
            minHeight = Math.min(leftMaxArray[i], rightMaxArray[i]);
            if (heights[i]<minHeight){
                waterArea += minHeight - heights[i];
            }
        }
        return waterArea;
    }
}
