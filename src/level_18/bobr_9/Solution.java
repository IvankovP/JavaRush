package level_18.bobr_9;

/*
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        Map<Integer, Integer> map = new TreeMap<>();

        FileInputStream fI = new FileInputStream(args[0]);

        while (fI.available() > 0) {
            int simv = fI.read();
            if (!map.containsKey(simv)) map.put(simv, 1);
            else map.put(simv, map.get(simv) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) System.out.println((char) m.getKey().intValue() + " " + m.getValue());

        fI.close();
    }
}