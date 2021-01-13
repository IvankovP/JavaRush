package level_18.bobr_7;

/*
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileInputStream fI = new FileInputStream(name);
        byte[] file1 = new byte[fI.available()];
        fI.read(file1);
        fI.close();

        FileOutputStream fO = new FileOutputStream(name);

        fI = new FileInputStream(name2);
        byte[] file2 = new byte[fI.available()];
        fI.read(file2);

        fO.write(file2);
        fO.write(file1);

        fI.close();
        fO.close();
    }
}
