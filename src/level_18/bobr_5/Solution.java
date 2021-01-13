package level_18.bobr_5;

/*
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        if (args.length == 0) return;

        FileInputStream fI = new FileInputStream(args[0]);

        int countProb = 0, countSimv = 0;

        while (fI.available() > 0) {
            int simvol = fI.read();
            if (simvol == 32) countProb++;
            countSimv++;
        }
        System.out.println(String.format("%.2f",countProb * 1.0 / countSimv * 100));
        fI.close();
    }
}
