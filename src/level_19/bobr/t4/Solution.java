package level_19.bobr.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s = "";
        Map<String, Double> map = new TreeMap<>();

        while ((s = reader.readLine()) != null) {
            String[] strArr = s.split(" ");
            String key = strArr[0];
            double value = Double.parseDouble(strArr[1]);

            if (map.containsKey(key)) map.put(key, value + map.get(key));
            else map.put(key, value);
        }
        reader.close();

        for (Map.Entry<String, Double> m : map.entrySet()) System.out.println(m.getKey() + " " + m.getValue());
    }
}