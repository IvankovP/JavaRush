package level_22.StringBuilder.t1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        reader.close();

        String s;
        StringBuilder builder = new StringBuilder();
        while ((s = readerFile.readLine()) != null) {
            builder.append(" ").append(s);
        }
        readerFile.close();

        String[] arrStr = builder.toString().trim().split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arrStr.length - 1; i++) {
            for (int j = i + 1; j < arrStr.length; j++) {
                if (list.contains(i) || list.contains(j)) continue;
                builder.delete(0, builder.length());
                if (arrStr[i].equals(builder.append(arrStr[j]).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = arrStr[i];
                    pair.second = arrStr[j];
                    result.add(pair);
                    list.add(i);
                    list.add(j);
                }
            }
        }

        for (Pair p : result) System.out.println(p.toString());
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
