package leet.hard;

public class No_154 {
    public static void main(String[] args) {
        No_154 main=new No_154();
        System.out.println(main.findMin(new int[]{2,2,2,0,1}));
    }
    public int findMin(int[] nums) {
        int hi,lo,mid;
        if(nums[0]>=nums[nums.length-1]){//is rotate
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]<nums[0]){
                    return nums[i];
                }
            }
            return nums[0];
        }else{
            return nums[0];
        }
    }
}
