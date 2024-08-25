package leet.medium;

public class No_553 {
    public static void main(String[] args) {
        No_553 main = new No_553();
        int[] nums = new int[0];
        main.optimalDivision(nums);
    }
    public String optimalDivision(int[] nums) {
        if(nums.length==1) return String.valueOf(nums[0]);
        if(nums.length==2) return nums[0]+"/"+nums[1];
        StringBuilder res= new StringBuilder(nums[0] + "/(");
        for (int i = 1; i < nums.length; i++) {
            res.append(nums[i]).append("/");
        }
        return res.substring(0,res.length()-1)+")";
    }
}
