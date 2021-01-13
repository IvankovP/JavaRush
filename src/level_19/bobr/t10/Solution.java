package level_19.bobr.t10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);

        String s, input = "", output = "";

        while ((s = reader.readLine()) != null) {
            input += s + " ";
        }
        String[] arr = input.trim().split(" ");
        for (String sArr : arr) {
            if (sArr.length() > 6) output += sArr + ",";
        }

        writer.write(output.substring(0, output.length() - 1));

        reader.close();
        writer.close();
    }
}