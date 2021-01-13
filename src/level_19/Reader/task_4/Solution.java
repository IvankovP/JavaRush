package level_19.Reader.task_4;

import java.io.*;
import java.util.ArrayList;

/*
Замена знаков
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
        while ((s = reader.readLine()) != null) {
            writer.write(s.replace(".", "!"));
            writer.newLine();
        }

        writer.close();
        reader.close();
    }
}

