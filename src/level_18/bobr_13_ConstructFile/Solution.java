package level_18.bobr_13_ConstructFile;

/*
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "", firstName = "";
        int numberParts = 0;
        FileInputStream fI = null;
        byte[] arrFile;
        BufferedOutputStream buff = null;
        Map<Integer, byte[]> map = new TreeMap<>();

        while (!(s = reader.readLine()).equals("end")) {
            if (firstName.equals("")) {
                firstName = s.substring(0, s.indexOf(".part"));
                buff = new BufferedOutputStream(new FileOutputStream(firstName));
            }
            numberParts = Integer.parseInt(s.substring(s.indexOf(".part") + 5, s.length()));

            fI = new FileInputStream(s);
            arrFile = new byte[fI.available()];
            fI.read(arrFile);
            fI.close();

            map.put(numberParts, arrFile);
        }
        for (Map.Entry<Integer, byte[]> m : map.entrySet()) buff.write(m.getValue());
        buff.close();
        reader.close();
    }
}

