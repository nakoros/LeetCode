package leet.challenge.september;

import java.util.Arrays;
import java.util.Collections;

public class Day5_OrderlyQueue {
    public static void main(String[] args) {
        Day5_OrderlyQueue main = new Day5_OrderlyQueue();
        System.out.println(main.orderlyQueue("cba", 1));

    }
    public String orderlyQueue(String s, int k){
        if(k>1) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            return new String(charArray);
        }
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
    }
}
