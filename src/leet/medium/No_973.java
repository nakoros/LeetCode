package leet.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No_973 {
    public static void main(String[] args) {
        No_973 main = new No_973();

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        for (int[] point : points) {
            queue.add(point);
        }

        int[][] result=new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] p = queue.poll();
            result[i][0]=p[0];
            result[i][1]=p[1];
        }

        return result;
    }
}
