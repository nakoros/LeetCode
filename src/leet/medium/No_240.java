package leet.medium;

public class No_240 {
    public static void main(String[] args) {
        No_240 main = new No_240();
        int[][] matrix = {{3, 5, 9, 9, 14}, {7, 8, 11, 15, 15}, {8, 10, 16, 16, 17}};
        System.out.println(main.searchMatrix(matrix, 12));
    }

    int m, n;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;

        boolean result = false;
        if (m > n) {
            for (int i = 0; i < m; i++) {
                int y = i >= n ? n - 1 : i;
                if (matrix[i][y] >= target) {
                    result = position(matrix, i, y, target);
                }
                if (result)
                    return true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int x = i >= m ? m - 1 : i;
                if (matrix[x][i] >= target) {
                    result = position(matrix, x, i, target);
                }
                if (result)
                    return true;
            }
        }

        return false;
    }

    public boolean position(int[][] matrix, int x, int y, int target) {
        if (matrix[x][y] == target) {
            return true;
        }

        //find up
        if (findUp(matrix, x, y, target)) {
            return true;
        }
        //find left
        if (findLeft(matrix, x, y, target)) {
            return true;
        }

        return false;
    }

    boolean findUp(int[][] matrix, int x, int y, int target) {
        while (true) {
            x--;
            if(x<0)
                return false;
            int curValue = matrix[x][y];
            if (curValue == target)
                return true;
            if (curValue < target) {
                y++;
                if(y>=n)
                    return false;
                curValue = matrix[x][y];
                if (curValue == target)
                    return true;

                if(curValue>target)
                    break;
            }
        }
        return false;
    }

    boolean findLeft(int[][] matrix, int x, int y, int target) {
        while (true) {
            y--;
            if(y<0)
                return false;
            int curValue = matrix[x][y];
            if (curValue == target)
                return true;
            if (curValue < target) {
                x++;
                if(x>=m)
                    return false;
                curValue = matrix[x][y];
                if (curValue == target)
                    return true;

                if(curValue>target)
                    break;
            }
        }
        return false;
    }
}
