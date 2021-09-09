package leet.medium;

public class No_789 {
    public static void main(String[] args) {
        No_789 main = new No_789();
        System.out.println(main.escapeGhosts(new int[][]{{1,8},{-9,0},{-7,-6},{4,3},{1,3}}, new int[]{6,-9}));
    }
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minLen=Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            int len=Math.abs(ghost[0]-target[0])+Math.abs(ghost[1]-target[1]);
            minLen=Math.min(minLen,len);
        }
        int lenToTarget=Math.abs(target[0])+Math.abs(target[1]);

        return minLen>lenToTarget;
    }
}
