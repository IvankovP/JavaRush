package level_18.bobr_1_Code;

/*
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fI = new FileInputStream(args[1]);
        FileOutputStream fO = new FileOutputStream(args[2]);

        switch (args[0]) {
            case ("-e") :
                byte[] buffer = new byte[fI.available()];
                if (fI.available() > 0) {
                    fI.read(buffer);
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i]++;
                    }
                    fO.write(buffer);
                }
                fI.close();
                fO.close();
                break;
            case ("-d") :
                buffer = new byte[fI.available()];
                if (fI.available() > 0) {
                    fI.read(buffer);
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i]--;
                    }
                    fO.write(buffer);
                }
                fI.close();
                fO.close();
                break;
        }
    }
}
