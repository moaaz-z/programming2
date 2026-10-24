package Question3;

public class Exercise {
    public int[] twoSum(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {
            for(int j=index+1; j<nums.length;j++){
                if(nums[index]+nums[j]==target){
                    return new int[] {index,j};
                }
            }
        }
        return new int[]{};
      }
}
