package leet.easy;

import java.util.Locale;

public class No_125 {
    public static void main(String[] args) {
        No_125 main = new No_125();
        System.out.println(main.isPalindrome(".,"));
    }
    public boolean isPalindrome(String s) {
        int front=0,end=s.length()-1;
        while(front<end){
            char f;
            do {
                f=s.charAt(front);
                front++;
                if(front>=s.length()){
                    f='a';
                }
                if(f>='A'&&f<='Z'){
                    f= (char) (f-'A'+'a');
                }
            }while (!((f>='a'&&f<='z')||(f>='0'&&f<='9')));
            char e;
            do {
                e=s.charAt(end);
                end--;
                if(end<0){
                    e='a';
                }
                if(e>='A'&&e<='Z'){
                    e= (char) (e-'A'+'a');
                }
            }while (!((e>='a'&&e<='z')||(e>='0'&&e<='9')));
            if(e!=f){
                return false;
            }
        }
        return true;
    }
}
