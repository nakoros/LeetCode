package leet.hard;

import java.util.Arrays;
import java.util.TreeSet;

public class No_1889 {
    public static void main(String[] args) {
        No_1889 main = new No_1889();
        System.out.println();
    }
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int maxPackage=packages[packages.length-1];

        for (int i = 0; i < boxes.length; i++) {
            Arrays.sort(boxes[i]);
        }
        TreeSet<Integer> packageTree=new TreeSet<>();
        for (int aPackage : packages) {
            packageTree.add(aPackage);
        }
        int minWasted=Integer.MAX_VALUE;
        boolean noSize=true;
        for (int[] box : boxes) {
            if (maxPackage > box[box.length - 1]) {
                continue;
            }
            noSize = false;
            if(box.length>=packages.length){

            }else{

            }
        }



//        int minWasted=Integer.MAX_VALUE;
//        boolean noSize=true;
//        for (int[] box : boxes) {
//            if(maxPackage>box[box.length-1]){
//                continue;
//            }
//            noSize=false;
//            int wasted=0;
//            int prevIndex=0;
//            for (int aPackage : packages) {
//                for (int i = prevIndex; i < box.length ; i++) {
//                    if(aPackage<=box[i]){
//                        wasted+=box[i]-aPackage;
//                        wasted%=1000000007;
//                        prevIndex=i;
//                        break;
//                    }
//                }
//            }
//            if(wasted<minWasted){
//                minWasted=wasted;
//            }
//        }
        if (noSize) {
            return -1;
        }
        else{
            return minWasted;
        }
    }
}
