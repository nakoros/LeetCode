package leet.medium;

public class No_790 {
    public static void main(String[] args) {
        No_790 main = new No_790();

        System.out.println(main.numTilings(30));
    }
    public int numTilings(int n) {
        int mod=1000000007;
        if(n==0){
            return 0;
        }
        int[] dp=new int[n+3];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=2*dp[i-1]%mod+dp[i-3];
            dp[i]%=mod;
        }

//        return ((Long)dp[n]).intValue();
        return dp[n];
    }
}
