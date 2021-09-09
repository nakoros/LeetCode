package leet.hard;

public class No_1944 {
    public static void main(String[] args) {
        No_1944 main = new No_1944();

        String s="";
        for (int i : main.canSeePersonsCount(new int[]{10,9,8,7,6,5,4,3,2})) {
            s+=","+i;
        }
        System.out.println(s);
    }
    public int[] canSeePersonsCount(int[] heights) {
        int see[]=new int[heights.length];
        int nextTall[]=new int[heights.length];
        for (int i = heights.length-1; i >= 0; i--) {
            int maxH=0;
            int nextSee=i+1;
            nextTall[i]=-1;
            while(true){
                if(maxH>=heights[i]||nextSee==heights.length||nextSee==-1){
                    break;
                }
                if(maxH<heights[nextSee]){
                    see[i]++;
                    maxH=heights[nextSee];
                    if(maxH>heights[i])
                        nextTall[i]=nextSee;
                }
                nextSee=nextTall[nextSee];
            }

        }

//        for (int i = 0; i < heights.length; i++) {
//            int maxH=0;
//            int nextSee=i+1;
//            while(true){
//                if(maxH>=heights[i]||nextSee==heights.length){
//                    break;
//                }
//                if(maxH<heights[nextSee]){
//                    see[i]++;
//                    maxH=heights[nextSee];
//                }
//                nextSee++;
//
//            }
//        }
        return see;

    }
}
