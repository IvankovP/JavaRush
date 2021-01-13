package level_19.bobr.t3;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name);
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) builder.append((char)fileReader.read());
        fileReader.close();

        String fullStr = builder.toString();

        Map<Integer, String> map = new TreeMap<>();
        int indexBegin = -1, indexEnd = -1;
        while (true) {
            indexBegin = fullStr.indexOf("<" + args[0], indexBegin + 1);
            indexEnd = fullStr.indexOf("</" + args[0], indexEnd + 1);

            if (indexBegin >= 0) map.put(indexBegin, "begin");
            if (indexEnd >= 0) map.put(indexEnd, "end");

            if (indexEnd < 0) break;
        }

        int count = 0;
        indexBegin = -1;
        indexEnd = -1;
        while (map.size() > 0) {
            for (Map.Entry<Integer, String> m : map.entrySet()) {
                if (m.getValue().equals("begin") && indexBegin < 0) indexBegin = m.getKey();
                else if (m.getValue().equals("begin") && indexBegin >= 0) count++;

                if (m.getValue().equals("end") && count == 0) {
                    indexEnd = m.getKey();
                    break;
                }
                else if (m.getValue().equals("end") && count != 0) count--;
            }

            System.out.println(fullStr.substring(indexBegin, indexEnd + args[0].length() + 3));
            map.remove(indexBegin);
            map.remove(indexEnd);
            indexBegin = -1;
            indexEnd = -1;
        }
    }
}
