package level_18.bobr_4_Eng;

/*
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 0) return;

        FileInputStream fI = new FileInputStream(args[0]);
        int count = 0;

        while (fI.available() > 0) {
            int eng = fI.read();
            if ((eng >= 65 && eng <= 90) || (eng >= 97 && eng <= 122)) count++;
        }
        fI.close();
        System.out.println(count);
    }
}
