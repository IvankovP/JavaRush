package level_18.bobr_8_Okruglenue;

/*
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
        FileOutputStream fO = new FileOutputStream(name2);
        StringBuilder builder = new StringBuilder();
        String s;
        String[] arr;

        while ((s = reader.readLine()) != null) {
            arr = s.split(" ");
            for (String ss : arr) {
                double d = Double.parseDouble(ss);
                builder.append(Math.round(d) + " ");
            }
        }
        fO.write(builder.toString().getBytes());
        fO.close();
        reader.close();
    }
}