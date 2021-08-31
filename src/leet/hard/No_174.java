package leet.hard;

public class No_174 {
    public static void main(String[] args) {
        No_174 main = new No_174();
        System.out.println(main.calculateMinimumHP(new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}}));
    }
    public int calculateMinimumHP(int[][] dungeon) {

        int[][] dpHealth=new int[dungeon.length][dungeon[0].length];
        int[][] dpDamage=new int[dungeon.length][dungeon[0].length];

        int xEnd=dungeon.length;
        int yEnd=dungeon[0].length;
        for (int x = 0; x < xEnd; x++) {
            for (int y = 0; y < yEnd; y++) {
                int pastHealth=0;
                int pastDamage=0;
                //up val
                if(x==0&&y==0){
                    pastDamage=0;
                    pastHealth=1;
                }else if(x!=0 && y==0){
                    pastDamage=dpDamage[x-1][y];
                    pastHealth=dpHealth[x-1][y];
                }else if(x==0 && y!=0){
                    pastDamage=dpDamage[x][y-1];
                    pastHealth=dpHealth[x][y-1];
                }else{
//                    pastDamage=Math.max(dpDamage[x-1][y],dpDamage[x][y-1]);
//
//                    pastHealth=Math.min(dpHealth[x-1][y],dpHealth[x][y-1]);
                    if(dpHealth[x-1][y]>dpHealth[x][y-1]){
                        pastHealth=dpHealth[x][y-1];
                        pastDamage=dpDamage[x][y-1];
                    }else if(dpHealth[x-1][y]==dpHealth[x][y-1]){
                        if(dpDamage[x-1][y]>dpDamage[x][y-1]){
                            pastHealth=dpHealth[x-1][y];
                            pastDamage=dpDamage[x-1][y];
                        }else{
                            pastHealth=dpHealth[x][y-1];
                            pastDamage=dpDamage[x][y-1];
                        }
                    }else{
                        pastHealth=dpHealth[x-1][y];
                        pastDamage=dpDamage[x-1][y];
                    }
                }
                dpDamage[x][y]=pastDamage+dungeon[x][y];
                dpHealth[x][y]=Math.max(pastHealth,dpDamage[x][y]>0?0:-(dpDamage[x][y]-1));
            }
        }

        return dpHealth[dungeon.length-1][dungeon[0].length-1];
    }
}
