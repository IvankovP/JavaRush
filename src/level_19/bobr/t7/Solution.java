package level_19.bobr.t7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(name));
        String s;
        int count = 0;

        while ((s = reader.readLine()) != null) {
            String[] arr = s.split("[^a-zA-Zа-яА-Я0-9]");
            for (String sArr : arr) {
                if (words.contains(sArr)) count++;
            }
            if (count == 2) System.out.println(s);
            count = 0;
        }
        reader.close();
    }
}
