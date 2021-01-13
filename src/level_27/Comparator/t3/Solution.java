package level_27.Comparator.t3;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(Object o1, Object o2) {

            int result = 0;
            for (int i = 0; i < comparators.length; i++) {
                result = comparators[i].compare((T)o1, (T)o2);
                if (result != 0) return result;
            }
            return 0;
        }
    }
}
