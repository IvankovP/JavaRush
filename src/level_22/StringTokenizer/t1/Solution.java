package level_22.StringTokenizer.t1;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }

    public static String[] getTokens(String query, String delimiter) {

        if (query == null || query == "") return new String[0];

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        int count = 0;
        String[] result = new String[tokenizer.countTokens()];

        while (tokenizer.hasMoreTokens()) {
            result[count] = tokenizer.nextToken();
            count++;
        }

        return result;
    }
}
