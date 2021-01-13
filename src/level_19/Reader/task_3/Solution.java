package level_19.Reader.task_3;

import java.io.*;
import java.util.ArrayList;

/*
Выделем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(name));
        BufferedWriter writer = new BufferedWriter(new FileWriter(name2));

        String s = "";
        StringBuilder builder = new StringBuilder();

        while ((s = reader.readLine()) != null) {
            for (String ss : s.split(" ")) {
                try {
                    builder.append(String.valueOf(Integer.parseInt(ss)) + " ");
                } catch (NumberFormatException e) {

                }
            }
        }
        if (builder.length() > 0) {
            writer.write(builder.toString());
        }

        writer.close();
        reader.close();
    }
}