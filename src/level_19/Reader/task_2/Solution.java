package level_19.Reader.task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name);
        reader = new BufferedReader(fileReader);

        int count = 0;
        while (reader.ready()) {
            for (String s : reader.readLine().split("\\W")) {
                if (s.equals("world")) count++;
            }
        }

        fileReader.close();
        reader.close();
        System.out.println(count);
    }
}