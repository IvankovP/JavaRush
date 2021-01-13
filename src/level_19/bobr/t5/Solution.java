package level_19.bobr.t5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s = "";
        Map<String, Double> map = new TreeMap<>();
        double maxValue = 0;

        while ((s = reader.readLine()) != null) {
            String[] strArr = s.split(" ");
            String key = strArr[0];
            double value = Double.parseDouble(strArr[1]);

            if (map.containsKey(key)) value += map.get(key);
            map.put(key, value);

            if (value > maxValue) maxValue = value;
        }
        reader.close();

        for (Map.Entry<String, Double> m : map.entrySet()) {
            if (m.getValue() == maxValue) System.out.println(m.getKey());
        }
    }
}