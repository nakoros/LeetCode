package leet.medium;

import java.util.*;

public class No_1535 {
    public static void main(String[] args) {
        No_1535 main=new No_1535();
        System.out.println(main.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
    }
    public int getWinner(int[] arr, int k){
        int winCount=0;
        List<Integer> list =new LinkedList<>();
        int max=0;
        for (int i : arr) {
            list.add(i);
            if(max<i){
                max=i;
            }
        }
        if(k>arr.length){
            return max;
        }

        int champ=-1;
        int challenger;

        while(winCount<k){
            champ=list.get(0);
            challenger=list.get(1);

            if(champ>challenger){
                winCount++;
                list.remove(1);
                list.add(challenger);
            }else{
                winCount=1;
                list.remove(0);
                list.add(champ);
            }
        }
        return list.get(0);
    }
}
