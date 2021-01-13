package level_18.bobr_11_ThreadsAndBytes;

/*
Нити и байты
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")) {
            new ReadThread(s);
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            start();
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream fI = null;
            try {
                fI = new FileInputStream(this.fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                byte[] arr = new byte[fI.available()];
                fI.read(arr);

                int maxCount = 0, count = 0, maxByte = 0;
                for (int i = 0; i < arr.length; i++) {
                    count = 0;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i] == arr[j]) count++;
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        maxByte = arr[i];
                    }
                }
                resultMap.put(this.fileName, maxByte);
                fI.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
