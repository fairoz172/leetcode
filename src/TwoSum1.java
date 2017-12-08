import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static void main(String[] args) {
        TwoSum1 twoSum1 = new TwoSum1();
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum1.twoSum(array, 17);
        System.out.println(result[0]+","+result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int n = target - nums[i];
            if(map.containsKey(n)){
                result[0] = map.get(n);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
