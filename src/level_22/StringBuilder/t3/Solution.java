package level_22.StringBuilder.t3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/

//трам Нет труД муд доМ мандарин март

public class Solution {
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

        StringBuilder result = getLine(builder.toString().trim().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        int startCount = 0;
        StringBuilder builder = null;

        while (list.size() != words.length && startCount < words.length) {

            builder = new StringBuilder(words[startCount]);
            String endChar = builder.substring(builder.length() - 1, builder.length());
            list.add(startCount);

            for (int i = 0; i < words.length; i++) {
                if (list.contains(i)) continue;
                if (words[i].substring(0, 1).equalsIgnoreCase(endChar)) {
                    endChar = words[i].substring(words[i].length() - 1);
                    builder.append(" " + words[i]);
                    list.add(i);
                    i = 0;
                }
            }

            if (list.size() != words.length) {
                list.clear();
                startCount++;
            }
        }

        return builder;
    }
}
