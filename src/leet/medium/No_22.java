package leet.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_22 {
    public static void main(String[] args) {
        No_22 main = new No_22();
        main.generateParenthesis(4);
    }
    public List<String> generateParenthesis(int n) {

        List<String> list= new ArrayList<>();
//        System.out.println(makeParenthesis(4));
        HashSet<String> set = new HashSet<>();
        strParenthesis(list,n,n,"");
        System.out.println(list);
        return list;
    }
    private List<Set<String>> cache =new ArrayList<>();
    private Set<String> makeParenthesis(int n){
        if(cache.size()>n){
            return cache.get(n);
        }
        Set<String> set=new HashSet<>();
        if(n<=0){
            set.add("");
        }else {
            for (String str : makeParenthesis(n - 1)) {
                set.add("(" + str + ")");
            }
            for (int i = 1; i <= n / 2; i++) {
                Set<String> list1 = makeParenthesis(i);
                Set<String> list2 = makeParenthesis(n - i);
                for (String str1 : list1) {
                    for (String str2 : list2) {
                        set.add(str1 + str2);
                        set.add(str2 + str1);
                    }
                }
            }
        }
        cache.add(n,set);
        return set;
    }
    private void strParenthesis(List<String> set, int open,int close,String org){
        if(open==0){
            for (int i = 0; i < close; i++) {
                org+=")";
            }
            set.add(org);
            return;
        }
        strParenthesis(set,open-1,close,org+"(");
        if(open<close)
            strParenthesis(set,open,close-1,org+")");
    }
}
