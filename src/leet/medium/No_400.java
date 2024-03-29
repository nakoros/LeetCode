package leet.medium;

public class No_400 {
    public static void main(String[] args) {
        No_400 main = new No_400();

        System.out.println(main.findNthDigit(6));
        System.out.println(main.findNthDigit(7));
        System.out.println(main.findNthDigit(8));
        System.out.println(main.findNthDigit(9));

    }
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
