public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        main.ZigZagConversion("ABC", 2);
        System.out.println(main.AtoI(" 42 ei"));

    }

    public static String ZigZagConversion(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] zigZagStr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            zigZagStr[i] = "";
        }
        int row = 1;
        boolean forwardUp = false;
        for (int i = 0; i < s.length(); i++) {
            zigZagStr[row - 1] = zigZagStr[row - 1] + s.charAt(i);
            if (!forwardUp) {
                if (row == numRows) {
                    forwardUp = true;
                    row--;
                } else {
                    row++;
                }
            } else {
                if (row == 1) {
                    forwardUp = false;
                    row++;
                } else {
                    row--;
                }
            }

        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += zigZagStr[i];
        }
        System.out.println(res);

        return res;
    }

    public static int ReverseInteger(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }

    public static int AtoI(String str) {
        int len = str.length();
        boolean validFormat = true;
        boolean numberStart = false;
        boolean isNegative = false;
        long res = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!numberStart && c == ' ') {
                continue;
            } else if (!numberStart && c == '-') {
                isNegative = true;
                numberStart = true;
            }else if (!numberStart && c == '+') {
                numberStart = true;
            } else if (c >= '0' && c <= '9') {
                numberStart = true;

                res = res * 10 + (c - '0');
                if(!isNegative&&res>Integer.MAX_VALUE){
                    return    Integer.MAX_VALUE;
                }else if(isNegative&&-1*res<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            } else if (numberStart) {
                break;
            } else {
                validFormat = false;
                break;
            }
        }

        if (!validFormat)
            return 0;

        if (isNegative)
            res = res * -1;

        if(res>Integer.MAX_VALUE){
            return    Integer.MAX_VALUE;
        }else if(res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)res;
    }
}
