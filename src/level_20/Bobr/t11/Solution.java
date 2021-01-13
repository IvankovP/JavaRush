package level_20.Bobr.t11;

import java.util.HashMap;
import java.util.Map;

/*
Алгоритмы-прмоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 0},
                {0, 0}
        };
        byte[][] a2 = new byte[][]{
                {0, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 1, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    int countZero = 0;
                    boolean itsSame = false;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k < 0 || l < 0 || k > a.length - 1 || l > a[k].length - 1) continue;
                            if (a[k][l] == 0) countZero++;
                            if (map.containsKey(k) && map.get(k) == l) itsSame = true;
                        }
                    }
                    if (countZero >= 3) {
                        map.put(i, j);
                        if (!itsSame) count++;
                    }
                }
            }
        }
        return count;
    }
}
