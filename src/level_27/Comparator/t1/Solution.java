package level_27.Comparator.t1;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = {13, 8, 15, 18, 14, 11, 12};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double mediana = 0;

        Arrays.sort(array);
        if (array.length % 2 == 0) {
            mediana = (array[((array.length - 1)/2)] + array[((array.length - 1)/2 + 1)]) * 0.5;
        } else {
            mediana = array[((array.length - 1)/2)];
        }

        System.out.println(mediana);

        double finalMediana = mediana;
        Comparator<Integer> myComparator = new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(finalMediana - o1) > Math.abs(finalMediana - o2)) {
                    return 1;
                } else if (Math.abs(finalMediana - o1) < Math.abs(finalMediana - o2)) {
                    return -1;
                } else {
                    return Integer.compare(o1, o2);
                }
            }
        };

        Arrays.sort(array, myComparator);

        return array;
    }
}
