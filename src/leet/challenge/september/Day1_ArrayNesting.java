package leet.challenge.september;

public class Day1_ArrayNesting {
    public static void main(String[] args) {
        Day1_ArrayNesting main = new Day1_ArrayNesting();
        System.out.println(main.arrayNesting(new int[]{0}));
    }

    public int arrayNesting(int[] nums) {
        int longestLength = 0;
        for (int k = 0; k < nums.length; k++) {
            boolean duplicate[] = new boolean[nums.length];

            int length=0;
            int nextIdx = k;
            while (!duplicate[nextIdx]) {
                duplicate[nextIdx]=true;
                nextIdx=nums[nextIdx];
                length++;
            }
            longestLength=Math.max(longestLength,length);
        }
        return longestLength;
    }
}
