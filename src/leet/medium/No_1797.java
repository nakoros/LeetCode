package leet.medium;

import java.util.HashMap;
import java.util.Map;

public class No_1797 {
    public static void main(String[] args) {
        No_1797 main = new No_1797();
        AuthenticationManager mng = new AuthenticationManager(5);
        mng.renew("aaa",1);
        mng.generate("aaa",2);
        System.out.println(mng.countUnexpiredTokens(6));
        mng.generate("bbb",7);
        mng.renew("aaa",7);
        mng.renew("bbb",10);
        System.out.println(mng.countUnexpiredTokens(14));
        System.out.println(mng.countUnexpiredTokens(15));


    }

}


class AuthenticationManager {

    int tokenLife;
    Map<String,Integer> tokenExpiredTimeMap=new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        tokenLife=timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        progress(currentTime);
        tokenExpiredTimeMap.put(tokenId,currentTime+tokenLife);
    }

    public void renew(String tokenId, int currentTime) {
        progress(currentTime);
        if(tokenExpiredTimeMap.containsKey(tokenId)) {
            tokenExpiredTimeMap.put(tokenId, currentTime + tokenLife);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        progress(currentTime);
        return tokenExpiredTimeMap.size();
    }

    private void progress(int toTime){
        tokenExpiredTimeMap.entrySet().removeIf(entry -> entry.getValue()<=toTime);
    }
}