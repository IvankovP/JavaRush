package level_20.Bobr.t10;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    static long[][] matrix;
    static int[][] matrixSimbol;

    static {
        int lengthN = String.valueOf(Long.MAX_VALUE).length();
        matrix = new long[9][lengthN];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= lengthN; j++) {
                long step = 1;
                for (int k = 1; k <= j; k++) {
                    step = step * i;
                }
                matrix[i-1][j-1] = step;
            }
        }
        int start = 48;
        matrixSimbol = new int[58][1];
        for (int i = 0; i < 10; i++) {
            matrixSimbol[start][0] = i;
            start++;
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N <= 0) return new long[0];

        Set<Long> set = new TreeSet<>();

        long sum = 0;
        int lengthC = String.valueOf(N).length();
        StringBuilder value = new StringBuilder("");

        int[] arr = new int[lengthC];

        for (int i = 0; i < lengthC; i++) {
            arr[i] = 9;
        }

        while (true) {
            int j = 0;

            boolean first = false;
            for (int k = arr.length - 1; k > j; k--) {
                if (arr[k] > arr[k - 1] && arr[k - 1] < 0) {
                    if (!first) {
                        if (arr[k] == 0) arr[k - 1] = arr[k];
                        else arr[k - 1] = --arr[k];
                        first = true;
                    }
                    else arr[k - 1] = arr[k];
                    if (arr[k] < 0) {
                        k = arr.length - 1;
                        first = false;
                    }
                }
            }
            if (arr[arr.length - 1] <= 0) break;

            sum = 0;
            value.delete(0, value.length());

            int degree = lengthC;
            int countDegree = 0;

            while (true) {
                for (int k = countDegree; k < lengthC; k++) {
                    sum += arr[k] == 0 ? 0 : matrix[arr[k] - 1][degree - 1];
                    value.append(arr[k]);
                    if (sum < 0) break;
                }

                if (sum == Long.valueOf(value.toString()) && sum < N) {
                    set.add(sum);
                } else if (sum > 0 && sum < N) {

                    String arrC = String.valueOf(sum);
                    sum = 0;
                    value.delete(0, value.length());
                    char[] aaa = arrC.toCharArray();
                    for (char ch : aaa) {
                        int charInt = matrixSimbol[ch][0];
                        sum += charInt == 0 ? 0 : matrix[charInt - 1][aaa.length - 1];
                        value.append(ch);
                        if (sum < 0) break;
                    }

                    if (sum == Long.valueOf(value.toString()) && sum < N) {
                        set.add(sum);
                    }
                }

                if (arr[countDegree] == 0) {
                    degree--;
                    countDegree++;
                    sum = 0;
                    value.delete(0, value.length());
                }
                else break;
            }
            if (countDegree == 0) arr[0]--;
            else {
                for (int i = 0; i < countDegree; i++) {
                    arr[i]--;
                }
            }
        }

        result = new long[set.size()];
        int count = 0;
        for (Long l : set) {
            result[count] = l;
            count++;

        }

        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(5)));
        //System.out.println(Arrays.toString(getNumbers(370)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
