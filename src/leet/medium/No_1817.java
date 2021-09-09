package leet.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No_1817 {
    public static void main(String[] args) {
        No_1817 main = new No_1817();
        int[] ints = main.findingUsersActiveMinutes(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5);
        for (int anInt : ints) {
            System.out.print(","+anInt);
        }
    }
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMap=new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int id=logs[i][0];
            int min=logs[i][1];
            Set<Integer> actMin = userMap.get(id);
            if (actMin==null) {
                actMin=new HashSet<>();
                userMap.put(id,actMin);
            }
            actMin.add(min);
        }
        int[] result=new int[k];
        for (Set<Integer> value : userMap.values()) {
            result[value.size()-1]++;
        }
        return result;
    }
}
