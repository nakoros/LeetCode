package leet.medium;

public class No_788 {
    public static void main(String[] args) {
        No_788 main = new No_788();
        System.out.println(main.rotatedDigits(857));
    }
    public int rotatedDigits(int n) {
        //2 <-> 5
        //6 <-> 9
        //0,1,8 <-> 0,1,8

        int result=0;
        for (int i = 1; i <= n; i++) {
            int rotated = rotateResult(i);
            if(i!= rotated){
                System.out.println("Valid: "+n +" to "+rotated);
                result++;
            }
        }
        return result;
    }
    private int rotateResult(int n){
        int org= n;
        int result=0;
        int exp=1;
        while(n>0){
            int modVal = n % 10;
            int rotated = rotate(modVal);
            if(rotated==-1){
                return org;
            }
            result+= rotated *exp;
            n = n/10;
            exp*=10;
        }

        return result;
    }
    private int rotate(int n){
        switch (n){
            case 0: return 0;
            case 1: return 1;
            case 2: return 5;
            default: return -1;
            case 5: return 2;
            case 6: return 9;
            case 8: return 8;
            case 9: return 6;
        }
    }
}
