package level_22.StringTokenizer.t2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        FileInputStream reader = new FileInputStream(args[0]);
        byte[] bytes = new byte[reader.available()];
        reader.read(bytes);
        reader.close();

        String s = new String(bytes, Charset.forName("Windows-1251"));

        FileOutputStream writer = new FileOutputStream(args[1]);
        writer.write(s.getBytes(StandardCharsets.UTF_8));
        writer.close();
    }
}
