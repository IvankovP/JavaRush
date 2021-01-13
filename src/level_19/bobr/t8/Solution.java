package level_19.bobr.t8;

import java.io.*;
import java.util.Scanner;

/*
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        String s;
        StringBuilder builder = new StringBuilder();

        while ((s = reader.readLine()) != null) {
            String[] arr = s.split(" ");
            for (String sArr : arr) {
                if (sArr.matches("(.*)[0-9](.*)")) builder.append(sArr).append(" ");
            }
        }
        writer.write(builder.toString().trim());

        writer.close();
        reader.close();
    }
}
