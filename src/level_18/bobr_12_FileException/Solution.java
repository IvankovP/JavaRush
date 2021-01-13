package level_18.bobr_12_FileException;

/*
Файлы и исключени
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        FileInputStream fI = null;
        while (true) {
            try {
                s = reader.readLine();
                fI = new FileInputStream(s);
                fI.close();
            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            }
        }
        reader.close();
        return;
    }
}
