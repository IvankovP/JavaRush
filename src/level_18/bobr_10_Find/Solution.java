package level_18.bobr_10_Find;

/*
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        if (args.length == 0) return;

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
        String s;
        while ((s = reader.readLine()) != null) {
            if (s.indexOf(args[0] + " ") == 0) System.out.println(s);
        }
        reader.close();
    }
}
