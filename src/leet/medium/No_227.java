package leet.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class No_227 {
    public static void main(String[] args) {
        No_227 main = new No_227();
        System.out.println(main.calculate("1*2-3/4+5*6-7*8+9/10"
        ));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack();

        String tmp = "";
        int num = 0;
        char op='+';
        for (int i = 0; i <= s.length(); i++) {
            char c;
            if(i==s.length()){
                c='+';
            }else{
                c = s.charAt(i);
            }
            if (c >= '0' && c <= '9') {
                num=num*10+(c-'0');
            }else if(c==' '){
             continue;
            }else{
                if(op=='+'){
                    stack.push(num);
                }else if(op=='-'){
                    stack.push(-1*num);
                }else if(op=='*'){
                    stack.push(stack.pop()*num);
                }else if(op=='/'){
                    stack.push(stack.pop()/num);
                }
                num=0;
                op=c;
            }
        }
        int res=0;
        while (!stack.empty()){
            res+=stack.pop();
        }
        return res;
    }
}
