package level_19.Reader.task_1;

import java.io.*;
import java.util.ArrayList;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        int count = 1;
        FileReader fileReader = new FileReader(name);
        FileWriter fileWriter = new FileWriter(name2);

        while (fileReader.ready()) {
            if (count % 2 == 0) fileWriter.write(fileReader.read());
            else fileReader.read();
            count++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
