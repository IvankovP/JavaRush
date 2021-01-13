package level_20.SaveObjects.t3;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws IOException {
        //напишите тут ваш код
        Properties prop = new Properties();
        prop.putAll(runtimeStorage);
        prop.store(outputStream, "");
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> m :
             prop.entrySet()) {
            runtimeStorage.put((String) m.getKey(), (String) m.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);

        try (FileOutputStream fos = new FileOutputStream("d:/new2.txt")) {
            save(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
