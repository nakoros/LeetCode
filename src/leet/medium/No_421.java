package leet.medium;

public class No_421 {
    public static void main(String[] args) {
        No_421 main = new No_421();
        int mask=0;
        System.out.println(1<<0);
        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(1<<3);
        System.out.println(1<<4);

//        System.out.println(main.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }

    public int findMaximumXOR(int[]nums) {
        int maxXor = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^nums[j];
                maxXor=Math.max(xor, maxXor);
            }
        }
        return maxXor;

        /*
         int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
        * */
    }
}
