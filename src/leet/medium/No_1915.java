package leet.medium;

import java.util.HashMap;
import java.util.Map;


/**
 * Try again.
 *
 */
public class No_1915 {
    public static void main(String[] args) {
        No_1915 main = new No_1915();

        System.out.println(main.wonderfulSubstrings("aba"));
    }
    public long wonderfulSubstrings(String word) {
        long cnt=0;
        int length=word.length();
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length+1; j++) {
                Map<Character,Boolean> oddMap=new HashMap<>();

                for (int k = i; k < j; k++) {
                    char c = word.charAt(k);
                    if (oddMap.containsKey(c)) {
                        oddMap.put(c,!oddMap.get(c));
                    }else{
                        oddMap.put(c,true);
                    }
                }
                int oddCnt=0;
                for (Boolean odd : oddMap.values()) {
                    if(odd){
                        oddCnt++;
                    }
                    if(oddCnt>2)
                        break;
                }
                if(oddCnt<=1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
