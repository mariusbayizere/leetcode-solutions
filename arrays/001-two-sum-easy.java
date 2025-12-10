import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int [] array = new int[2];
        int i, j;
        for(i = 0; i < (nums.length - 1); i++){
            for(j = i + 1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                    break;
                }
            }
        }

        return array;
    }


    public static void main(String[] args) {
        Solution ob = new Solution();
        int [] result = ob.twoSum(new int[] {2,7,11,15}, 9);

        System.out.println(Arrays.toString(result));
    }

}