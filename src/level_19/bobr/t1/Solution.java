package level_19.bobr.t1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменени
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        ArrayList<String> arrOrig = new ArrayList<>();
        ArrayList<String> arrUpdate = new ArrayList<>();

        reader = new BufferedReader(new FileReader(name));
        String s = "";
        while ((s = reader.readLine()) != null) {
            arrOrig.add(s);
        }
        reader.close();

        reader = new BufferedReader(new FileReader(name2));
        s = "";
        while ((s = reader.readLine()) != null) {
            arrUpdate.add(s);
        }
        reader.close();

        int indexOr = 0, indexUp = 0;
        while (indexOr < arrOrig.size()) {
            String orig = arrOrig.get(indexOr);
            String upd = indexUp < arrUpdate.size() ? arrUpdate.get(indexUp) : "";

            if (orig.equals(upd)) {
                lines.add(new LineItem(Type.SAME, orig));
                indexOr++;
                indexUp++;
            } else {
                if (indexUp + 1 < arrUpdate.size() && orig.equals(arrUpdate.get(indexUp + 1))) {
                    lines.add(new LineItem(Type.ADDED, upd));
                    indexUp++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, orig));
                    indexOr++;
                }
            }
        }
        if (indexUp < arrUpdate.size()) {
            for (int i = indexUp; i < arrUpdate.size(); i++) {
                lines.add(new LineItem(Type.ADDED, arrUpdate.get(i)));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена нова строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}