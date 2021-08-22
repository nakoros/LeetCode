package leet.medium;

public class No_873 {
    public static void main(String[] args) {
        No_873 main = new No_873();
        System.out.println(main.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int longestFib=0;
        for (int start = 0; start < arr.length-1; start++) {
            for (int second = start+1; second < arr.length; second++) {
                int x1=start,x2=second;
                int lengthOfFib=2;
                while(true) {
                    int nextIdx = nextFibonacciIndex(x1, x2, arr);
                    if(nextIdx==-1){
                        break;
                    }
                    lengthOfFib++;
                    x1=x2;
                    x2=nextIdx;
                }
                if(longestFib<lengthOfFib){
                    longestFib=lengthOfFib;
                }
            }
        }
        if(longestFib==2){
            return 0;
        }
        return longestFib;
    }
    public int nextFibonacciIndex(int index1, int index2, int[] arr){
        int nextSum=arr[index1]+arr[index2];
        int nextIdx=index2+1;
        for(;nextIdx<arr.length;nextIdx++){
            if(nextSum>arr[nextIdx]){
                continue;
            }else if(nextSum==arr[nextIdx]){
                return nextIdx;
            }else{
                break;
            }
        }

        return -1;
    }
}
