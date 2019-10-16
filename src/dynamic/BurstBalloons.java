package dynamic;

public class BurstBalloons {

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{}));
//        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));

    }

    public static int maxCoins(int[] nums) {
        int size = nums.length;
        if (size < 1) {
            return 0;
        }
        int[][] dp = new int[size][size];

        for (int length = 1; length <= size; length++) {
            for (int i = 0; i <= size - length; i++) {
                int j = i + length - 1;
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int leftNum = i == 0 ? 1 : nums[i - 1];
                    int rightNum = j == size - 1 ? 1 : nums[j + 1];
                    int leftValue = k == i ? 0 : dp[i][k - 1];
                    int rightValue = k == j ? 0 : dp[k + 1][j];
                    max = Math.max(max, leftValue + leftNum * nums[k] * rightNum + rightValue);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][size - 1];
    }
}
