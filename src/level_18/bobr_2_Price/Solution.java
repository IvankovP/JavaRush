package level_18.bobr_2_Price;

/*
Прайсы
D:\new.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        if (args.length == 0) return;

        if (args[0].equals("-c")) {

            FileInputStream fI = new FileInputStream(nameFile);
            BufferedWriter fO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile, true)));

            int id = 1;
            if (fI.available() != 0) {
                reader = new BufferedReader(new InputStreamReader(fI));

                String findStr = "";
                while ((findStr = reader.readLine()) != null) {
                    id = Math.max(Integer.parseInt(findStr.substring(0, 8).trim()), id);
                }

                reader.close();
            }
            fI.close();

            String nameProduct, price, quantity;
            if (args.length > 4) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < args.length - 2; i++) {
                    builder.append(args[i] + " ");
                }

                nameProduct = builder.toString();
                price = args[args.length - 2];
                quantity = args[args.length - 1];

                builder = null;
            } else {
                nameProduct = args[1];
                price = args[2];
                quantity = args[3];
            }

            fO.newLine();
            String newLine = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", ++id, nameProduct, price, quantity);
            fO.write(newLine);
            fO.close();
        }
    }
}
