package level_22.StringBuilder.t2;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {

        StringBuilder builder = new StringBuilder();

        for(Map.Entry<String, String> m : params.entrySet()) {
            String value = m.getValue();
            if (value == null) continue;

            builder.append(m.getKey() + " = '" + value + "' and ");
        }

        if (builder.length() == 0) return "";
        else return builder.delete(builder.length() - 5, builder.length()).toString().trim();
    }
}
